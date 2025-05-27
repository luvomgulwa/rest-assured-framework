package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties;
    private static final String DEFAULT_ENV = "dev";

    static {
        loadProperties(System.getProperty("env", DEFAULT_ENV));
    }

    private static void loadProperties(String env) {
        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream("config/" + env + ".properties")) {

            properties = new Properties();
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("Unable to find properties file for environment: " + env);
            }

            // Load default properties as fallback
            try (InputStream defaultInput = ConfigManager.class.getClassLoader()
                    .getResourceAsStream("application.properties")) {
                if (defaultInput != null) {
                    Properties defaultProperties = new Properties();
                    defaultProperties.load(defaultInput);
                    defaultProperties.forEach((key, value) ->
                            properties.putIfAbsent(key, value));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseURI() {
        return getProperty("baseURI");
    }

    public static String getBasePath() {
        return getProperty("basePath");
    }

    public static int getPort() {
        return Integer.parseInt((getProperty("port")));
    }

    public static String getEnv() {
        return getProperty("env");
    }

    public static String getAuthUsername() {
        return getProperty("auth.username");
    }

    public static String getAuthPassword() {
        return getProperty("auth.password");
    }
}
