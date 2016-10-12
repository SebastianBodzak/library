package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.EmployeeRepository;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by Dell on 2016-10-11.
 */
@Service
public class SessionManager {

    private EmployeeRepository employeeRepository;

    public SessionManager(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public SignupResultDto employeeSignup(String login, String password, Long employeeId) {
        checkArgument(!(login == null || password == null || employeeId == null));
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee == null)
            return setupNewAccount(login, password, employeeId);
        else
            return failure("Employee has already registered");
    }

    private SignupResultDto failure(String failureMessage) {
        return new SignupResultDto(failureMessage);
    }

    private SignupResultDto setupNewAccount(String login, String password, Long employeeId) {
        if (employeeRepository.isLoginOccupied(login))
            return failure("Login is occupied");
        else
//            employeeRepository.save(new Employee(login, password, employeeId));

        return null;
    }
}
