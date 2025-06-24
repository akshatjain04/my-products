
    package com.bootexample4.integration_tests;
  
    import com.intuit.karate.Results;
    import com.intuit.karate.Runner;
    // import com.intuit.karate.http.HttpServer;
    // import com.intuit.karate.http.ServerConfig;
    import org.junit.jupiter.api.Test;
  
    import static org.junit.jupiter.api.Assertions.assertEquals;
  
    class MyProductsTest {
  
        @Test
        void testAll() {
            String petstore_f9ed24e0c0_url = System.getenv().getOrDefault("PETSTORE_F9ED24E0C0_URL", "http://localhost:4010");
String url_base = System.getenv().getOrDefault("url.base", "dummy_url.base");
String auth_token = System.getenv().getOrDefault("AUTH_TOKEN", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFrc2hhdC5qYWluIiwiaWF0IjoxNzI4OTgxMTY1LCJleHAiOjE3Mjk1ODU5NjV9.g_c5b13E-LNjo6NfiZqtUTlcWrCqcrj8EXAJanf43a8");
String api_key = System.getenv().getOrDefault("API_KEY", "dummy_API_KEY");
            Results results = Runner.path("src/test/java/com/bootexample4/integration_tests/MyProducts")
                    .systemProperty("PETSTORE_F9ED24E0C0_URL",petstore_f9ed24e0c0_url)
.systemProperty("url.base", url_base)
.systemProperty("AUTH_TOKEN", auth_token)
.systemProperty("API_KEY", api_key)
                    .reportDir("testReport").parallel(1);
            assertEquals(0, results.getFailCount(), results.getErrorMessages());
        }
  
    }
