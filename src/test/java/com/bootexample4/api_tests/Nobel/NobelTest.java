
package com.bootexample4.api_tests;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NobelTest {

	@Test
	void testAll() {
		String nobelapihost = System.getenv().get("NOBEL_API_HOST");
		Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Nobel")
			.systemProperty("NOBEL_API_HOST", nobelapihost)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
