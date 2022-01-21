package com.ledger.test.api;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {
    Response response;

    @When("user requests for token with {string} details")
    public void user_requests_for_token_with_details(String string) {
        RestAssured.baseURI = "https://api.realworld.io/api/users/login";
        RequestSpecification request = RestAssured.given();

        JSONObject usersObj = new JSONObject();
        usersObj.put("email", "testing@web.com");
        usersObj.put("password", "test123");

        JSONObject requestObj = new JSONObject();
        requestObj.put("user", usersObj);
        
        request.header("Content-Type", "application/json");
        request.body(requestObj.toJSONString());

        // Post the request and check the response
        response = request.post("/");
    }

    @Then("verify status code as {string}")
    public void verify_status_code_as(String string) {
        assertEquals(200, response.getStatusCode());
        assertEquals("Test User 007", response.jsonPath().get("user.username"));
    }

}
