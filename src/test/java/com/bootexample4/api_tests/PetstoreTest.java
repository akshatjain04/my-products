
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
		String apiHostServer = System.getenv().getOrDefault("demoapp_URL_BASE", "https://petstore3.swagger.io/api/v3/");
		String demoappauthtoken = System.getenv().getOrDefault("demoapp_AUTH_TOKEN", "dummy_demoapp_AUTH_TOKEN");
		Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Petstore")
			.systemProperty("demoapp_URL_BASE", apiHostServer)
			.systemProperty("demoapp_AUTH_TOKEN", demoappauthtoken)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
