package pl.com.sebastianbodzak.library.api.requests;

import org.apache.commons.lang3.EnumUtils;
import pl.com.sebastianbodzak.library.api.InvalidRequestException;
import pl.com.sebastianbodzak.library.api.dtos.PersonalDataDto;
import pl.com.sebastianbodzak.library.domain.JobTitle;

/**
 * Created by Dell on 2016-10-11.
 */
public class CreateEmployeeRequest {

    private PersonalDataDto personalData;
    private String jobTitle;
    private Long id;

    public void validate() {
        if (personalData == null || jobTitle == null || id == null)
            throw new InvalidRequestException("Personal data and job title are required");
        validateProfession();
        personalData.validate();
    }

    private void validateProfession() {
        if (!EnumUtils.isValidEnum(JobTitle.class, jobTitle))
            throw new InvalidRequestException("Wrong type of job title");
    }

    public PersonalDataDto getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalDataDto personalData) {
        this.personalData = personalData;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle.toUpperCase();
    }

    public String getFirstName() {
        return personalData.getFirstName();
    }

    public String getLastName() {
        return personalData.getLastName();
    }

    public String getEmail() {
        return personalData.getEmail();
    }

    public String getPhone() {
        return personalData.getPhone();
    }

    public String getCity() {
        return personalData.getAddress().getCity();
    }

    public String getStreet() {
        return personalData.getAddress().getStreet();
    }

    public String getPostalCode() {
        return personalData.getAddress().getPostalCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
