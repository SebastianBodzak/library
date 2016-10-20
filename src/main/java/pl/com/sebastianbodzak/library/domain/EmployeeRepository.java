package pl.com.sebastianbodzak.library.domain;

/**
 * Created by Dell on 2016-10-11.
 */
public interface EmployeeRepository {

    void save(Employee employee);
    boolean isLoginOccupied(String login);

    Employee findByEmployeeId(Long employeeId);

    Employee findByLoginAndPassword(String login, String hashedPassword);
}
