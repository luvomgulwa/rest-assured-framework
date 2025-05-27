package config;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;

public class TestConfig {
    public static void configure() {
        RestAssured.baseURI = ConfigManager.getBaseURI();
        RestAssured.port = ConfigManager.getPort();
        RestAssured.basePath = ConfigManager.getBasePath();

        if(!ConfigManager.getEnv().equalsIgnoreCase("prod")) {
            RestAssured.filters(
                    new RequestLoggingFilter(),
                    new RequestLoggingFilter()
            );
        }

        //
    }
}
