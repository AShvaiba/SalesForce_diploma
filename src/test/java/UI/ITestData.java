package UI;

import UI.dto.Account;
import UI.dto.Contact;
import UI.dto.SalesforceUser;
import utils.AccountUtils;
import utils.ContactUtils;

import static utils.PropertyReader.getPassword;
import static utils.PropertyReader.getUserName;

public interface ITestData {

    SalesforceUser USER_FROM_CONFIG = SalesforceUser.builder()
            .username(getUserName())
            .password(getPassword())
            .build();

    //accounts
    Account ACCOUNT_WITH_MAIN_INFO = AccountUtils.createAccountWithMainInfo();

    Account ACCOUNT_WITH_REQUIRED_FIELDS_ONLY = AccountUtils.createAccountWithOnlyRequiredFields();

    //contacts
    Contact CONTACT_WITH_MAIN_INFO = ContactUtils.createContactWithMainInfo();

    Contact CONTACT_WITH_REQUIRED_FIELDS_ONLY = ContactUtils.createContactWithOnlyRequiredFields();
}
