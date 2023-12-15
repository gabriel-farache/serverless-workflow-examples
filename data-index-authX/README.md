# DataIndex AuthX
This project aims to secure the DataIndex graphQL endpoint.
There are 2 options:
1. setup an HTTPD in front of the DataIndex
2. use a custom DataIndex imdage with authorization properties already set

## Minikube
As we will be using `NetworkPolicies` we will need to have a CNI to enforce those policies. Here we are choosing `Cilium`
```shell
minikube start --cni cilium
```

## Keycloak
### Deploy
Follow https://www.keycloak.org/getting-started/getting-started-kube

Then write down somewhere the Keycloak ingress address you got from
```shell
KEYCLOAK_URL=https://keycloak.$(minikube ip).nip.io &&
echo "" &&
echo "Keycloak:                 $KEYCLOAK_URL" &&
echo "Keycloak Admin Console:   $KEYCLOAK_URL/admin" &&
echo "Keycloak Account Console: $KEYCLOAK_URL/realms/myrealm/account" &&
echo ""
```

If the address displayed above is not working, edit the `keycloak` ingress to change the host(s) to `keycloak.test`; it might solve the DNS issue


### Configuration

* create a new realm (in this project it is named `Orchestrator`).
* create a new user
* set the user's credentials
* create a new role named `dataIndex_users`
  * you could name it anything else but you would need to update the claim in the [oauth2.conf](oauth2.conf) file
* assign the role to the user
* create a new client
  * in our case we named it `data-index`
  * write down the `secret` somewhere (you can copy it from the `Credentials` tab of the client)
* add a new scope to this client so the assigned roles are included in the access token
  * under the `Client scopes` tab, click on `data-index-dedicated`
  * then click on `Add mapper` and select `From predefined mappers`
  * search for `group`
  * add the mapper

To generate an access token, run:
```bash
export access_token=$(\
    curl --insecure -X POST https://<keycloak address>/realms/Orchestrator/protocol/openid-connect/token \
    --user data-index:<client secret> \
    -H 'content-type: application/x-www-form-urlencoded' \
    -d 'username=<user>&password=<user password>&grant_type=password' | jq --raw-output '.access_token' \
 )
echo "$access_token"
```


## DataIndex
See the section "Deploy PostgreSQL, Data Index, Jobs Service" in the [README.md](../deployment/kustomize/README.md#deploy-postgresql-data-index-jobs-service)

### With custom image
If you want to use option #2, you will need to 
* update the data index image of [data-index.yaml](..%2Fdeployment%2Fkustomize%2Fsonataflow%2Faddons%2Fdata-index%2Fdata-index.yaml) by `quay.io/orchestrator/kogito-data-index-postgresql:1.44.1.Final.AuthZ`
* add the following properties in [application.properties](..%2Fdeployment%2Fkustomize%2Fsonataflow%2Faddons%2Fdata-index%2Fapplication.properties):
```
quarkus.oidc.auth-server-url=https://<keycloak host>/realms/Orchestrator
quarkus.oidc.client-id=<keycloak client>
quarkus.oidc.credentials.secret=<keycloak client secret>
quarkus.oidc.tls.verification=<none for test, true otherwise>
```
* create a new role `data-index-user` in keycloak and assign it a user to grant access to the `graphql` endpoint
#### Test
Then you can test:
```shell
kubectl run fedora --rm --image=fedora -i --tty -- bash

curl -v http://data-index-service/graphql
```
will output a 401:
```
* processing: http://data-index-service/graphql
*   Trying 10.103.228.98:80...
* Connected to data-index-service (10.103.228.98) port 80
> GET /graphql HTTP/1.1
> Host: data-index-service
> User-Agent: curl/8.2.1
> Accept: */*
> 
< HTTP/1.1 401 Unauthorized
< content-length: 0
< 
* Connection #0 to host data-index-service left intact
```

If you generate a valid token:
```bash
export access_token=$(\
   curl --insecure -X POST https://<keycloak address>/realms/Orchestrator/protocol/openid-connect/token \
   --user <client>:<client secret> \
   -H 'content-type: application/x-www-form-urlencoded' \
   -d 'username=<user>&password=<user password>&grant_type=password' | jq --raw-output '.access_token' \
   )
```
Then add this token in the header
```bash
curl -XGET http://data-index-service/graphql -H "Authorization: Bearer $access_token" -v 
```
The access is granted:
```
Note: Unnecessary use of -X or --request, GET is already inferred.
* processing: httpd-service/graphql
*   Trying 10.109.36.91:80...
* Connected to httpd-service (10.109.36.91) port 80
> GET /graphql HTTP/1.1
> Host: httpd-service
> User-Agent: curl/8.2.1
> Accept: */*
> Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpZ182Q2tnSWxJSjVFLWpIZFdFLUJFT3oxTDJpSThIUDRxMmVuaGRxSkRzIn0.eyJleHAiOjE3MDA3NTU3NzYsImlhdCI6MTcwMDc1NTQ3NiwianRpIjoiYjhmY2EyNWYtNDczNC00NGY0LThkMTctNmQ2YWU2ZDVkYTRlIiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay4xOTIuMTY4LjU4LjIubmlwLmlvL3JlYWxtcy9PcmNoZXN0cmF0b3IiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiZGY3OTUzZTYtM2Y1Yi00YTU5LWI3OTctMTk3ZTE1NmQ1MDRlIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiZGF0YS1pbmRleCIsInNlc3Npb25fc3RhdGUiOiJiYjQ2NmNjMi0wNzY0LTQzYzktOGMxYi1mZmY1OTNlZGQ5YTAiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRhdGFJbmRleF91c2VycyIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9yY2hlc3RyYXRvciJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6ImJiNDY2Y2MyLTA3NjQtNDNjOS04YzFiLWZmZjU5M2VkZDlhMCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZ3JvdXBzIjpbImRhdGFJbmRleF91c2VycyIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9yY2hlc3RyYXRvciJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ0ZXN0In0.K0eNVabmrpcvYQ0K8cegbP4aZ3rjAD48IHUwTiPrAEbQ99XdJ3i03olXEm0XMX8ev7Z6TgFOT1h2ImO2ZgwX2h35bC7v0lrdSDucykv0nLXphRDt-hc25Rw4wehML-Sm1YTLUXXL3pK6NdV4GWAvyGGP1ehusfJRomSVWFNXmD85aTGNsgv2YDOCt9HOivx1VxCnYW_ECJUbyzot7ZOG9CipdAnNh574CuLmdDyyw__QHDk-xBvUMy0hw6TLoL5GTqaVw7BPhV5w7Jlwb0jOq2WdfIKdzhGStqrDi78C-r2Dyksadk3o6IDIA10GKMn3cCHYqxfAdO2NcNgQpoj2yg
> Content-Type: application/json
> 
< HTTP/1.1 400 Bad Request
< Date: Thu, 23 Nov 2023 16:04:37 GMT
< Server: Apache/2.4.58 (Unix)
< content-type: application/json; charset=utf-8
< content-length: 73
< Connection: close
< 
* Closing connection
{"details":"Error id 8b183071-c2c9-40cc-8c6b-09cc75b9b98b-22","stack":""}
```
## NetworkPolicies
Only needed for option #1
### Deploy
To restrict network access to the DataIndex service only to specific pods, run the folowing:
```bash
kubectl apply -f dataindex-networkpolicies.yaml
```

### Test
To test if the nework policy is applied try access it from a pod without the label:
```shell
kubectl run fedora --rm --image=fedora -i --tty -- bash

curl http://data-index-service/graphql
```
This should timeout

Now, run the following to ensure a pod with the label can access the DataIndex service:
```bash
kubectl run fedora-access --rm --image=fedora -l data-index-access="true" -i --tty -- bash

curl http://data-index-service/graphql
```
You should get someting similar to the following:
```json
{"details":"Error id 8b183071-c2c9-40cc-8c6b-09cc75b9b98b-17","stack":""}
```

## Apache HTTPD
Only needed for option #1

The deployment and service are defined in the file [httpd.yaml](httpd.yaml).

We are using the custom image `quay.io/orchestrator/httpd-mod-oauth2:latest` that has the needed module installed.

This image was generated using the [Dockerfile](Dockerfile) file located in this folder.

The configuration is located in [httpd.conf](httpd.conf) which include the [oauth2](oauth2.conf) configuration.

You will notice we are disabling ssl check in this example; it's because the Keycloak certificates are self-signed.

### Configuration
You need to update the [oauth2.conf](oauth2.conf) file with, at least, the keycloak address:
```
Auth2TokenVerify jwks_uri https://<keycloak address>/realms/Orchestrator/protocol/openid-connect/certs jwks_uri.ssl_verify=false
```

### Deploy
First, create the config maps holding the configuration files:
```bash
kubectl create configmap httpd-conf --from-file=httpd.conf 
kubectl create configmap httpd-oauth2-conf --from-file=oauth2.conf 
```
Then deploy the HTTPD:
```bash
kubectl apply -f httpd.yaml
```
### Test
From a pod inside the cluster (ie: `kubectl run fedora --rm --image=fedora -i --tty -- bash`), run
1. Get the access token:
```bash
export access_token=$(\
   curl --insecure -X POST https://<keycloak address>/realms/Orchestrator/protocol/openid-connect/token \
   --user data-index:<client secret> \
   -H 'content-type: application/x-www-form-urlencoded' \
   -d 'username=<user>&password=<user password>&grant_type=password' | jq --raw-output '.access_token' \
   )
```
2. Send request to the HTTPD to access graphql endpoint that should be redirected to the DataIndex graphql endpoint:
```bash
curl -XGET httpd-service/graphql -H "Authorization: Bearer $access_token" -v 
```
You should have something similar to:
``` 
Note: Unnecessary use of -X or --request, GET is already inferred.
* processing: httpd-service/graphql
*   Trying 10.109.36.91:80...
* Connected to httpd-service (10.109.36.91) port 80
> GET /graphql HTTP/1.1
> Host: httpd-service
> User-Agent: curl/8.2.1
> Accept: */*
> Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJpZ182Q2tnSWxJSjVFLWpIZFdFLUJFT3oxTDJpSThIUDRxMmVuaGRxSkRzIn0.eyJleHAiOjE3MDA3NTU3NzYsImlhdCI6MTcwMDc1NTQ3NiwianRpIjoiYjhmY2EyNWYtNDczNC00NGY0LThkMTctNmQ2YWU2ZDVkYTRlIiwiaXNzIjoiaHR0cHM6Ly9rZXljbG9hay4xOTIuMTY4LjU4LjIubmlwLmlvL3JlYWxtcy9PcmNoZXN0cmF0b3IiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiZGY3OTUzZTYtM2Y1Yi00YTU5LWI3OTctMTk3ZTE1NmQ1MDRlIiwidHlwIjoiQmVhcmVyIiwiYXpwIjoiZGF0YS1pbmRleCIsInNlc3Npb25fc3RhdGUiOiJiYjQ2NmNjMi0wNzY0LTQzYzktOGMxYi1mZmY1OTNlZGQ5YTAiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRhdGFJbmRleF91c2VycyIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9yY2hlc3RyYXRvciJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsInNpZCI6ImJiNDY2Y2MyLTA3NjQtNDNjOS04YzFiLWZmZjU5M2VkZDlhMCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZ3JvdXBzIjpbImRhdGFJbmRleF91c2VycyIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iLCJkZWZhdWx0LXJvbGVzLW9yY2hlc3RyYXRvciJdLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ0ZXN0In0.K0eNVabmrpcvYQ0K8cegbP4aZ3rjAD48IHUwTiPrAEbQ99XdJ3i03olXEm0XMX8ev7Z6TgFOT1h2ImO2ZgwX2h35bC7v0lrdSDucykv0nLXphRDt-hc25Rw4wehML-Sm1YTLUXXL3pK6NdV4GWAvyGGP1ehusfJRomSVWFNXmD85aTGNsgv2YDOCt9HOivx1VxCnYW_ECJUbyzot7ZOG9CipdAnNh574CuLmdDyyw__QHDk-xBvUMy0hw6TLoL5GTqaVw7BPhV5w7Jlwb0jOq2WdfIKdzhGStqrDi78C-r2Dyksadk3o6IDIA10GKMn3cCHYqxfAdO2NcNgQpoj2yg
> Content-Type: application/json
> 
< HTTP/1.1 400 Bad Request
< Date: Thu, 23 Nov 2023 16:04:37 GMT
< Server: Apache/2.4.58 (Unix)
< content-type: application/json; charset=utf-8
< content-length: 73
< Connection: close
< 
* Closing connection
{"details":"Error id 8b183071-c2c9-40cc-8c6b-09cc75b9b98b-22","stack":""}
```