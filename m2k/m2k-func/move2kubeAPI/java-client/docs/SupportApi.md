# SupportApi

All URIs are relative to */api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getSupportInfo**](SupportApi.md#getSupportInfo) | **GET** /support | Returns some support information like CLI, API and UI version info. |



## getSupportInfo

> GetSupportInfo200Response getSupportInfo()

Returns some support information like CLI, API and UI version info.

Returns some support information like CLI, API and UI version info.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.SupportApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        SupportApi apiInstance = new SupportApi(defaultClient);
        try {
            GetSupportInfo200Response result = apiInstance.getSupportInfo();
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling SupportApi#getSupportInfo");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters

This endpoint does not need any parameter.

### Return type

[**GetSupportInfo200Response**](GetSupportInfo200Response.md)

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. |  -  |

