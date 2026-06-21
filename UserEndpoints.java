package com.netomi.framework.endpoints;

import static io.restassured.RestAssured.*;
import com.netomi.framework.models.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

    // Swapping to a completely open API mock engine
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    public static final String POST_URL = BASE_URL + "/users";
    public static final String GET_URL = BASE_URL + "/users/{id}";

    /**
     * Sends a POST request to create a new user resource.
     */
    public static Response createUser(UserPayload payload) {
        return given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)
        .when()
            .post(POST_URL);
    }

    /**
     * Sends a GET request to retrieve an existing user resource by ID.
     */
    public static Response readUser(int id) {
        return given()
            .pathParam("id", id)
        .when()
            .get(GET_URL);
    }
}