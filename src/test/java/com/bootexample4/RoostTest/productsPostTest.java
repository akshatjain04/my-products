// Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview


// Test generated for /products_post for http method type POST in rest-assured framework


// RoostTestHash=dcd186097b


package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;

public class productsPostTest {
  
    @Test  
    public void products_post_Test() {  
        RestAssured.baseURI = System.getenv("BASE_URL");  
  
        // Read CSV file  
        try (BufferedReader reader = new BufferedReader(new FileReader("src\test\java\com\bootexample4\RoostTest\productsPostTest.csv"))) {  
            String headerLine = reader.readLine();  
            String[] headers = headerLine.split(",");  
  
            String line;  
            while ((line = reader.readLine()) != null) {  
                String[] data = line.split(",");  
  
                // Create a map of header to data  
                Map<String, String> map = new HashMap<>();  
                for (int i = 0; i < headers.length; i++) {  
                    map.put(headers[i], data[i]);  
                }  
                
  
                Response response = given()
				.contentType(ContentType.JSON)
				.body("{\n"+
					"  \"id\": \"" + map.get("id") + "\",\n" +
					"  \"name\": \"" + map.get("name") + "\",\n" +
					"  \"description\": \"" + map.get("description") + "\",\n" +
					"  \"price\": \"" + map.get("price") + "\n" +
 				"}")
                .when()
                .post("/products")  
                .then() 
                .extract().response();    
         
                if (response.statusCode() == 200) {
					System.out.println("Description: Successful operation");
  
            if (response.jsonPath().get("id") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("id"), instanceOf(Integer.class));
                MatcherAssert.assertThat(response.jsonPath().getString("id"), Number.isSafeInteger(
                  response.jsonPath().getInt("id")
                )); 
  
          }
  
            if (response.jsonPath().get("name") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("name"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("description") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("description"), instanceOf(String.class));  
          }
  
            if (response.jsonPath().get("price") != null) {
                MatcherAssert.assertThat(response.jsonPath().get("price"), instanceOf(Integer.class));
                MatcherAssert.assertThat(response.jsonPath().getString("price"), Number.isSafeInteger(
                  response.jsonPath().getInt("price")
                )); 
  
          }
				}
if (response.statusCode() == 405) {
					System.out.println("Description: Invalid input");
				}
  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
}
