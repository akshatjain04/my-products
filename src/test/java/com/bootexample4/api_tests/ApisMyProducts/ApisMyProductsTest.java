
package com.bootexample4.api_tests.ApisMyProducts;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApisMyProductsTest {

	@Test
	void testAll() {
		String myproductsbaseurl = System.getenv().get("MY_PRODUCTS_BASE_URL");
		Results results = Runner.path("src/test/java/com/bootexample4/api_tests/ApisMyProducts")
			.systemProperty("MY_PRODUCTS_BASE_URL", myproductsbaseurl)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
