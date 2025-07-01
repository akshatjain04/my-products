
package com.bootexample4.api_tests;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetstoreTest {

	@Test
	void testAll() {
		String petbaseurl = System.getenv().get("PET_BASE_URL");
		String petauthtoken = System.getenv().get("PET_AUTH_TOKEN");
		Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Petstore")
			.systemProperty("PET_BASE_URL", petbaseurl)
			.systemProperty("PET_AUTH_TOKEN", petauthtoken)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
