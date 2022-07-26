package utils;

import UI.dto.Account;
import com.github.javafaker.Faker;

public class AccountUtils {

    private static Faker faker = new Faker();
    private static String parentAccount = "Ernesto Osinski";

    public static Account createAccountWithMainInfo() {

        String accountType = faker.options().option(AccountType.values()).toString();
        String industry = faker.options().option(Industry.values()).toString();

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
