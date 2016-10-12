package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Component;
import pl.com.sebastianbodzak.library.domain.Address;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.PersonalData;
import pl.com.sebastianbodzak.library.domain.JobTitle;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by Dell on 2016-10-12.
 */
@Component
public class EmployeeFactory {

    public Employee createEmployee(CreateEmployeeRequest employeeRequest, Employee registeredBy) {
        checkArgument(!(employeeRequest == null || registeredBy == null));

        Address address = new Address(employeeRequest.getCity(), employeeRequest.getStreet(), employeeRequest.getPostalCode());
        PersonalData personalData = new PersonalData(employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getEmail(),
                employeeRequest.getPhone(), address);
        return new Employee(personalData, JobTitle.valueOf(employeeRequest.getJobTitle().toUpperCase()), registeredBy);
    }
}
