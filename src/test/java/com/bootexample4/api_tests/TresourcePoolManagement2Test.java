
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
            String tresourcepoolmanagement__2__6fc8931d6a_url = System.getenv().getOrDefault("TRESOURCEPOOLMANAGEMENT__2__6FC8931D6A_URL", "http://127.0.0.1:4012");
String tresourcepoolmanagement__2__6fc8931d6a_auth_token = System.getenv().getOrDefault("TRESOURCEPOOLMANAGEMENT__2__6FC8931D6A_AUTH_TOKEN", "dummy_TRESOURCEPOOLMANAGEMENT__2__6FC8931D6A_AUTH_TOKEN");
            Results results = Runner.path("src/test/java/com/bootexample4/api_tests/TresourcePoolManagement2")
                    .systemProperty("TRESOURCEPOOLMANAGEMENT__2__6FC8931D6A_URL",tresourcepoolmanagement__2__6fc8931d6a_url)
.systemProperty("TRESOURCEPOOLMANAGEMENT__2__6FC8931D6A_AUTH_TOKEN", tresourcepoolmanagement__2__6fc8931d6a_auth_token)
                    .reportDir("testReport").parallel(1);
            assertEquals(0, results.getFailCount(), results.getErrorMessages());
        }
  
    }
