package pl.com.sebastianbodzak.library.api.dtos;

import pl.com.sebastianbodzak.library.api.EmailValidator;
import pl.com.sebastianbodzak.library.api.InvalidRequestException;
import pl.com.sebastianbodzak.library.api.PhoneValidator;
import pl.com.sebastianbodzak.library.api.dtos.AddressDto;

/**
 * Created by Dell on 2016-10-11.
 */
public class PersonalDataDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private AddressDto address;

    public void validate() {
        if (firstName == null || lastName == null || email == null || phone == null || address == null)
            throw new InvalidRequestException("Personal Data required first name, last name, email, phone and address");
        address.validate();
        if (!new EmailValidator().validate(email))
            throw new InvalidRequestException("Email is invalid");
        if (!new PhoneValidator().validate(phone))
            throw new InvalidRequestException("Phone is invalid");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }
}
