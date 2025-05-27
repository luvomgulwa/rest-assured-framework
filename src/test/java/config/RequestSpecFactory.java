package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;

public class RequestSpecFactory {
    public static RequestSpecification getDefaultRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getBaseURI())
                .setPort(ConfigManager.getPort())
                .setBasePath(ConfigManager.getBasePath())
                .setContentType(ContentType.JSON)
                .setAccept("application/json")
                .build();
    }

    public static RequestSpecification getAuthenticatedRequestSpec(String token) {
        return new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    public static RequestSpecification getRequestSpecWithBasicAuth() {
        return new RequestSpecBuilder()
                .addHeader("Authorization", "Basic " + java.util.Base64.getEncoder().encodeToString(
                        (ConfigManager.getAuthUsername() + ":" + Arrays.toString(ConfigManager.getAuthPassword().getBytes())).getBytes()
                )).build();
    }
}
