# QaApi

All URIs are relative to */api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getCurrentQuestion**](QaApi.md#getCurrentQuestion) | **GET** /workspaces/{workspace-id}/projects/{project-id}/outputs/{output-id}/problems/current | Get the current question that needs to be answered for the transformation to proceed. |
| [**postAnswerToQuestion**](QaApi.md#postAnswerToQuestion) | **POST** /workspaces/{workspace-id}/projects/{project-id}/outputs/{output-id}/problems/current/solution | Post the answer to the current question for an on-going transformation given by the ID. |



## getCurrentQuestion

> GetCurrentQuestion200Response getCurrentQuestion(workspaceId, projectId, outputId)

Get the current question that needs to be answered for the transformation to proceed.

Get the current question that needs to be answered for the transformation to proceed.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.QaApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        QaApi apiInstance = new QaApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project the output is in.
        String outputId = "proj-output-1234"; // String | ID of the output whose transformation is on-going.
        try {
            GetCurrentQuestion200Response result = apiInstance.getCurrentQuestion(workspaceId, projectId, outputId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling QaApi#getCurrentQuestion");
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
| **outputId** | **String**| ID of the output whose transformation is on-going. | |

### Return type

[**GetCurrentQuestion200Response**](GetCurrentQuestion200Response.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. |  -  |
| **204** | All questions have finished. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to get this project output. |  -  |
| **404** | Workspace, project or output not found. Might also be returned once the transformation has finished. |  -  |


## postAnswerToQuestion

> postAnswerToQuestion(workspaceId, projectId, outputId, body)

Post the answer to the current question for an on-going transformation given by the ID.

Post the answer to the current question for an on-going transformation given by the ID.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.QaApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        QaApi apiInstance = new QaApi(defaultClient);
        String workspaceId = "work-1234"; // String | ID of the workspace the project is in.
        String projectId = "proj-1234"; // String | ID of the project to start the transformation for.
        String outputId = "proj-output-1234"; // String | ID of the output whose transformation is on-going.
        PostAnswerToQuestionRequest body = new PostAnswerToQuestionRequest(); // PostAnswerToQuestionRequest | A plan to use for the transformation. (Not required). 
        try {
            apiInstance.postAnswerToQuestion(workspaceId, projectId, outputId, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling QaApi#postAnswerToQuestion");
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
| **outputId** | **String**| ID of the output whose transformation is on-going. | |
| **body** | [**PostAnswerToQuestionRequest**](PostAnswerToQuestionRequest.md)| A plan to use for the transformation. (Not required).  | |

### Return type

null (empty response body)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Answer was accepted |  -  |
| **400** | Invalid format or validation error. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to post an answer to the question for this project output. |  -  |
| **404** | Workspace, project, or output not found. |  -  |

