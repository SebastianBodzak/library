package pl.com.sebastianbodzak.library.infrastucture;

import org.springframework.stereotype.Component;
import pl.com.sebastianbodzak.library.api.AuthRequiredException;
import pl.com.sebastianbodzak.library.api.RequiresAuth;
import pl.com.sebastianbodzak.library.api.SessionManager;

/**
 * Created by Dell on 2016-10-20.
 */
@Component
public class AuthAspect {

    private SessionManager sessionManager;

    public AuthAspect(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void checkAuth(RequiresAuth requiresAuth) {
        if (!sessionManager.isAuthenticated(requiresAuth.roles()))
            throw new AuthRequiredException();
    }
}
