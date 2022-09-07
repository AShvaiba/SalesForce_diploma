package data;

import dto.Lead;
import dto.Account;
import dto.Contact;
import dto.SalesforceUser;
import com.github.javafaker.Faker;
import utils.*;

import static utils.PropertyReader.*;

public interface ITestData {

    Faker faker = new Faker();

    SalesforceUser USER_FROM_CONFIG = SalesforceUser.builder()
            .username(getUserName())
            .password(getPassword())
            .build();

    //accounts
    Account PRECONDITIONS_ACCOUNT = Account.builder()
            .accountName("Test")
            .build();

    Account ACCOUNT_WITH_MAIN_INFO = Account.builder()
            .accountName(faker.name().lastName())
            .parentAccount(PRECONDITIONS_ACCOUNT.getAccountName())
            .phone(faker.phoneNumber().phoneNumber())
            .fax(String.valueOf(faker.number().numberBetween(1000000, 10000000)))
            .website(faker.name().username().concat(".com"))
            .type(faker.options().option(AccountTypeEnum.values()).toString())
            .industry(faker.options().option(IndustryEnum.values()).toString())
            .build();

    Account ACCOUNT_WITH_REQUIRED_FIELDS_ONLY = Account.builder()
            .accountName(faker.name().lastName())
            .build();

    //contacts
    Contact PRECONDITIONS_CONTACT = Contact.builder()
            .lastName("Report_Contact")
            .build();

    Contact CONTACT_WITH_MAIN_INFO = Contact.builder()
            .salutation(faker.options().option(SalutationEnum.values()).toString())
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .accountName(PRECONDITIONS_ACCOUNT.getAccountName())
            .title(faker.animal().name())
            .phone(faker.phoneNumber().phoneNumber())
            .mobile(faker.phoneNumber().subscriberNumber())
            .email(faker.name().username().concat("@sales.com"))
            .reportsTo(PRECONDITIONS_CONTACT.getLastName())
            .build();

    Contact CONTACT_WITH_REQUIRED_FIELDS_ONLY = Contact.builder()
            .lastName(faker.name().lastName())
            .build();

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

    //expected error messages
    String ERROR_CODE_MISSED_FIELDS_FOR_LEAD_CREATION = "REQUIRED_FIELD_MISSING";
    String ERROR_MESSAGE_MISSED_ALL_FIELDS_FOR_LEAD_CREATION = "Required fields are missing: [LastName, Company]";

    //status codes
    int CODE_200_OK = 200;
    int CODE_201_CREATED = 201;
    int CODE_204_NO_CONTENT = 204;
    int CODE_404_NOT_FOUND = 404;
}

