package pl.com.sebastianbodzak.library.api.requests;

/**
 * Created by Dell on 2016-10-20.
 */
public class LoginRequest {

    private String login;
    private String password;

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
}
