/*
Test generated by RoostGPT for test MiniProjects using AI Type Vertex AI and AI Model code-bison-32k

{
  background: 'Given the base URL is "http://localhost:8080"',
  rule: null,
  scenario: 'Update an existing product\r\n' +
    '        Given there is an existing product with ID 1\r\n' +
    '        And the client provides the following product data:\r\n' +
    '            | name            | description                      | price |\r\n' +
    '            | Updated Product | This is an updated test product. | 15.0  |\r\n' +
    '        When the client sends a PUT request to "/api/products/1"\r\n' +
    '        Then the product with ID 1 should be updated with the provided details',
  title: 'Update an existing product'
}

*/
 package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class updateAnExistingProductTest {

    @Test
    public void updateAnExistingProduct() {
        // Given the base URL is "http://localhost:8080"
        RestAssured.baseURI = System.getenv("API_HOST");

        // Given there is an existing product with ID 1
        // And the client provides the following product data:
        // | name            | description                      | price |
        // | Updated Product | This is an updated test product. | 15.0  |
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", "Updated Product");
        payload.put("description", "This is an updated test product.");
        payload.put("price", 15.0);

        // When the client sends a PUT request to "/api/products/1"
        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .pathParam("productId", 1)
                .when()
                .put("/api/products/{productId}")

                // Then the product with ID 1 should be updated with the provided details
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", equalTo("Updated Product"))
                .body("description", equalTo("This is an updated test product."))
                .body("price", equalTo(15.0));
    }
}