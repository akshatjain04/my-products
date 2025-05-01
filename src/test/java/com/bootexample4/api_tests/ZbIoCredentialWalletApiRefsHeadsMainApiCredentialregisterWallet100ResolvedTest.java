
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
          String apiHostServer = System.getenv().getOrDefault("url1_swagger_URL_BASE", "https://petstore.swagger.io");
String url1swaggerauthtoken = System.getenv().getOrDefault("url1_swagger_AUTH_TOKEN", "auth1");
String apiHostServer = System.getenv().getOrDefault("url2_credentialregister-wallet-1.0.0-resolved_URL_BASE", "https://virtserver.swaggerhub.com/credentialregister/wallet/1.0.0");
String url2credentialregisterwallet100resolvedauthtoken = System.getenv().getOrDefault("url2_credentialregister-wallet-1.0.0-resolved_AUTH_TOKEN", "dummy_url2_credentialregister-wallet-1.0.0-resolved_AUTH_TOKEN");
String urlbase = System.getenv().getOrDefault("url.base", "dummy_url.base");
String authtoken = System.getenv().getOrDefault("AUTH_TOKEN", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFrc2hhdC5qYWluIiwiaWF0IjoxNzI4OTgxMTY1LCJleHAiOjE3Mjk1ODU5NjV9.g_c5b13E-LNjo6NfiZqtUTlcWrCqcrj8EXAJanf43a8");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/ZbIoCredentialWalletApiRefsHeadsMainApiCredentialregisterWallet100Resolved")
                  .systemProperty("url1_swagger_URL_BASE", apiHostServer)
.systemProperty("url1_swagger_AUTH_TOKEN", url1swaggerauthtoken)
.systemProperty("url2_credentialregister-wallet-1.0.0-resolved_URL_BASE", apiHostServer)
.systemProperty("url2_credentialregister-wallet-1.0.0-resolved_AUTH_TOKEN", url2credentialregisterwallet100resolvedauthtoken)
.systemProperty("url.base", urlbase)
.systemProperty("AUTH_TOKEN", authtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
