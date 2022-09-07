package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

    private static Properties properties;

    private static void readProperties() {
        properties = new Properties();
        try {
            properties.load(PropertyReader.class.getClassLoader().
                    getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        if (properties == null) {
            readProperties();
        }
        return properties.getProperty(key);
    }

    public static String getSecureProperty(String propertyName) {
        String systemProperty = System.getProperty(propertyName);
        if (systemProperty != null) {
            return systemProperty;
        }
        else return getProperty(propertyName);
    }

    public static String getUserName() {
        return getSecureProperty("username");
    }

    public static String getPassword() {
        return getSecureProperty("password");
    }

    public static String getLoginPageUrl() {
        return getSecureProperty("login.page.url");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(getProperty("headless"));
    }

    public static String getBrowserSize() {
        return getProperty("browserSize");
    }

    public static long getTimeout() {
        return Long.parseLong(getProperty("timeout"));
    }

    public static boolean doesScreenshot() {
        return Boolean.parseBoolean(getProperty("screenshot"));
    }

    public static String getApiUrl() {
        return getSecureProperty("api.url");
    }

    public static String getSecurityToken() {
        return getSecureProperty("security.token");
    }

    public static String getGrantType() {
        return getProperty("grant.type");
    }

    public static String getClientId() {
        return getSecureProperty("client.id");
    }

    public static String getClientSecret() {
        return getSecureProperty("client.secret");
    }

    public static String getAccessTokenEndpoint() {
        return getProperty("access.token.endpoint");
    }

    public static String getLeadUri() {
        return getProperty("lead.uri");
    }

    public static String getContactUri() {
        return getProperty("contact.uri");
    }

    public static String getAccountUri() {
        return getProperty("account.uri");
    }
}
