
package com.bootexample4.api_tests.RoostIoJavaSpringbootunitRefsHeadsMainOpenapi;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoostIoJavaSpringbootunitRefsHeadsMainOpenapiTest {

	@Test
	void testAll() {
		String URLBASE = System.getenv().get("URL_BASE");
		String AUTHTOKEN = System.getenv().get("AUTH_TOKEN");
		Results results = Runner
			.path("src/test/java/com/bootexample4/api_tests/RoostIoJavaSpringbootunitRefsHeadsMainOpenapi")
			.systemProperty("URL_BASE", URLBASE)
			.systemProperty("AUTH_TOKEN", AUTHTOKEN)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
