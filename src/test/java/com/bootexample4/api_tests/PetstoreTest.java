
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
          String apiHostServer = System.getenv().getOrDefault("url2_petstore_URL_BASE", "http://localhost:4010");
String url2petstoreauthtoken = System.getenv().getOrDefault("url2_petstore_AUTH_TOKEN", "dummy_url2_petstore_AUTH_TOKEN");
String apiHostServer = System.getenv().getOrDefault("abcd_URL1_TRESOURCEPOOLMANAGEMENT__2__URL_BASE", "http://localhost:4010");
String abcdurl1tresourcepoolmanagement2authtoken = System.getenv().getOrDefault("abcd_URL1_TRESOURCEPOOLMANAGEMENT__2__AUTH_TOKEN", "dummy_abcd_URL1_TRESOURCEPOOLMANAGEMENT__2__AUTH_TOKEN");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests/Petstore")
                  .systemProperty("url2_petstore_URL_BASE", apiHostServer)
.systemProperty("url2_petstore_AUTH_TOKEN", url2petstoreauthtoken)
.systemProperty("abcd_URL1_TRESOURCEPOOLMANAGEMENT__2__URL_BASE", apiHostServer)
.systemProperty("abcd_URL1_TRESOURCEPOOLMANAGEMENT__2__AUTH_TOKEN", abcdurl1tresourcepoolmanagement2authtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
