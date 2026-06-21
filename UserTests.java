package com.netomi.framework.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.netomi.framework.endpoints.UserEndpoints;
import com.netomi.framework.models.UserPayload;
import io.restassured.response.Response;

public class UserTests {

    private UserPayload userPayload;

    @BeforeClass
    public void setupData() {
        userPayload = new UserPayload();
        userPayload.setName("Kusha");
        userPayload.setJob("SDET Intern");
    }

    @Test(priority = 1)
    public void testCreateUser() {
        Response response = UserEndpoints.createUser(userPayload);
        response.then().log().all();
        
        // JSONPlaceholder returns 201 Created for a successful POST
        Assert.assertEquals(response.getStatusCode(), 201, "Status code validation failed.");
        
        String returnedName = response.jsonPath().getString("name");
        Assert.assertEquals(returnedName, "Kusha", "Name mismatch in response.");
    }

    @Test(priority = 2)
    public void testGetExistingUser() {
        Response response = UserEndpoints.readUser(2);
        response.then().log().all();
        
        Assert.assertEquals(response.getStatusCode(), 200, "Status code validation failed.");
        
        // CHANGED: Removed "data." prefix because email is at the root level here
        String email = response.jsonPath().getString("email");
        Assert.assertNotNull(email, "User email should not be null.");
    }
}