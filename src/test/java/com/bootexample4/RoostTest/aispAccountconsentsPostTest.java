// ********RoostGPT********
/*
Test generated by RoostGPT for test MiniProjects using AI Type Open AI and AI Model gpt-4-1106-preview

Test generated for /aisp/account-consents_post for http method type POST in rest-assured framework

RoostTestHash=3a9edd08a1


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

public class aispAccountconsentsPostTest {

	List<Map<String, String>> envList = new ArrayList<>();

	@BeforeEach
	public void setUp() {
		TestdataLoader dataloader = new TestdataLoader();
		String[] envVarsList = { "version" };
		envList = dataloader.load("src\\test\\java\\com\\bootexample4\\RoostTest\\aisp_account-consentsPostTest.csv",
				envVarsList);
	}

	@Test
	public void aispAccountconsentsPost_Test() throws JSONException {
		this.setUp();
		Integer testNumber = 1;
		for (Map<String, String> testData : envList) {
			RestAssured.baseURI = (testData.get("BASE_URL") != null && !testData.get("BASE_URL").isEmpty())
					? testData.get("BASE_URL") : "https://sandbox.ob.hsbc.com.hk/mock/open-banking/v1.0";

			Response responseObj = given()
				.header("Authorization", testData.get("Authorization") != null ? testData.get("Authorization") : "")
				.header("Content-Type", testData.get("Content-Type") != null ? testData.get("Content-Type") : "")
				.header("x-fapi-auth-date",
						testData.get("x-fapi-auth-date") != null ? testData.get("x-fapi-auth-date") : "")
				.header("x-fapi-customer-ip-address",
						testData.get("x-fapi-customer-ip-address") != null ? testData.get("x-fapi-customer-ip-address")
								: "")
				.header("x-fapi-interaction-id",
						testData.get("x-fapi-interaction-id") != null ? testData.get("x-fapi-interaction-id") : "")
				.header("Accept-Language",
						testData.get("Accept-Language") != null ? testData.get("Accept-Language") : "")
				.contentType(ContentType.JSON)
				.body("{\n" + "  \"data\": \"" + (testData.get("data") != null ? testData.get("data") : "") + "\n"
						+ "}")
				.when()
				.post("/aisp/account-consents")
				.then()
				.extract()
				.response();
			JsonPath response;
			String contentType = responseObj.getContentType();

			System.out.printf("Test Case %d: aispAccountconsentsPost_Test \n", testNumber++);
			System.out.println("Request: POST /aisp/account-consents");
			System.out.println("Status Code: " + responseObj.statusCode());
			if (testData.get("statusCode") != null) {
				String statusCodeFromCSV = testData.get("statusCode");
				if (statusCodeFromCSV.contains("X")) {
					MatcherAssert.assertThat(
							"Expected a status code of category " + statusCodeFromCSV + ", but got "
									+ Integer.toString(responseObj.statusCode()) + " instead",
							Integer.toString(responseObj.statusCode()).charAt(0), equalTo(statusCodeFromCSV.charAt(0)));
				}
				else {
					MatcherAssert.assertThat(Integer.toString(responseObj.statusCode()), equalTo(statusCodeFromCSV));
				}
			}
			else {
				List<Integer> expectedStatusCodes = Arrays.asList(201, 400, 401, 403, 405, 406, 415, 429, 500, 503,
						504);
				MatcherAssert.assertThat(responseObj.statusCode(), is(in(expectedStatusCodes)));
			}
			String stringifiedStatusCode = Integer.toString(responseObj.statusCode());
			switch (responseObj.statusCode()) {

				case 201:
					stringifiedStatusCode = "201";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 400:
					stringifiedStatusCode = "400";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 401:
					stringifiedStatusCode = "401";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 403:
					stringifiedStatusCode = "403";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 405:
					stringifiedStatusCode = "405";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 406:
					stringifiedStatusCode = "406";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 415:
					stringifiedStatusCode = "415";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 429:
					stringifiedStatusCode = "429";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 500:
					stringifiedStatusCode = "500";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 503:
					stringifiedStatusCode = "503";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

				case 504:
					stringifiedStatusCode = "504";
					MatcherAssert.assertThat(contentType, equalTo("application/json"));
					break;

			}

			switch (Integer.toString(responseObj.statusCode()).charAt(0)) {

			}

			if (contentType.contains("application/xml") || contentType.contains("text/xml")) {
				String xmlResponse = responseObj.asString();
				JSONObject jsonResponse = XML.toJSONObject(xmlResponse);
				JSONObject jsonData = jsonResponse.getJSONObject("xml");
				String jsonString = jsonData.toString();
				response = new JsonPath(jsonString);

			}
			else if (contentType.contains("application/json")) {
				response = responseObj.jsonPath();
			}
			else {
				System.out.println("Response content type found: " + contentType
						+ ", but RoostGPT currently only supports the following response content types: application/json,text/xml,application/xml");
				continue;
			}

			if (stringifiedStatusCode.equals("201")) {
				System.out.println("Description: Created");

				if (response.get("data") != null) {
					if (response.get("data.consentId") != null) {
						MatcherAssert.assertThat(response.get("data.consentId"), instanceOf(String.class));
						MatcherAssert.assertThat(response.getString("data.consentId").length(), lessThanOrEqualTo(128));

						MatcherAssert.assertThat(response.getString("data.consentId").length(),
								greaterThanOrEqualTo(1));

					}

					if (response.get("data.creationDate") != null) {
						MatcherAssert.assertThat(response.get("data.creationDate"), instanceOf(String.class));
					}

					if (response.get("data.status") != null) {
						MatcherAssert.assertThat(response.get("data.status"), instanceOf(String.class));
						MatcherAssert.assertThat(response.getString("data.status"), anyOf(equalTo("PendingAuthorise"),
								equalTo("Rejected"), equalTo("Authorised"), equalTo("Revoked")));

					}

					if (response.get("data.statusUpdateDate") != null) {
						MatcherAssert.assertThat(response.get("data.statusUpdateDate"), instanceOf(String.class));
					}

					if (response.get("data.permissions") != null) {
						for (int i = 0; i < response.getList("data.permissions").size(); i++) {
						}
						MatcherAssert.assertThat(response.getList("data.permissions"), instanceOf(List.class));

					}

					if (response.get("data.expirationDate") != null) {
						MatcherAssert.assertThat(response.get("data.expirationDate"), instanceOf(String.class));
					}

					if (response.get("data.transactionFromDate") != null) {
						MatcherAssert.assertThat(response.get("data.transactionFromDate"), instanceOf(String.class));
					}

					if (response.get("data.transactionToDate") != null) {
						MatcherAssert.assertThat(response.get("data.transactionToDate"), instanceOf(String.class));
					}

				}

				if (response.get("links") != null) {
					if (response.get("links.self") != null) {
						MatcherAssert.assertThat(response.get("links.self"), instanceOf(String.class));
					}

					if (response.get("links.prev") != null) {
						MatcherAssert.assertThat(response.get("links.prev"), instanceOf(String.class));
					}

					if (response.get("links.next") != null) {
						MatcherAssert.assertThat(response.get("links.next"), instanceOf(String.class));
					}

				}
			}
			if (stringifiedStatusCode.equals("400")) {
				System.out.println("Description: Bad Request");

				if (response.get("id") != null) {
					MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));
					MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));

					MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));

				}

				if (response.get("errors") != null) {
					for (int i = 0; i < response.getList("errors").size(); i++) {
						if (response.get("errors[" + i + "].code") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].code"), instanceOf(String.class));
						}

						if (response.get("errors[" + i + "].causes") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].causes"),
									instanceOf(String.class));
							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									lessThanOrEqualTo(500));

							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									greaterThanOrEqualTo(1));

						}

						if (response.get("errors[" + i + "].extendedDetails") != null) {
							if (response.get("errors[" + i + "].extendedDetails.path") != null) {
								MatcherAssert.assertThat(response.get("errors[" + i + "].extendedDetails.path"),
										instanceOf(String.class));
								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										lessThanOrEqualTo(500));

								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										greaterThanOrEqualTo(1));

							}

						}

					}
					MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));

				}
			}
			if (stringifiedStatusCode.equals("401")) {
				System.out.println("Description: Unauthorised");
			}
			if (stringifiedStatusCode.equals("403")) {
				System.out.println("Description: Forbidden");
			}
			if (stringifiedStatusCode.equals("405")) {
				System.out.println("Description: Method Not Allowed");

				if (response.get("id") != null) {
					MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));
					MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));

					MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));

				}

				if (response.get("errors") != null) {
					for (int i = 0; i < response.getList("errors").size(); i++) {
						if (response.get("errors[" + i + "].code") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].code"), instanceOf(String.class));
						}

						if (response.get("errors[" + i + "].causes") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].causes"),
									instanceOf(String.class));
							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									lessThanOrEqualTo(500));

							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									greaterThanOrEqualTo(1));

						}

						if (response.get("errors[" + i + "].extendedDetails") != null) {
							if (response.get("errors[" + i + "].extendedDetails.path") != null) {
								MatcherAssert.assertThat(response.get("errors[" + i + "].extendedDetails.path"),
										instanceOf(String.class));
								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										lessThanOrEqualTo(500));

								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										greaterThanOrEqualTo(1));

							}

						}

					}
					MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));

				}
			}
			if (stringifiedStatusCode.equals("406")) {
				System.out.println("Description: Not Acceptable");

				if (response.get("id") != null) {
					MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));
					MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));

					MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));

				}

				if (response.get("errors") != null) {
					for (int i = 0; i < response.getList("errors").size(); i++) {
						if (response.get("errors[" + i + "].code") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].code"), instanceOf(String.class));
						}

						if (response.get("errors[" + i + "].causes") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].causes"),
									instanceOf(String.class));
							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									lessThanOrEqualTo(500));

							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									greaterThanOrEqualTo(1));

						}

						if (response.get("errors[" + i + "].extendedDetails") != null) {
							if (response.get("errors[" + i + "].extendedDetails.path") != null) {
								MatcherAssert.assertThat(response.get("errors[" + i + "].extendedDetails.path"),
										instanceOf(String.class));
								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										lessThanOrEqualTo(500));

								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										greaterThanOrEqualTo(1));

							}

						}

					}
					MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));

				}
			}
			if (stringifiedStatusCode.equals("415")) {
				System.out.println("Description: Unsupported Media Type");

				if (response.get("id") != null) {
					MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));
					MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));

					MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));

				}

				if (response.get("errors") != null) {
					for (int i = 0; i < response.getList("errors").size(); i++) {
						if (response.get("errors[" + i + "].code") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].code"), instanceOf(String.class));
						}

						if (response.get("errors[" + i + "].causes") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].causes"),
									instanceOf(String.class));
							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									lessThanOrEqualTo(500));

							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									greaterThanOrEqualTo(1));

						}

						if (response.get("errors[" + i + "].extendedDetails") != null) {
							if (response.get("errors[" + i + "].extendedDetails.path") != null) {
								MatcherAssert.assertThat(response.get("errors[" + i + "].extendedDetails.path"),
										instanceOf(String.class));
								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										lessThanOrEqualTo(500));

								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										greaterThanOrEqualTo(1));

							}

						}

					}
					MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));

				}
			}
			if (stringifiedStatusCode.equals("429")) {
				System.out.println("Description: Too Many Requests");

				if (response.get("message") != null) {
					MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
				}
			}
			if (stringifiedStatusCode.equals("500")) {
				System.out.println("Description: Internal Server Error");

				if (response.get("id") != null) {
					MatcherAssert.assertThat(response.get("id"), instanceOf(String.class));
					MatcherAssert.assertThat(response.getString("id").length(), lessThanOrEqualTo(40));

					MatcherAssert.assertThat(response.getString("id").length(), greaterThanOrEqualTo(1));

				}

				if (response.get("errors") != null) {
					for (int i = 0; i < response.getList("errors").size(); i++) {
						if (response.get("errors[" + i + "].code") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].code"), instanceOf(String.class));
						}

						if (response.get("errors[" + i + "].causes") != null) {
							MatcherAssert.assertThat(response.get("errors[" + i + "].causes"),
									instanceOf(String.class));
							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									lessThanOrEqualTo(500));

							MatcherAssert.assertThat(response.getString("errors[" + i + "].causes").length(),
									greaterThanOrEqualTo(1));

						}

						if (response.get("errors[" + i + "].extendedDetails") != null) {
							if (response.get("errors[" + i + "].extendedDetails.path") != null) {
								MatcherAssert.assertThat(response.get("errors[" + i + "].extendedDetails.path"),
										instanceOf(String.class));
								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										lessThanOrEqualTo(500));

								MatcherAssert.assertThat(
										response.getString("errors[" + i + "].extendedDetails.path").length(),
										greaterThanOrEqualTo(1));

							}

						}

					}
					MatcherAssert.assertThat(response.getList("errors"), instanceOf(List.class));

				}
			}
			if (stringifiedStatusCode.equals("503")) {
				System.out.println("Description: Service Unavailable");

				if (response.get("message") != null) {
					MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
				}
			}
			if (stringifiedStatusCode.equals("504")) {
				System.out.println("Description: Gateway Timeout");

				if (response.get("message") != null) {
					MatcherAssert.assertThat(response.get("message"), instanceOf(String.class));
				}
			}

		}
	}

}
