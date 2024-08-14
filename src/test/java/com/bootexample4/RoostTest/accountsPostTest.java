// ********RoostGPT********
/*
Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview

Test generated for /accounts_post for http method type POST in rest-assured framework

RoostTestHash=965c2c5f71


*/

// ********RoostGPT********
package com.bootexample4.RoostTest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.json.JSONObject;
import org.json.XML;
import org.json.JSONException;
import org.json.JSONArray;
import java.util.Arrays;

public class accountsPostTest {

    List<Map<String, String>> envList = new ArrayList<>();


    @BeforeEach
    public void setUp() {
      TestdataLoader dataloader = new TestdataLoader();
      String[] envVarsList = {""};
      envList = dataloader.load("src\\test\\java\\com\\bootexample4\\RoostTest\\accountsPostTest.csv", envVarsList);
    }

  
    @Test  
    public void accountsPost_Test() throws JSONException {
        this.setUp();
        Integer testNumber = 1;
        for (Map<String, String> testData : envList) {
          RestAssured.baseURI = (testData.get("CREDENTIAL_WALLET_BASE_URL") != null && !testData.get("CREDENTIAL_WALLET_BASE_URL").isEmpty()) ? testData.get("CREDENTIAL_WALLET_BASE_URL"): "https://virtserver.swaggerhub.com/credentialregister/wallet/1.0.0";  
          JSONObject requestBodyObject = new JSONObject();
          if(testData.get("RequestBody") != null){
              requestBodyObject = new JSONObject(testData.get("RequestBody"));
          }
                Response responseObj = given()
				.header("commit-hash", testData.get("commit-hash") != null ? testData.get("commit-hash") : "")
				.contentType(ContentType.JSON)
				.body(requestBodyObject.toString())
                .when()
                .post("/accounts")  
                .then() 
                .extract().response(); 
              JsonPath response;
              String contentType = responseObj.getContentType();

              System.out.printf("Test Case %d: accountsPost_Test \n", testNumber++);
              System.out.println("Request: POST /accounts");
              System.out.println("Status Code: " + responseObj.statusCode());
              if (testData.get("statusCode") != null) {
                String statusCodeFromCSV = testData.get("statusCode");
                if (statusCodeFromCSV.contains("X")) {
                  MatcherAssert.assertThat(
                      "Expected a status code of category " + statusCodeFromCSV + ", but got "
                          + Integer.toString(responseObj.statusCode()) + " instead",
                      Integer.toString(responseObj.statusCode()).charAt(0), equalTo(statusCodeFromCSV.charAt(0)));
                } else {
                  MatcherAssert.assertThat(
                      Integer.toString(responseObj.statusCode()), equalTo(statusCodeFromCSV));
                }
              } 
              				else {  
      List<Integer> expectedStatusCodes = Arrays.asList(201,400);
				MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
          }
				String stringifiedStatusCode = Integer.toString(responseObj.statusCode());
        switch(responseObj.statusCode()){
        
          case 400:
            stringifiedStatusCode = "400";
            MatcherAssert.assertThat(contentType, equalTo("application/json"));
            break;
         
    }

      switch(Integer.toString(responseObj.statusCode()).charAt(0)){
      
    }

      
              if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
                String xmlResponse = responseObj.asString();
                JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
                JSONObject jsonData = jsonResponse.getJSONObject("xml");
                String jsonString = jsonData.toString();
                response = new JsonPath(jsonString);
        
              } else if(contentType.contains("application/json")){  
                response = responseObj.jsonPath(); 
              } else {
                System.out.println("Response content type found: "+contentType+", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
                continue;
              }
         
                if(stringifiedStatusCode.equals("201")){					System.out.println("Description: successful operation");
				}
if(stringifiedStatusCode.equals("400")){					System.out.println("Description: Bad Request");
      
              if (response.get("error") != null) {
                  
                MatcherAssert.assertThat(response.get("error"), instanceOf(String.class));
              }
      
              if (response.get("description") != null) {
                  
                MatcherAssert.assertThat(response.get("description"), instanceOf(String.class));
              }
      
              if (response.get("error") != null) {
                    
                MatcherAssert.assertThat(response.getString("error"), matchesPattern("^validation/.*$")); 
  
                MatcherAssert.assertThat(response.get("error"), instanceOf(String.class));
              }
      
              if (response.get("description") != null) {
                  
                MatcherAssert.assertThat(response.get("description"), instanceOf(String.class));
              }
      
              if (response.get("field") != null) {
                  
                MatcherAssert.assertThat(response.get("field"), instanceOf(String.class));
              }
      
              if (response.get("schema_field") != null) {
                  
                MatcherAssert.assertThat(response.get("schema_field"), instanceOf(String.class));
              }
				}


            }  
    }
}
