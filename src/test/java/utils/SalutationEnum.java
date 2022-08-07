package utils;

public enum SalutationEnum {

    MR("Mr."),
    MS("Ms."),
    MRS("Mrs."),
    DR("Dr."),
    PROF("Prof."),
    ;

    private final String salutation;

    SalutationEnum(String salutation) {
        this.salutation = salutation;
    }

    @Override
    public String toString() {
        return salutation;
    }
}
