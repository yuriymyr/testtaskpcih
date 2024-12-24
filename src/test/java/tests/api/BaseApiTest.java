package tests.api;

import api.confg.ApiConfig;
import org.testng.annotations.BeforeClass;
import util.ConfigManager;
import util.LoggerUtil;

public abstract class BaseApiTest {

    @BeforeClass
    public void setupApi() {
        LoggerUtil.info("Initializing API test setup...");

        String baseUri = ConfigManager.get("api.base.url");
        if (baseUri == null || baseUri.isEmpty()) {
            throw new RuntimeException("Base URI is not configured in config.properties");
        }

        ApiConfig.setupBaseURI(baseUri);
        ApiConfig.setupHeaders();

        LoggerUtil.info("API test setup completed with base URI: " + baseUri);
    }
}
