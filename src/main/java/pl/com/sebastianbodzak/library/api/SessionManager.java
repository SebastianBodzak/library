package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.api.dtos.SignupResultDto;
import pl.com.sebastianbodzak.library.api.requests.SignupRequest;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.EmployeeRepository;

import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by Dell on 2016-10-11.
 */
@Service
public class SessionManager {

    private EmployeeRepository employeeRepository;
    private PasswordHasher passwordHasher;
    private EmailSender emailSender;

    public SessionManager(EmployeeRepository employeeRepository, PasswordHasher passwordHasher, EmailSender emailSender) {
        this.employeeRepository = employeeRepository;
        this.passwordHasher = passwordHasher;
        this.emailSender = emailSender;
    }

    @Transactional
    public SignupResultDto signupByEmployee(SignupRequest request) {
        checkNotNull(request);

        request.validate();
        Employee employee = employeeRepository.findByEmployeeId(request.getEmployeeId());
        String hashedPassword = passwordHasher.hashPassword(request.getPassword());
        if (employee == null)
            throw new InvalidRequestException("Employee identified by this id does not exist");
        else
            return setupNewAccount(request.getLogin(), hashedPassword, employee);
    }

    private SignupResultDto setupNewAccount(String login, String password, Employee employee) {
        if (employeeRepository.isLoginOccupied(login))
            return failure("Login is occupied");
        else if (employee.isRegistered())
            return failure("Employee identified by this id has already registered");
        else {
            employee.register(login, password);
            emailSender.sendEmail(employee.getData().getEmail(), "CONFIRM_EMPLOYEE_REGISTRATION");
            return success();
        }
    }

    private SignupResultDto failure(String failureMessage) {
        return new SignupResultDto(failureMessage);
    }

    private SignupResultDto success() {
        return new SignupResultDto();
    }
}
