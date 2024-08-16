
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
            String credentialregister_wallet_1_0_0_resolved_88376fefa0_url = System.getenv().getOrDefault("CREDENTIALREGISTER_WALLET_1_0_0_RESOLVED_88376FEFA0_URL", "http://127.0.0.1:4011");
String credentialregister_wallet_1_0_0_resolved_88376fefa0_auth_token = System.getenv().getOrDefault("CREDENTIALREGISTER_WALLET_1_0_0_RESOLVED_88376FEFA0_AUTH_TOKEN", "dummy_CREDENTIALREGISTER_WALLET_1_0_0_RESOLVED_88376FEFA0_AUTH_TOKEN");
            Results results = Runner.path("src/test/java/com/bootexample4/api_tests/CredentialregisterWallet100Resolved")
                    .systemProperty("CREDENTIALREGISTER_WALLET_1_0_0_RESOLVED_88376FEFA0_URL",credentialregister_wallet_1_0_0_resolved_88376fefa0_url)
.systemProperty("CREDENTIALREGISTER_WALLET_1_0_0_RESOLVED_88376FEFA0_AUTH_TOKEN", credentialregister_wallet_1_0_0_resolved_88376fefa0_auth_token)
                    .reportDir("testReport").parallel(1);
            assertEquals(0, results.getFailCount(), results.getErrorMessages());
        }
  
    }
