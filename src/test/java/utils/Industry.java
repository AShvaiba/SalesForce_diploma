package utils;

public enum Industry {

    AGRICULTURE("Agriculture"),
    APPAREL("Apparel"),
    BANKING("Banking"),
    BIOTECHNOLOGY("Biotechnology"),
    CHEMICALS("Chemicals"),
    COMMUNICATIONS("Communications"),
    CONSTRUCTION("Construction"),
    EDUCATION("Education"),
    ELECTRONICS("Electronics"),
    ENERGY("Energy"),
    ENGINEERING("Engineering"),
    ENTERTAINMENT("Entertainment"),
    ENVIRONMENTAL("Environmental"),
    FINANCE("Finance"),
    FOOD_AND_BEVERAGE("Food & Beverage"),
    GOVERNMENT("Government"),
    HEALTHCARE("Healthcare"),
    HOSPITALITY("Hospitality"),
    INSURANCE("Insurance"),
    MACHINERY("Machinery"),
    MANUFACTURING("Manufacturing"),
    NOT_FOR_PROFIT("Not For Profit"),
    OTHER("Other"),
    RECREATION("Recreation"),
    RETAIL("Retail"),
    SHIPPING("Shipping"),
    TECHNOLOGY("Technology"),
    TELECOMMUNICATION("Telecommunication"),
    TRANSPORTATION("Transportation"),
    UTILITIES("Utilities"),
    ;

    private final String industryTitle;

    Industry(String industryTitle) {
        this.industryTitle = industryTitle;
    }

    @Override
    public String toString() {
        return industryTitle;
    }
}
