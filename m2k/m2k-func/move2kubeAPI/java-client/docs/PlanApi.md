# PlanApi

All URIs are relative to */api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deletePlan**](PlanApi.md#deletePlan) | **DELETE** /workspaces/{workspace-id}/projects/{project-id}/plan | Delete the current plan for the project. |
| [**getPlan**](PlanApi.md#getPlan) | **GET** /workspaces/{workspace-id}/projects/{project-id}/plan | Get the plan file. |
| [**startPlanning**](PlanApi.md#startPlanning) | **POST** /workspaces/{workspace-id}/projects/{project-id}/plan | Start planning on this project&#39;s inputs. |
| [**updatePlan**](PlanApi.md#updatePlan) | **PUT** /workspaces/{workspace-id}/projects/{project-id}/plan | Update the plan for this project. |



## deletePlan

> deletePlan(workspaceId, projectId)

Delete the current plan for the project.

Delete the current plan for the project.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.PlanApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PlanApi apiInstance = new PlanApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project to delete the plan from.
        try {
            apiInstance.deletePlan(workspaceId, projectId);
        } catch (ApiException e) {
            System.err.println("Exception when calling PlanApi#deletePlan");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **workspaceId** | **String**| ID of the workspace the project is in. | |
| **projectId** | **String**| ID of the project to delete the plan from. | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Deleted. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to delete the plan for this project. |  -  |
| **404** | Workspace or project not found. |  -  |


## getPlan

> GetPlan200Response getPlan(workspaceId, projectId)

Get the plan file.

Get the plan file.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.PlanApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PlanApi apiInstance = new PlanApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project to get the plan from.
        try {
            GetPlan200Response result = apiInstance.getPlan(workspaceId, projectId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling PlanApi#getPlan");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **workspaceId** | **String**| ID of the workspace the project is in. | |
| **projectId** | **String**| ID of the project to get the plan from. | |

### Return type

[**GetPlan200Response**](GetPlan200Response.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Accepted. |  -  |
| **400** | Invalid format or validation error. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to start planning for this project. |  -  |
| **404** | Workspace or project not found. |  -  |
| **409** | Conflict, because planning is already on-going for this project. |  -  |


## startPlanning

> startPlanning(workspaceId, projectId)

Start planning on this project&#39;s inputs.

Start planning on this project&#39;s inputs.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.PlanApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PlanApi apiInstance = new PlanApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project to start planning in.
        try {
            apiInstance.startPlanning(workspaceId, projectId);
        } catch (ApiException e) {
            System.err.println("Exception when calling PlanApi#startPlanning");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **workspaceId** | **String**| ID of the workspace the project is in. | |
| **projectId** | **String**| ID of the project to start planning in. | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accepted. |  -  |
| **400** | Invalid format or validation error. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to start planning for this project. |  -  |
| **404** | Workspace or project not found. |  -  |


## updatePlan

> updatePlan(workspaceId, projectId, body)

Update the plan for this project.

Update the plan for this project.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.PlanApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        PlanApi apiInstance = new PlanApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project to update the plan for.
        UpdatePlanRequest body = new UpdatePlanRequest(); // UpdatePlanRequest | 
        try {
            apiInstance.updatePlan(workspaceId, projectId, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling PlanApi#updatePlan");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **workspaceId** | **String**| ID of the workspace the project is in. | |
| **projectId** | **String**| ID of the project to update the plan for. | |
| **body** | [**UpdatePlanRequest**](UpdatePlanRequest.md)|  | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Accepted. |  -  |
| **400** | Invalid format or validation error. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to update the plan for this project. |  -  |
| **404** | Workspace or project not found. |  -  |

