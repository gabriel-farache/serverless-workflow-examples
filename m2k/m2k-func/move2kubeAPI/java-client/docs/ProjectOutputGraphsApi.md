# ProjectOutputGraphsApi

All URIs are relative to */api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getProjectOutputGraph**](ProjectOutputGraphsApi.md#getProjectOutputGraph) | **GET** /workspaces/{workspace-id}/projects/{project-id}/outputs/{output-id}/graph | Get the graph of the transformers used while creating the output with the given ID. |



## getProjectOutputGraph

> Object getProjectOutputGraph(workspaceId, projectId, outputId)

Get the graph of the transformers used while creating the output with the given ID.

Get the graph of the transformers used while creating the output with the given ID.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.ProjectOutputGraphsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ProjectOutputGraphsApi apiInstance = new ProjectOutputGraphsApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project the output is in.
        String outputId = "proj-output-1234"; // String | ID of the output whose graph we should get.
        try {
            Object result = apiInstance.getProjectOutputGraph(workspaceId, projectId, outputId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectOutputGraphsApi#getProjectOutputGraph");
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
| **projectId** | **String**| ID of the project the output is in. | |
| **outputId** | **String**| ID of the output whose graph we should get. | |

### Return type

**Object**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. |  -  |
| **204** | The transformation is still on-going. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to get this project output. |  -  |
| **404** | Workspace, project or output not found. |  -  |

