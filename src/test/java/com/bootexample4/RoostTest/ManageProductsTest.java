/*
Test generated by RoostGPT for test MiniProjects using AI Type Azure Open AI and AI Model roost-gpt4-32k

{
  background: 'Given the base URL is "http://localhost:8080"',
  rule: null,
  scenario: 'Manage Products\r\n' +
    '        When the client sends a GET request "/api/products" to get all products\r\n' +
    '        Then the product list should be empty\r\n' +
    '\r\n' +
    '        Given the client provides product data:\r\n' +
    '            | name         | description             | price |\r\n' +
    '            | Test Product | This is a test product. | 10.0  |\r\n' +
    '        When the client sends a POST request to "/api/products"\r\n' +
    '        Then the saved product details should match the provided data\r\n' +
    '\r\n' +
    '        Given there is an existing product with ID 1\r\n' +
    '        When the client sends a GET request "/api/products/1"\r\n' +
    '        Then the response should contain the product with ID 1\r\n' +
    '\r\n' +
    '        And the client provides updated product data:\r\n' +
    '            | name            | description                      | price |\r\n' +
    '            | Updated Product | This is an updated test product. | 15.0  |\r\n' +
    '        When the client sends a PUT request to "/api/products/1"\r\n' +
    '        Then the product with ID 1 should be updated with the provided details\r\n' +
    '\r\n' +
    '        When the client sends a DELETE request to "/api/products/1"\r\n' +
    '        Then the product with ID 1 should no longer exist',
  title: 'Manage Products'
}

*/
package com.bootexample4.RoostTest;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ManageProductsTest {

    @Test
    public void manageProductsTest() throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader("ManageProductsTest.csv"));
        String line;
        Map<String, String> payload = new HashMap<>();
        while ((line = fileReader.readLine()) != null) {
            String[] data = line.split("\\^|\\^");

            String method = data[0];
            String url = data[1];
            Headers headers = new Headers();
            String reqBody = data[3];
            int responseCode = Integer.parseInt(data[4]);

            if (StringUtils.isNotEmpty(data[2])) {
                headers = Headers.headers((Map<String, Object>) payload.get(data[2]));
            }

            switch (method.toLowerCase()) {
                case "get":
                    Response getResponse = given()
                            .headers(headers)
                            .when()
                            .get(System.getenv("API_HOST") + url);

                    assertTrue(getResponse.statusCode() == responseCode);
                    break;

                case "post":
                    Response postResponse = given()
                            .headers(headers)
                            .body(reqBody)
                            .when()
                            .post(System.getenv("API_HOST") + url);

                    assertTrue(postResponse.statusCode() == responseCode);
                    break;

                case "put":
                    Response putResponse = given()
                            .headers(headers)
                            .body(reqBody)
                            .when()
                            .put(System.getenv("API_HOST") + url);

                    assertTrue(putResponse.statusCode() == responseCode);
                    break;

                case "delete":
                    Response deleteResponse = given()
                            .headers(headers)
                            .when()
                            .delete(System.getenv("API_HOST") + url);

                    assertTrue(deleteResponse.statusCode() == responseCode);
                    break;
            }

        }
        fileReader.close();
    }
}
