package pl.com.sebastianbodzak.library.domain;

import javax.persistence.Embeddable;

/**
 * Created by Dell on 2016-10-11.
 */
@Embeddable
public class Address {

    private String city;
    private String street;
    private String postalCode;

    private Address() {}

    public Address(String city, String street, String postalCode) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
