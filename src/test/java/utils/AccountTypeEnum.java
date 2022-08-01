package utils;

public enum AccountTypeEnum {

    ANALYST("Analyst"),
    COMPETITOR("Competitor"),
    CUSTOMER("Customer"),
    INTEGRATOR("Integrator"),
    INVESTOR("Investor"),
    PARTNER("Partner"),
    PRESS("Press"),
    PROSPECT("Prospect"),
    RESELLER("Reseller"),
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
