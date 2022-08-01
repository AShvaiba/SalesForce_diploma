package UI.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class InputWithSuggestion extends BaseWrapper{

    public InputWithSuggestion(String label) {
        super(label);
    }

    public void inputSuggestionForAccount(String text) {
        log.info("Set account info for {}: {}", label, text);
        $x(String.format("//span[text()='%s']" +
                "/ancestor::div[contains(@class, 'uiInput')]//input", label)).sendKeys(text);
        $x(String.format("//div[@title='%s']", text)).shouldBe(visible)
                .click();
    }

    public void inputSuggestionForContact(String text) {
        log.info("Set contact info for {}: {}", label, text);
        $x(String.format("//label[text()='%s']/ancestor::div[contains(@class, 'slds-grid')]//input", label))
                .sendKeys(text);
        $x(String.format("//strong[text()='%s']", text)).shouldBe(visible)
                .click();
    }
}
