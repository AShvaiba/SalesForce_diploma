package utils;

public enum ContactSalutationEnum {

    MR("Mr."),
    MS("Ms."),
    MRS("Mrs."),
    DR("Dr."),
    PROF("Prof."),
    ;

    private final String salutation;

    ContactSalutationEnum(String salutation) {
        this.salutation = salutation;
    }

    @Override
    public String toString() {
        return salutation;
    }
}
