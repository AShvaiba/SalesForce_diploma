package UI.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Input extends BaseWrapper{

    public Input(String label) {
        super(label);
    }

    public void writeForAccount(String text) {
        log.info("Set info for regular input: {}", text);
        $x(String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//input", label))
                .sendKeys(text);
    }
}
