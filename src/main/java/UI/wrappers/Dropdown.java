package UI.wrappers;

import lombok.extern.log4j.Log4j2;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@Log4j2
public class Dropdown extends BaseWrapper {

    public Dropdown(String label) {
        super(label);
    }

    public void selectForAccount(String option) {
        log.info("Set info from dropdown: {}", option);
        $x(String.format("//span[text()='%s']/ancestor::div[contains(@class, 'uiInput')]//a", label)).click();
        $(String.format("a[title='%s']", option)).click();
    }
}
