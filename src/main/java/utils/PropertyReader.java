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

    public static String getUserName() {
        return getProperty("username");
    }

    public static String getPassword() {
        return getProperty("password");
    }

    public static String getLoginPageUrl() {
        return getProperty("login.page.url");
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

    public static String getApiUrl() {
        return getProperty("api.url");
    }

    public static String getSecurityToken() {
        return getProperty("security.token");
    }

    public static String getGrantType() {
        return getProperty("grant.type");
    }

    public static String getClientId() {
        return getProperty("client.id");
    }

    public static String getClientSecret() {
        return getProperty("client.secret");
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
