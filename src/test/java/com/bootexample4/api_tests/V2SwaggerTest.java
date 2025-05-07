
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
            String swagger_184f1d2b61_url = System.getenv().getOrDefault("SWAGGER_184F1D2B61_URL", "http://127.0.0.1:4020");
String swagger_184f1d2b61_auth_token = System.getenv().getOrDefault("SWAGGER_184F1D2B61_AUTH_TOKEN", "dummy_SWAGGER_184F1D2B61_AUTH_TOKEN");
            Results results = Runner.path("src/test/java/com/bootexample4/api_tests/V2Swagger")
                    .systemProperty("SWAGGER_184F1D2B61_URL",swagger_184f1d2b61_url)
.systemProperty("SWAGGER_184F1D2B61_AUTH_TOKEN", swagger_184f1d2b61_auth_token)
                    .reportDir("testReport").parallel(1);
            assertEquals(0, results.getFailCount(), results.getErrorMessages());
        }
  
    }
