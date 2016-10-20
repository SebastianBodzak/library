package pl.com.sebastianbodzak.library.ui;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.sebastianbodzak.library.api.SessionManager;
import pl.com.sebastianbodzak.library.api.dtos.SignupResultDto;
import pl.com.sebastianbodzak.library.api.requests.LoginRequest;

/**
 * Created by Dell on 2016-10-20.
 */
@RestController
@RequestMapping("/session")
public class SessionController {

    private SessionManager sessionManager;

    public SessionController(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @PutMapping
    public SignupResultDto login(@RequestBody LoginRequest request) {
        return sessionManager.login(request);
    }
}
