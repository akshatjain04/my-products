
package com.bootexample4.api_tests;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
// import com.intuit.karate.http.HttpServer;
// import com.intuit.karate.http.ServerConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZbIoCredentialWalletApiRefsHeadsMainApiCredentialregisterWallet100ResolvedTest {

	@Test
	void testAll() {
		String apiHostServer = System.getenv()
			.getOrDefault("url2_credentialregister-wallet-1.0.0-resolved_URL_BASE",
					"https://virtserver.swaggerhub.com/credentialregister/wallet/1.0.0");
		String url2credentialregisterwallet100resolvedauthtoken = System.getenv()
			.getOrDefault("url2_credentialregister-wallet-1.0.0-resolved_AUTH_TOKEN",
					"dummy_url2_credentialregister-wallet-1.0.0-resolved_AUTH_TOKEN");
		Results results = Runner.path(
				"src/test/java/com/bootexample4/api_tests/ZbIoCredentialWalletApiRefsHeadsMainApiCredentialregisterWallet100Resolved")
			.systemProperty("url2_credentialregister-wallet-1.0.0-resolved_URL_BASE", apiHostServer)
			.systemProperty("url2_credentialregister-wallet-1.0.0-resolved_AUTH_TOKEN",
					url2credentialregisterwallet100resolvedauthtoken)
			.reportDir("testReport")
			.parallel(1);
		assertEquals(0, results.getFailCount(), results.getErrorMessages());
	}

}
