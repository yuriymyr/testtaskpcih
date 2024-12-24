package util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.util.Properties;

@UtilityClass
public class ConfigManager {
    private static final Properties properties = new Properties();

    static {
        try (var inputStream = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("config.properties not found in classpath");
            }
            properties.load(inputStream);
            System.out.println("Loaded properties: " + properties);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration", e);
        }
    }
    public String get(String key) {
        return properties.getProperty(key);
    }
}