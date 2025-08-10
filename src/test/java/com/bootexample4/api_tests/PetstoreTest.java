
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
          String apiHostServer = System.getenv().getOrDefault("abcd_URL_BASE", "http://localhost:4010");
String abcdauthtoken = System.getenv().getOrDefault("abcd_AUTH_TOKEN", "dummy_abcd_AUTH_TOKEN");
String apiHostServer = System.getenv().getOrDefault("abcd_URL1_TRESOURCEPOOLMANAGEMENT__2__URL1_TRESOURCEPOOLMANAGEMENT__2__URL1_TRESOURCEPOOLMANAGEMENT__2__URL_BASE", "http://localhost:4010");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Petstore")
                  .systemProperty("abcd_URL_BASE", apiHostServer)
.systemProperty("abcd_AUTH_TOKEN", abcdauthtoken)
.systemProperty("abcd_URL1_TRESOURCEPOOLMANAGEMENT__2__URL1_TRESOURCEPOOLMANAGEMENT__2__URL1_TRESOURCEPOOLMANAGEMENT__2__URL_BASE", apiHostServer)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
