package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private Properties properties;

    public PropertyReader() {
        properties = new Properties();
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getUserName() {
        return getProperty("username");
    }

    public String getPassword() {
        return getProperty("password");
    }

    public String getLoginPageUrl() {
        return getProperty("login.page.url");
    }
}
