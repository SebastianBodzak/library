package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.api.requests.SignupRequest;
import pl.com.sebastianbodzak.library.domain.EmailMessage;
import pl.com.sebastianbodzak.library.domain.EmailMessageRepository;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.EmployeeRepository;

import static pl.com.sebastianbodzak.library.domain.JobTitle.ADMIN;

/**
 * Created by Dell on 2016-10-24.
 */
@Service
public class StarterConfigurator {

    private EmployeeRepository employeeRepository;
    private EmailMessageRepository emailMessageRepository;
    private PasswordHasher passwordHasher;

    public StarterConfigurator(EmployeeRepository employeeRepository, EmailMessageRepository emailMessageRepository, PasswordHasher passwordHasher) {
        this.employeeRepository = employeeRepository;
        this.emailMessageRepository = emailMessageRepository;
        this.passwordHasher = passwordHasher;
    }

    @Transactional
    public void createAdmin() {
        Employee employee = new Employee(null, ADMIN, null);
        employee.register("admin", passwordHasher.hashPassword("qwerty"));
        employeeRepository.save(employee);
    }

    @Transactional
    public void createBasicEmailMessages() {
        EmailMessage message = new EmailMessage("CONFIRM_EMPLOYEE_REGISTRATION", "Register confirmation", "You are register correctly!");
        emailMessageRepository.save(message);
    }
}
