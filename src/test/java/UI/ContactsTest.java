package UI;

import UI.dto.Contact;
import org.testng.annotations.Test;

public class ContactsTest extends BaseTest implements ITestData{

    @Test
    public void createContactWithMainInfo() {
        Contact testContact = CONTACT_WITH_MAIN_INFO;

        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToContactsPage();
        contactSteps.createContactWithMainInfo(testContact);

        contactSteps.checkMainInfoOfCreatedContact(testContact);
    }

    @Test
    public void createContactWithOnlyRequiredFields() {
        Contact testContact = CONTACT_WITH_REQUIRED_FIELDS_ONLY;

        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToContactsPage();
        contactSteps.createContactWithRequiredFieldsOnly(testContact);

        contactSteps.checkRequiredFields(testContact);
    }

    @Test
    public void createAccountWithEmptyFields() {
        loginSteps.login(USER_FROM_CONFIG);
        homePageSteps.goToContactsPage();
        contactSteps.createContactWithEmptyFields();

        contactSteps.checkErrorMessages();
    }
}
