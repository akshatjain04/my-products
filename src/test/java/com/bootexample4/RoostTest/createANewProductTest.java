/*
Test generated by RoostGPT for test MiniProjects using AI Type Vertex AI and AI Model code-bison-32k

{
  background: 'Given the base URL is "http://localhost:8080"',
  rule: null,
  scenario: 'Create a new product\r\n' +
    '        Given the client provides the following product data:\r\n' +
    '            | name         | description             | price |\r\n' +
    '            | Test Product | This is a test product. | 10.0  |\r\n' +
    '        When the client sends a POST request to "/api/products"\r\n' +
    '        Then the saved product should not be null and its properties must correspond to those provided by client',
  title: 'Create a new product'
}

*/
package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class createANewProductTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = System.getenv("API_HOST");
    }

    @Test
    public void createANewProduct() {
        // Given the client provides the following product data:
        Map<String, Object> payload = new HashMap<>();
        payload.put("name", "Test Product");
        payload.put("description", "This is a test product.");
        payload.put("price", 10.0);

        // When the client sends a POST request to "/api/products"
        given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("/api/products")

                // Then the saved product should not be null and its properties must correspond to those provided by client
                .then()
                .statusCode(200)
                .body("name", equalTo("Test Product"))
                .body("description", equalTo("This is a test product."))
                .body("price", equalTo(10.0));
    }
}
