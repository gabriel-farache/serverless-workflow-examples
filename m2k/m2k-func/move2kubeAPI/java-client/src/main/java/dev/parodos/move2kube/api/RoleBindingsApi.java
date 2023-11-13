/*
 * Move2Kube API
 * This is a documentation of the Move2Kube REST API. All API calls expect the `Authorization: Bearer <access-token>` HTTP header unless specified otherwise. The access token can be obtained in the same way as OAuth 2.0 using the token endpoint in the admin section. 
 *
 * The version of the OpenAPI document: v1.0.0
 * Contact: move2kube-dev@googlegroups.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package dev.parodos.move2kube.api;

import com.fasterxml.jackson.core.type.TypeReference;

import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.ApiClient;
import dev.parodos.move2kube.Configuration;
import dev.parodos.move2kube.Pair;

import dev.parodos.move2kube.client.model.Error;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2023-10-17T12:21:13.081862Z[Etc/UTC]")
public class RoleBindingsApi {


  private ApiClient apiClient;

  public RoleBindingsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public RoleBindingsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Add a role to a user.
   * Add a role to a user.
   * @param idpId ID of the identity provider. (required)
   * @param userId ID of the user as given by the identity provider. (required)
   * @param roleId ID of the role to add to the user. (required)
   * @throws ApiException if fails to make API call
   */
  public void addRoleToUser(String idpId, String userId, String roleId) throws ApiException {
    this.addRoleToUser(idpId, userId, roleId, Collections.emptyMap());
  }


  /**
   * Add a role to a user.
   * Add a role to a user.
   * @param idpId ID of the identity provider. (required)
   * @param userId ID of the user as given by the identity provider. (required)
   * @param roleId ID of the role to add to the user. (required)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void addRoleToUser(String idpId, String userId, String roleId, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idpId' is set
    if (idpId == null) {
      throw new ApiException(400, "Missing the required parameter 'idpId' when calling addRoleToUser");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling addRoleToUser");
    }
    
    // verify the required parameter 'roleId' is set
    if (roleId == null) {
      throw new ApiException(400, "Missing the required parameter 'roleId' when calling addRoleToUser");
    }
    
    // create path and map variables
    String localVarPath = "/idps/{idp-id}/users/{user-id}/roles/{role-id}"
      .replaceAll("\\{" + "idp-id" + "\\}", apiClient.escapeString(idpId.toString()))
      .replaceAll("\\{" + "user-id" + "\\}", apiClient.escapeString(userId.toString()))
      .replaceAll("\\{" + "role-id" + "\\}", apiClient.escapeString(roleId.toString()));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "bearerAuth" };

    apiClient.invokeAPI(
        localVarPath,
        "PUT",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        null
    );
  }

  /**
   * Get all the roles for the given user.
   * Get all the roles for the given user.
   * @param idpId ID of the identity provider. (required)
   * @param userId ID of the user as given by the identity provider. (required)
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> getRolesOfUser(String idpId, String userId) throws ApiException {
    return this.getRolesOfUser(idpId, userId, Collections.emptyMap());
  }


  /**
   * Get all the roles for the given user.
   * Get all the roles for the given user.
   * @param idpId ID of the identity provider. (required)
   * @param userId ID of the user as given by the identity provider. (required)
   * @param additionalHeaders additionalHeaders for this call
   * @return List&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public List<String> getRolesOfUser(String idpId, String userId, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idpId' is set
    if (idpId == null) {
      throw new ApiException(400, "Missing the required parameter 'idpId' when calling getRolesOfUser");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling getRolesOfUser");
    }
    
    // create path and map variables
    String localVarPath = "/idps/{idp-id}/users/{user-id}/roles"
      .replaceAll("\\{" + "idp-id" + "\\}", apiClient.escapeString(idpId.toString()))
      .replaceAll("\\{" + "user-id" + "\\}", apiClient.escapeString(userId.toString()));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "bearerAuth" };

    TypeReference<List<String>> localVarReturnType = new TypeReference<List<String>>() {};
    return apiClient.invokeAPI(
        localVarPath,
        "GET",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        localVarReturnType
    );
  }

  /**
   * Remove a role from a user.
   * Remove a role from a user.
   * @param idpId ID of the identity provider. (required)
   * @param userId ID of the user as given by the identity provider. (required)
   * @param roleId ID of the role to remove from the user. (required)
   * @throws ApiException if fails to make API call
   */
  public void removeRoleFromUser(String idpId, String userId, String roleId) throws ApiException {
    this.removeRoleFromUser(idpId, userId, roleId, Collections.emptyMap());
  }


  /**
   * Remove a role from a user.
   * Remove a role from a user.
   * @param idpId ID of the identity provider. (required)
   * @param userId ID of the user as given by the identity provider. (required)
   * @param roleId ID of the role to remove from the user. (required)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void removeRoleFromUser(String idpId, String userId, String roleId, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'idpId' is set
    if (idpId == null) {
      throw new ApiException(400, "Missing the required parameter 'idpId' when calling removeRoleFromUser");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling removeRoleFromUser");
    }
    
    // verify the required parameter 'roleId' is set
    if (roleId == null) {
      throw new ApiException(400, "Missing the required parameter 'roleId' when calling removeRoleFromUser");
    }
    
    // create path and map variables
    String localVarPath = "/idps/{idp-id}/users/{user-id}/roles/{role-id}"
      .replaceAll("\\{" + "idp-id" + "\\}", apiClient.escapeString(idpId.toString()))
      .replaceAll("\\{" + "user-id" + "\\}", apiClient.escapeString(userId.toString()))
      .replaceAll("\\{" + "role-id" + "\\}", apiClient.escapeString(roleId.toString()));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "bearerAuth" };

    apiClient.invokeAPI(
        localVarPath,
        "DELETE",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        null
    );
  }

  /**
   * Update the roles of the given user.
   * Update the roles of the given user.
   * @param idpId ID of the identity provider. (required)
   * @param userId ID of the user as given by the identity provider. (required)
   * @param body Add, remove or overwrite the roles of the user. (required)
   * @throws ApiException if fails to make API call
   */
  public void updateRolesOfUser(String idpId, String userId, List<String> body) throws ApiException {
    this.updateRolesOfUser(idpId, userId, body, Collections.emptyMap());
  }


  /**
   * Update the roles of the given user.
   * Update the roles of the given user.
   * @param idpId ID of the identity provider. (required)
   * @param userId ID of the user as given by the identity provider. (required)
   * @param body Add, remove or overwrite the roles of the user. (required)
   * @param additionalHeaders additionalHeaders for this call
   * @throws ApiException if fails to make API call
   */
  public void updateRolesOfUser(String idpId, String userId, List<String> body, Map<String, String> additionalHeaders) throws ApiException {
    Object localVarPostBody = body;
    
    // verify the required parameter 'idpId' is set
    if (idpId == null) {
      throw new ApiException(400, "Missing the required parameter 'idpId' when calling updateRolesOfUser");
    }
    
    // verify the required parameter 'userId' is set
    if (userId == null) {
      throw new ApiException(400, "Missing the required parameter 'userId' when calling updateRolesOfUser");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
      throw new ApiException(400, "Missing the required parameter 'body' when calling updateRolesOfUser");
    }
    
    // create path and map variables
    String localVarPath = "/idps/{idp-id}/users/{user-id}/roles"
      .replaceAll("\\{" + "idp-id" + "\\}", apiClient.escapeString(idpId.toString()))
      .replaceAll("\\{" + "user-id" + "\\}", apiClient.escapeString(userId.toString()));

    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, String> localVarCookieParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    
    localVarHeaderParams.putAll(additionalHeaders);

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      "application/json"
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] { "bearerAuth" };

    apiClient.invokeAPI(
        localVarPath,
        "PATCH",
        localVarQueryParams,
        localVarCollectionQueryParams,
        localVarQueryStringJoiner.toString(),
        localVarPostBody,
        localVarHeaderParams,
        localVarCookieParams,
        localVarFormParams,
        localVarAccept,
        localVarContentType,
        localVarAuthNames,
        null
    );
  }

}