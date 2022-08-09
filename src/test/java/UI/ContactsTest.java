package UI;

import dto.Contact;
import org.testng.annotations.Test;
import utils.Retry;

public class ContactsTest extends BaseTest {

    @Test(description = "Test creation new contact with main info specified",
            retryAnalyzer = Retry.class)
    public void createContactWithMainInfo() {
        Contact testContact = CONTACT_WITH_MAIN_INFO;

        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToSalesConsolePage();
        salesConsolePageSteps.goToContactsPage();
        contactSteps.createContactWithMainInfo(testContact);

        contactSteps.checkMainInfoOfCreatedContact(testContact);
    }

    @Test(description = "Test creation new contact with only required info specified",
            retryAnalyzer = Retry.class)
    public void createContactWithOnlyRequiredFields() {
        Contact testContact = CONTACT_WITH_REQUIRED_FIELDS_ONLY;

        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToSalesConsolePage();
        salesConsolePageSteps.goToContactsPage();
        contactSteps.createContactWithRequiredFieldsOnly(testContact);

        contactSteps.checkRequiredFields(testContact);
    }

    @Test(description = "Test creation new contact with empty fields",
            retryAnalyzer = Retry.class)
    public void createContactWithEmptyFields() {
        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToSalesConsolePage();
        salesConsolePageSteps.goToContactsPage();
        contactSteps.createContactWithEmptyFields();

        contactSteps.checkErrorMessages();
    }
}
