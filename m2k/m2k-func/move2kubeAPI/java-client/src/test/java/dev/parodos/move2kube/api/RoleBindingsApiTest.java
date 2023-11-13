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

import dev.parodos.move2kube.ApiException;
import dev.parodos.move2kube.client.model.Error;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for RoleBindingsApi
 */
@Ignore
public class RoleBindingsApiTest {

    private final RoleBindingsApi api = new RoleBindingsApi();

    /**
     * Add a role to a user.
     *
     * Add a role to a user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void addRoleToUserTest() throws ApiException {
        String idpId = null;
        String userId = null;
        String roleId = null;
        api.addRoleToUser(idpId, userId, roleId);

        // TODO: test validations
    }
    /**
     * Get all the roles for the given user.
     *
     * Get all the roles for the given user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void getRolesOfUserTest() throws ApiException {
        String idpId = null;
        String userId = null;
        List<String> response = api.getRolesOfUser(idpId, userId);

        // TODO: test validations
    }
    /**
     * Remove a role from a user.
     *
     * Remove a role from a user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void removeRoleFromUserTest() throws ApiException {
        String idpId = null;
        String userId = null;
        String roleId = null;
        api.removeRoleFromUser(idpId, userId, roleId);

        // TODO: test validations
    }
    /**
     * Update the roles of the given user.
     *
     * Update the roles of the given user.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void updateRolesOfUserTest() throws ApiException {
        String idpId = null;
        String userId = null;
        List<String> body = null;
        api.updateRolesOfUser(idpId, userId, body);

        // TODO: test validations
    }
}