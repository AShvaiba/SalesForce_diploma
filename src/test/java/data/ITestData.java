package data;

import API.dto.Lead;
import UI.dto.Account;
import UI.dto.Contact;
import UI.dto.SalesforceUser;
import com.github.javafaker.Faker;
import utils.AccountUtils;
import utils.ContactUtils;
import utils.IndustryEnum;
import utils.SalutationEnum;

import static utils.PropertyReader.getPassword;
import static utils.PropertyReader.getUserName;

public interface ITestData {

    Faker faker = new Faker();

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

    //leads
    Lead LEAD_WITH_MAIN_INFO = Lead.builder()
            .salutation(faker.options().option(SalutationEnum.values()).toString())
            .lastName(faker.name().lastName())
            .firstName(faker.name().firstName())
            .company(faker.company().name())
            .title(faker.animal().name())
            .industry(faker.options().option(IndustryEnum.values()).toString())
            .email(faker.name().username().concat("@sales.com"))
            .build();

    Lead LEAD_WITH_REQUIRED_FIELDS_ONLY = Lead.builder()
            .lastName(faker.name().lastName())
            .company(faker.company().name())
            .build();

    Lead LEAD_WITH_EMPTY_FIELDS = Lead.builder()
            .lastName(faker.name().lastName())
            .build();

    //expected error messages
    String ERROR_CODE_MISSED_FIELDS_FOR_LEAD_CREATION = "REQUIRED_FIELD_MISSING";
    String ERROR_MESSAGE_MISSED_ALL_FIELDS_FOR_LEAD_CREATION = "Required fields are missing: [LastName, Company]";

    //status codes
    int CODE_200_OK = 200;
    int CODE_201_CREATED = 201;
    int CODE_204_NO_CONTENT = 204;
    int CODE_404_NOT_FOUND = 404;
}

