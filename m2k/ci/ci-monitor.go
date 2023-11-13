package main

import (
	"context"
	"os"
	"strings"
	"sync"
	"sync/atomic"
	"time"

	log "github.com/sirupsen/logrus"
	appsv1 "k8s.io/api/apps/v1"
	metav1 "k8s.io/apimachinery/pkg/apis/meta/v1"
	"k8s.io/apimachinery/pkg/watch"
	"k8s.io/client-go/kubernetes"
	"k8s.io/client-go/tools/cache"
	"k8s.io/client-go/tools/clientcmd"
	toolsWatch "k8s.io/client-go/tools/watch"
)

const (
	createPlanDeploymentName         = "m2k-create-plan-func"
	saveTransformationDeploymentName = "m2k-save-transformation-func"
)

var (
	config, _                   = clientcmd.BuildConfigFromFlags("", os.Getenv("KUBECONFIG"))
	clientset, _                = kubernetes.NewForConfig(config)
	wg                          sync.WaitGroup
	createPlanExecuting         = atomic.Bool{}
	createPlanDone              = atomic.Bool{}
	saveTransformationExecuting = atomic.Bool{}
	saveTransformationDone      = atomic.Bool{}
)

func watchDep() {

	watchFunc := func(options metav1.ListOptions) (watch.Interface, error) {
		timeOut := int64(60)
		return clientset.AppsV1().Deployments("default").Watch(context.Background(), metav1.ListOptions{TimeoutSeconds: &timeOut})
	}

	watcher, _ := toolsWatch.NewRetryWatcher("1", &cache.ListWatch{WatchFunc: watchFunc})
	createPlanExecuting.Store(false)
	createPlanDone.Store(false)
	saveTransformationExecuting.Store(false)
	saveTransformationDone.Store(false)
	for event := range watcher.ResultChan() {
		item := event.Object.(*appsv1.Deployment)

		switch event.Type {
		case watch.Modified:
			if strings.HasPrefix(item.GetName(), createPlanDeploymentName) {
				evaluateCreatePlanFunctionStatus(item)
			} else {
				if evaluateSaveTransformationFunctionStatus(item) {
					return
				}
			}
		case watch.Bookmark:
		case watch.Error:
		case watch.Deleted:
		case watch.Added:
		}
	}
}

func evaluateCreatePlanFunctionStatus(item *appsv1.Deployment) {
	if *item.Spec.Replicas > 0 && !createPlanExecuting.Load() {
		log.Infof("Function %s has started", item.GetName())
		createPlanExecuting.Store(true)
	} else {
		if *item.Spec.Replicas <= 0 && createPlanExecuting.Load() && !createPlanDone.Load() {
			log.Infof("Function %s is completed", item.GetName())
			createPlanDone.Store(true)
			log.Infof("Waiting for function %s to be started for 4min, otherwise panic\n", saveTransformationDeploymentName)
			time.AfterFunc(4*time.Minute, func() {
				if !saveTransformationExecuting.Load() {
					log.Panicf("Function %s was not started 4 minutes after the plan creation was completed", saveTransformationDeploymentName)
				}
			})
		}
	}
}

func evaluateSaveTransformationFunctionStatus(item *appsv1.Deployment) bool {
	if strings.HasPrefix(item.GetName(), saveTransformationDeploymentName) {
		if !createPlanExecuting.Load() && !createPlanDone.Load() {
			log.Panicf("Function %s was not started or completed before %s function is started", saveTransformationDeploymentName, createPlanDeploymentName)
		}
		if *item.Spec.Replicas > 0 && !saveTransformationExecuting.Load() {
			log.Infof("Function %s has started", item.GetName())
			saveTransformationExecuting.Store(true)
		} else {
			if *item.Spec.Replicas <= 0 && saveTransformationExecuting.Load() && !saveTransformationDone.Load() {
				log.Infof("Function %s is completed, exiting monitoring program", item.GetName())
				saveTransformationDone.Store(true)
				wg.Done()
				return true
			}
		}
	}
	return false
}

func main() {
	go watchDep()
	wg.Add(1)
	wg.Wait()
}
