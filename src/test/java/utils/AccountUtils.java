package utils;

import UI.dto.Account;

import static utils.PropertyReader.getParentAccount;

public class AccountUtils extends BaseUtils {

    private static String parentAccount = getParentAccount();

    public static Account createAccountWithMainInfo() {

        String accountType = faker.options().option(AccountTypeEnum.values()).toString();
        String industry = faker.options().option(IndustryEnum.values()).toString();

        return Account.builder()
                .accountName(faker.name().fullName())
                .parentAccount(parentAccount)
                .phone(faker.phoneNumber().phoneNumber())
                .fax(String.valueOf(faker.number().numberBetween(1000000, 10000000)))
                .website(faker.name().username().concat(".com"))
                .type(accountType)
                .industry(industry)
                .build();
    }

    public static Account createAccountWithOnlyRequiredFields() {
        return Account.builder()
                .accountName(faker.name().fullName())
                .build();
    }
}
