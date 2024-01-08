/*
Test generated by RoostGPT for test MiniProjects using AI Type Azure Open AI and AI Model roost-gpt4-32k

{
  background: 'Given the base URL is "http://localhost:8080"',
  rule: null,
  scenario: 'Delete an existing product\r\n' +
    '        Given there is an existing product with ID 1\r\n' +
    '        When the client sends a DELETE request to "/api/products/1"\r\n' +
    '        Then the response status code should be 200\r\n' +
    '        And the product with ID 1 should no longer exist',
  title: 'Delete an existing product'
}

*/
package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import static org.hamcrest.Matchers.*;

public class DeleteAnExistingProductTest {

    private static String BASE_URL;

    @Before
    public void setUp() {
        BASE_URL = System.getenv("API_HOST");
        if (BASE_URL == null) {
            BASE_URL = "http://localhost:8080";
        }
    }

    @Test
    public void deleteAnExistingProductTest() throws IOException {
        CSVReader reader = new CSVReader(new FileReader("DeleteAnExistingProductTest.csv"), '^', '^', 1);
        String[] line;
        while ((line = reader.readNext()) != null) {
            String method = line[0];
            String url = line[1];
            String reqHeaders = line[2];
            String reqBody = line[3];
            int responseCode = Integer.parseInt(line[4]);
            String responseBody = line[5];

            RequestSpecification request = RestAssured.given().baseUri(BASE_URL + url);
            request.headers(reqHeaders);

            if (method.equals("DELETE")) {
                if (reqBody != null && !reqBody.isEmpty()) {
                    request.body(reqBody);
                }
                Response response = request.delete();

                Assert.assertEquals(responseCode, response.getStatusCode());
                Assert.assertEquals(responseBody, response.getBody().asString());

                // Now to ensure that the resource has really been deleted, we attempt to fetch the resource
                Response getResponse = RestAssured.given().baseUri(BASE_URL + url).get();

                // We expect 404 Not Found since the resource should have been deleted
                Assert.assertEquals(404, getResponse.getStatusCode());

            }
        }
    }
}
