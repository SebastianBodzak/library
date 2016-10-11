package pl.com.sebastianbodzak.library.domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Created by Dell on 2016-10-11.
 */
@Embeddable
public class PersonalData {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Embedded
    private Address address;

    private PersonalData() {}

    public PersonalData(String firstName, String lastName, String email, String phone, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }
}
