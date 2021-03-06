package pl.com.sebastianbodzak.library.api;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.api.dtos.SignupResultDto;
import pl.com.sebastianbodzak.library.api.requests.LoginRequest;
import pl.com.sebastianbodzak.library.api.requests.SignupRequest;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.EmployeeRepository;
import pl.com.sebastianbodzak.library.domain.JobTitle;

import static com.google.gson.internal.$Gson$Preconditions.checkArgument;
import static com.google.gson.internal.$Gson$Preconditions.checkNotNull;

/**
 * Created by Dell on 2016-10-11.
 */
@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionManager {

    private EmployeeRepository employeeRepository;
    private PasswordHasher passwordHasher;
    private EmailSender emailSender;
    private Employee currentEmployee;

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

    @Transactional
    public SignupResultDto login(LoginRequest request) {
        checkNotNull(request);
//        request.validate();
        String hashedPassword = passwordHasher.hashPassword(request.getPassword());
        this.currentEmployee = employeeRepository.findByLoginAndPassword(request.getLogin(), hashedPassword);
        if (this.currentEmployee == null)
            return failure("login or password incorrect");
        else
            return success();
    }

    public boolean isAuthenticated(JobTitle ...jobTitle) {
        return currentEmployee != null && currentEmployee.checkIfhas(jobTitle);
    }

    public Employee getCurrentEmployee() {
        return this.currentEmployee;
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
