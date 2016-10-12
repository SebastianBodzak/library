package pl.com.sebastianbodzak.library.api;

/**
 * Created by Dell on 2016-10-12.
 */
public class SignupRequest {

    private String login;
    private String password;
    private Long employeeId;

    public void validate() {
        if (login == null || login.trim().isEmpty())
            throw new InvalidRequestException("Login can not be empty");
        if (password == null || password.trim().isEmpty())
            throw new InvalidRequestException("Password can not be empty");
        if (employeeId == null)
            throw new InvalidRequestException("Employee id is required");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}
