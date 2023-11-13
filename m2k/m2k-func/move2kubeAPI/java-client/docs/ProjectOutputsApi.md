# ProjectOutputsApi

All URIs are relative to */api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**deleteProjectOutput**](ProjectOutputsApi.md#deleteProjectOutput) | **DELETE** /workspaces/{workspace-id}/projects/{project-id}/outputs/{output-id} | Delete the output of the project. |
| [**getProjectOutput**](ProjectOutputsApi.md#getProjectOutput) | **GET** /workspaces/{workspace-id}/projects/{project-id}/outputs/{output-id} | Get the output of the project with the given ID. |
| [**startTransformation**](ProjectOutputsApi.md#startTransformation) | **POST** /workspaces/{workspace-id}/projects/{project-id}/outputs | Start transformation for this project. Planning must be completed before this. |



## deleteProjectOutput

> deleteProjectOutput(workspaceId, projectId, outputId)

Delete the output of the project.

Delete the output of the project.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.ProjectOutputsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ProjectOutputsApi apiInstance = new ProjectOutputsApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project the output is in.
        String outputId = "proj-output-1234"; // String | ID of the output to delete.
        try {
            apiInstance.deleteProjectOutput(workspaceId, projectId, outputId);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectOutputsApi#deleteProjectOutput");
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
| **outputId** | **String**| ID of the output to delete. | |

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
| **403** | Don&#39;t have authorization to delete this project output. |  -  |
| **404** | Workspace, project or output not found. |  -  |


## getProjectOutput

> File getProjectOutput(workspaceId, projectId, outputId)

Get the output of the project with the given ID.

Get the output of the project with the given ID.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.ProjectOutputsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ProjectOutputsApi apiInstance = new ProjectOutputsApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project the output is in.
        String outputId = "proj-output-1234"; // String | ID of the output to get.
        try {
            File result = apiInstance.getProjectOutput(workspaceId, projectId, outputId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectOutputsApi#getProjectOutput");
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
| **outputId** | **String**| ID of the output to get. | |

### Return type

[**File**](File.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/octet-stream


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. |  -  |
| **204** | The transformation is still on-going. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to get this project output. |  -  |
| **404** | Workspace, project or output not found. |  -  |


## startTransformation

> StartTransformation202Response startTransformation(workspaceId, projectId, body)

Start transformation for this project. Planning must be completed before this.

Start transformation for this project. Planning must be completed before this.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.ProjectOutputsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        ProjectOutputsApi apiInstance = new ProjectOutputsApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project to start the transformation for.
        StartTransformationRequest body = new StartTransformationRequest(); // StartTransformationRequest | A plan to use for the transformation. (Not required). 
        try {
            StartTransformation202Response result = apiInstance.startTransformation(workspaceId, projectId, body);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ProjectOutputsApi#startTransformation");
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
| **projectId** | **String**| ID of the project to start the transformation for. | |
| **body** | [**StartTransformationRequest**](StartTransformationRequest.md)| A plan to use for the transformation. (Not required).  | [optional] |

### Return type

[**StartTransformation202Response**](StartTransformation202Response.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **202** | Accept |  -  |
| **400** | Invalid format or validation error. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to start transformation for this project. |  -  |
| **404** | Workspace or project not found. |  -  |

