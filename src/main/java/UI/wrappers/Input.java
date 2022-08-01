package UI.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Input extends BaseWrapper {

    public Input(String label) {
        super(label);
    }

    public void writeForAccount(String text) {
        log.info("Set account info for {}: {}", label, text);
        $x(String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input", label))
                .sendKeys(text);
    }

    public void writeForContact(String text) {
        log.info("Set contact info for {}: {} ", label, text);
        if (label.equals("Last Name")) {
            $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]" +
                    "//input[@name='lastName']", label))
                    .sendKeys(text);
            return;
        }

        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//input", label))
                .sendKeys(text);
    }
}
