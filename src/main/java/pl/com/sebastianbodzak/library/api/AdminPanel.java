package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.api.requests.ChangeEmailMessageRequest;
import pl.com.sebastianbodzak.library.api.requests.CreateEmployeeRequest;
import pl.com.sebastianbodzak.library.api.responses.CreateEmployeeResponse;
import pl.com.sebastianbodzak.library.api.responses.ListOfMessagesResponse;
import pl.com.sebastianbodzak.library.domain.*;

import static pl.com.sebastianbodzak.library.domain.JobTitle.ADMIN;
import static pl.com.sebastianbodzak.library.domain.JobTitle.MANAGER;

/**
 * Created by Dell on 2016-10-11.
 */
@Service
public class AdminPanel {

    private EmployeeRepository employeeRepository;
    private EmployeeFactory employeeFactory;
    private MessagesCatalog messagesCatalog;

    public AdminPanel(EmployeeRepository employeeRepository, EmployeeFactory employeeFactory, MessagesCatalog messagesCatalog) {
        this.employeeRepository = employeeRepository;
        this.employeeFactory = employeeFactory;
        this.messagesCatalog = messagesCatalog;
    }

    @Transactional
    @RequiresAuth(roles = {ADMIN, MANAGER})
    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        request.validate();
        Employee registeredBy = employeeRepository.findByEmployeeId(request.getId());
        if (registeredBy == null)
            throw new InvalidRequestException("Wrong id");
        Employee employee = employeeFactory.createEmployee(request, registeredBy);
        employeeRepository.save(employee);
        return new CreateEmployeeResponse(employee.getId());
    }

    @Transactional
    public void changeEmailMessage(ChangeEmailMessageRequest request) {

    }

    @Transactional
    @RequiresAuth(roles = {ADMIN, MANAGER})
    public ListOfMessagesResponse showListOfMessage(Long adminId) {
        return messagesCatalog.listAll();
    }
}
