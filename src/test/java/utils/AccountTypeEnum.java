package utils;

public enum AccountTypeEnum {

    PROSPECT("Prospect"),
    CUSTOMER_DIRECT("Customer - Direct"),
    CUSTOMER_CHANNEL("Customer - Channel"),
    CHANNEL_PARTNER("Channel Partner / Reseller"),
    INSTALLATION_PARTNER("Installation Partner"),
    TECHNOLOGY_PARTNER("Technology Partner"),
    OTHER("Other"),
    ;

    private final String accountType;

    AccountTypeEnum(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return accountType;
    }
}
