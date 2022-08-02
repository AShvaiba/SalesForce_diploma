package utils;

import UI.dto.Contact;

import static utils.PropertyReader.getAccountName;
import static utils.PropertyReader.getContactToReport;

public class ContactUtils extends BaseUtils {

    private static String accountName = getAccountName();
    private static String contactToReport = getContactToReport();

    public static Contact createContactWithMainInfo() {
        String salutation = faker.options().option(ContactSalutationEnum.values()).toString();

        return Contact.builder()
                .salutation(salutation)
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .accountName(accountName)
                .title(faker.animal().name())
                .phone(faker.phoneNumber().cellPhone())
                .mobile(faker.phoneNumber().subscriberNumber())
                .email(faker.name().username().concat("@blabla.com"))
                .reportsTo(contactToReport)
                .build();
    }

    public static Contact createContactWithOnlyRequiredFields() {
        return Contact.builder()
                .lastName(faker.name().lastName())
                .accountName(accountName)
                .build();
    }
}
