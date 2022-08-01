package UI.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
public class Dropdown extends BaseWrapper {

    public Dropdown(String label) {
        super(label);
    }

    public void selectForAccount(String option) {
        log.info("Set account info for {}: {}", label, option);
        $x(String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//a", label)).click();
        $(String.format("a[title='%s']", option)).click();
    }

    public void selectForContact (String option) {
        log.info("Set contact info for {}: {} ", label, option);
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class," +
                " 'slds-grid')]//button", label)).click();
        $x(String.format("//span[text()='%s']", option)).click();
    }
}
