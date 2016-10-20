package pl.com.sebastianbodzak.library.ui;

import org.springframework.web.bind.annotation.*;
import pl.com.sebastianbodzak.library.api.SessionManager;
import pl.com.sebastianbodzak.library.api.requests.SignupRequest;
import pl.com.sebastianbodzak.library.api.dtos.SignupResultDto;

/**
 * Created by Dell on 2016-10-11.
 */
@RestController
@RequestMapping("/register")
public class SignupEmployeeController {

    private SessionManager sessionManager;

    public SignupEmployeeController(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @PutMapping("/{id}")
    public SignupResultDto signupByEmployee(@PathVariable Long id, @RequestBody SignupRequest request) {
        request.setEmployeeId(id);
        return sessionManager.signupByEmployee(request);
    }
}
