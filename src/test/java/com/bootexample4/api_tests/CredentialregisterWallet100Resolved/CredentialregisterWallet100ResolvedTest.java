
    package com.bootexample4.api_tests;
  
    import com.intuit.karate.Results;
    import com.intuit.karate.Runner;
    // import com.intuit.karate.http.HttpServer;
    // import com.intuit.karate.http.ServerConfig;
    import org.junit.jupiter.api.Test;
  
    import static org.junit.jupiter.api.Assertions.assertEquals;
  
    class CredentialregisterWallet100ResolvedTest {
  
        @Test
        void testAll() {
            String credentialregister_wallet_1_0_0_resolved_88376fefa0_url = System.getenv().getOrDefault("CREDENTIALREGISTER_WALLET_1_0_0_RESOLVED_88376FEFA0_URL", "http://127.0.0.1:4010");
            Results results = Runner.path("src/test/java/com/bootexample4/api_tests")
                    .systemProperty("CREDENTIALREGISTER_WALLET_1_0_0_RESOLVED_88376FEFA0_URL",credentialregister_wallet_1_0_0_resolved_88376fefa0_url)
                    .reportDir("testReport").parallel(1);
            assertEquals(0, results.getFailCount(), results.getErrorMessages());
        }
  
    }
