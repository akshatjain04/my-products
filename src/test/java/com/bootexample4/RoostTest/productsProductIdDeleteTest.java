// ********RoostGPT********
/*
Test generated by RoostGPT for test my-products-rest-assured-api-spec-test using AI Type Open AI and AI Model gpt-4-turbo-preview

Test generated for /products/{productId}_delete for http method type DELETE in rest-assured framework

RoostTestHash=47d9fe845f

================================VULNERABILITIES================================
Vulnerability: Insufficient Logging & Monitoring
Issue: The log entries for deleting a product do not include user identification or IP address, making it difficult to trace who performed the action. This is seen in both log entries.
Solution: Enhance logging to include user identification and IP addresses for auditing purposes. Ensure that access to logs is secure and monitored.

Vulnerability: Insecure Direct Object References (IDOR)
Issue: The log shows a DELETE request on '/api/products/2' which could indicate that resources are directly accessible by their IDs without proper authorization checks.
Solution: Implement robust authorization checks to ensure users can only access or modify resources they are permitted to. Use indirect object references where possible.

================================================================================

*/

// ********RoostGPT********
package com.bootexample4.RoostTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class productsProductIdDeleteTest {

  List<Map<String, String>> envList = new ArrayList<>();

  @Before
  public void setUp() {
    TestdataLoader dataloader = new TestdataLoader();
    envList = dataloader.loadData("src/test/java/com/bootexample4/RoostTest/products_productIdDeleteTest.csv");
  }

  @Test
  public void productsProductIdDelete_Test() {
    this.setUp();
    for (Map<String, String> map : envList) {
      RestAssured.baseURI = map.get("BASE_URL");

      Response response = given()
          .pathParam("productId", map.get("productId") != null ? map.get("productId") : "")
          .when()
          .delete("/products/{productId}")
          .then()
          .extract().response();

      if (response.statusCode() == 200) {
        System.out.println("Description: Product deleted");
      }
      if (response.statusCode() == 404) {
        System.out.println("Description: Not Found");
      }

    }
  }
}
