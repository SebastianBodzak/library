package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.domain.*;

/**
 * Created by Dell on 2016-10-11.
 */
@Service
public class AdminPanel {

    private EmployeeRepository employeeRepository;
    private EmployeeFactory employeeFactory;

    public AdminPanel(EmployeeRepository employeeRepository, EmployeeFactory employeeFactory) {
        this.employeeRepository = employeeRepository;
        this.employeeFactory = employeeFactory;
    }

    @Transactional
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        request.validate();
        Employee registeredBy = employeeRepository.findByEmployeeId(request.getId());
        if (registeredBy == null)
            throw new InvalidRequestException("Wrong id");
        Employee employee = employeeFactory.createEmployee(request, registeredBy);
        employeeRepository.save(employee);
        return new CreateEmployeeResponse(employee.getId());
    }
}
