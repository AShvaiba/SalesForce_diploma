package UI.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Contact {

    private String salutation;
    private String firstName;
    private String lastName;
    private String accountName;
    private String title;
    private String phone;
    private String mobile;
    private String email;
    private String reportsTo;

    private String mailingStreet;
    private String mailingCity;
    private String mailingZipCode;
    private String mailingState;
    private String mailingCountry;

    private String otherStreet;
    private String otherCity;
    private String otherZipCode;
    private String otherState;
    private String otherCountry;

    private String fax;
    private String homePhone;
    private String otherPhone;
    private String asstPhone;
    private String assistant;
    private String department;
    private String leadSource;
    private String birthDate;
    private String description;
}
