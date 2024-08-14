
  package com.bootexample4.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class CredentialregisterWallet100Resolved {

      @Test
      void testAll() {
          String urlbase = System.getenv().getOrDefault("url.base", "dummy_url.base");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/CredentialregisterWallet100Resolved")
                  .systemProperty("url.base", urlbase)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
