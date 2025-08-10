
package com.bootexample4.api_tests;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TresourcePoolManagement2Test {

	@Test
	void testAll() {
		String apiHostServer = System.getenv()
			.getOrDefault("url1_tresourcePoolManagement_(2)_URL_BASE", "http://localhost:4010");
		String url1tresourcepoolmanagement2authtoken = System.getenv()
			.getOrDefault("url1_tresourcePoolManagement_(2)_AUTH_TOKEN",
					"dummy_url1_tresourcePoolManagement_(2)_AUTH_TOKEN");
		Results results = Runner.path("src/test/java/com/bootexample4/api_tests/TresourcePoolManagement2")
			.systemProperty("url1_tresourcePoolManagement_(2)_URL_BASE", apiHostServer)
			.systemProperty("url1_tresourcePoolManagement_(2)_AUTH_TOKEN", url1tresourcepoolmanagement2authtoken)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
