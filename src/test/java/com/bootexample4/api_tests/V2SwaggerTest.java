
  package com.bootexample4.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class V2SwaggerTest {

      @Test
      void testAll() {
          String apiHostServer = System.getenv().getOrDefault("nabcd_URL_BASE", "http://localhost:4010");
String nabcdauthtoken = System.getenv().getOrDefault("nabcd_AUTH_TOKEN", "dummy_nabcd_AUTH_TOKEN");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/V2Swagger")
                  .systemProperty("nabcd_URL_BASE", apiHostServer)
.systemProperty("nabcd_AUTH_TOKEN", nabcdauthtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
