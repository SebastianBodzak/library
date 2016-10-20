package pl.com.sebastianbodzak.library.api.dtos;

import pl.com.sebastianbodzak.library.api.InvalidRequestException;

/**
 * Created by Dell on 2016-10-12.
 */
public class AddressDto {

    private String city;
    private String street;
    private String postalCode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void validate() {
        if (city == null || street == null || postalCode == null)
            throw new InvalidRequestException("Address required city, street and postal code");
    }
}
