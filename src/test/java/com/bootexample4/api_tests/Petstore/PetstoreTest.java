
package com.bootexample4.api_tests.Petstore;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetstoreTest {

	@Test
	void testAll() {
		String urlbase = System.getenv().get("URL_BASE");
		String authtoken = System.getenv().get("AUTH_TOKEN");
		Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Petstore")
			.systemProperty("URL_BASE", urlbase)
			.systemProperty("AUTH_TOKEN", authtoken)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
