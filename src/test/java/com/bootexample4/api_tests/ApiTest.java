
  package com.bootexample4.api_tests;

  import com.intuit.karate.Results;
  import com.intuit.karate.Runner;
  // import com.intuit.karate.http.HttpServer;
  // import com.intuit.karate.http.ServerConfig;
  import org.junit.jupiter.api.Test;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  class ApiTest {

      @Test
      void testAll() {
          String apiHostServer = System.getenv().getOrDefault("API_HOST", "https://dev.roost.ai/api/");
String authtoken = System.getenv().getOrDefault("AUTH_TOKEN", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFrc2hhdC5qYWluIiwiaWF0IjoxNzIxMjA5MDc1LCJleHAiOjE3MjE4MTM4NzV9.z16J-TcpuTLr9hzWWbrI18hELZj-DX_IIrXzaVobcXw");
          Results results = Runner.path("src/test/java/com/bootexample4/api_tests")
                  .systemProperty("url.base", apiHostServer)
.systemProperty("AUTH_TOKEN", authtoken)
                  .reportDir("testReport").parallel(1);
          assertEquals(0, results.getFailCount(), results.getErrorMessages());
      }

  }
