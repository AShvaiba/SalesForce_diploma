package UI.wrappers;

import com.codeborne.selenide.Condition;
import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class InputWithSuggestion extends BaseWrapper{

    public InputWithSuggestion(String label) {
        super(label);
    }

    public void inputSuggestion (String text) {
        log.info("Set info for input with suggestion: {}", text);
        $x(String.format("//span[text()='%s']" +
                "/ancestor::div[contains(@class, 'uiInput')]//input", label)).sendKeys(text);
        $x(String.format("//div[@title='%s']", text)).shouldBe(Condition.visible);
        $x(String.format("//div[@title='%s']", text)).click();
    }
}
