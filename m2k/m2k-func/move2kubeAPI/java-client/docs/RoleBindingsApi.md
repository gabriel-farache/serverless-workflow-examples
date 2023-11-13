# RoleBindingsApi

All URIs are relative to */api/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**addRoleToUser**](RoleBindingsApi.md#addRoleToUser) | **PUT** /idps/{idp-id}/users/{user-id}/roles/{role-id} | Add a role to a user. |
| [**getRolesOfUser**](RoleBindingsApi.md#getRolesOfUser) | **GET** /idps/{idp-id}/users/{user-id}/roles | Get all the roles for the given user. |
| [**removeRoleFromUser**](RoleBindingsApi.md#removeRoleFromUser) | **DELETE** /idps/{idp-id}/users/{user-id}/roles/{role-id} | Remove a role from a user. |
| [**updateRolesOfUser**](RoleBindingsApi.md#updateRolesOfUser) | **PATCH** /idps/{idp-id}/users/{user-id}/roles | Update the roles of the given user. |



## addRoleToUser

> addRoleToUser(idpId, userId, roleId)

Add a role to a user.

Add a role to a user.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.RoleBindingsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        RoleBindingsApi apiInstance = new RoleBindingsApi(defaultClient);
        String idpId = "idp-1"; // String | ID of the identity provider.
        String userId = "user-1"; // String | ID of the user as given by the identity provider.
        String roleId = "team-7"; // String | ID of the role to add to the user.
        try {
            apiInstance.addRoleToUser(idpId, userId, roleId);
        } catch (ApiException e) {
            System.err.println("Exception when calling RoleBindingsApi#addRoleToUser");
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
| **idpId** | **String**| ID of the identity provider. | |
| **userId** | **String**| ID of the user as given by the identity provider. | |
| **roleId** | **String**| ID of the role to add to the user. | |

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
| **201** | Created. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to add this role to this user. |  -  |
| **404** | User not found. |  -  |


## getRolesOfUser

> List&lt;String&gt; getRolesOfUser(idpId, userId)

Get all the roles for the given user.

Get all the roles for the given user.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.RoleBindingsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        RoleBindingsApi apiInstance = new RoleBindingsApi(defaultClient);
        String idpId = "idp-1"; // String | ID of the identity provider.
        String userId = "user-1"; // String | ID of the user as given by the identity provider.
        try {
            List<String> result = apiInstance.getRolesOfUser(idpId, userId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling RoleBindingsApi#getRolesOfUser");
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
| **idpId** | **String**| ID of the identity provider. | |
| **userId** | **String**| ID of the user as given by the identity provider. | |

### Return type

**List&lt;String&gt;**

### Authorization

[bearerAuth](../README.md#bearerAuth)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Success. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to get the roles for this user. |  -  |
| **404** | User not found. |  -  |


## removeRoleFromUser

> removeRoleFromUser(idpId, userId, roleId)

Remove a role from a user.

Remove a role from a user.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.RoleBindingsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        RoleBindingsApi apiInstance = new RoleBindingsApi(defaultClient);
        String idpId = "idp-1"; // String | ID of the identity provider.
        String userId = "user-1"; // String | ID of the user as given by the identity provider.
        String roleId = "team-7"; // String | ID of the role to remove from the user.
        try {
            apiInstance.removeRoleFromUser(idpId, userId, roleId);
        } catch (ApiException e) {
            System.err.println("Exception when calling RoleBindingsApi#removeRoleFromUser");
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
| **idpId** | **String**| ID of the identity provider. | |
| **userId** | **String**| ID of the user as given by the identity provider. | |
| **roleId** | **String**| ID of the role to remove from the user. | |

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
| **403** | Don&#39;t have authorization to remove this role from this user. |  -  |
| **404** | User not found. |  -  |


## updateRolesOfUser

> updateRolesOfUser(idpId, userId, body)

Update the roles of the given user.

Update the roles of the given user.

### Example

```java
// Import classes:
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.auth.*;
import dev.parodos.move2kube.models.*;
import dev.parodos.move2kube.api.RoleBindingsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("/api/v1");
        
        // Configure HTTP bearer authorization: bearerAuth
        HttpBearerAuth bearerAuth = (HttpBearerAuth) defaultClient.getAuthentication("bearerAuth");
        bearerAuth.setBearerToken("BEARER TOKEN");

        RoleBindingsApi apiInstance = new RoleBindingsApi(defaultClient);
        String idpId = "idp-1"; // String | ID of the identity provider.
        String userId = "user-1"; // String | ID of the user as given by the identity provider.
        List<String> body = "body_example"; // List<String> | Add, remove or overwrite the roles of the user.
        try {
            apiInstance.updateRolesOfUser(idpId, userId, body);
        } catch (ApiException e) {
            System.err.println("Exception when calling RoleBindingsApi#updateRolesOfUser");
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
| **idpId** | **String**| ID of the identity provider. | |
| **userId** | **String**| ID of the user as given by the identity provider. | |
| **body** | [**List&lt;String&gt;**](String.md)| Add, remove or overwrite the roles of the user. | |

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
| **204** | Success. |  -  |
| **400** | Invalid format or validation error. |  -  |
| **401** | Authorization header is missing or invalid. |  * WWW_Authenticate -  <br>  |
| **403** | Don&#39;t have authorization to update the roles for this user. |  -  |
| **404** | User not found. |  -  |

