package UI.browser;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Browsers.*;
import static utils.PropertyReader.*;

public class SelenideConfiguration {

    public static void configureBrowser(String browser) {
        setUpBasicConfiguration();

        switch (browser) {
            case "safari":
                Configuration.browser = SAFARI;
                break;
            case "firefox":
                Configuration.browser = FIREFOX;
                break;
            default:
                Configuration.browser = CHROME;
                break;
        }
    }

    public static void setUpBasicConfiguration() {

        Configuration.baseUrl = getLoginPageUrl();
        Configuration.screenshots = isHeadless();
        Configuration.timeout = getTimeout();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
                .includeSelenideSteps(true)
        );
    }
}
