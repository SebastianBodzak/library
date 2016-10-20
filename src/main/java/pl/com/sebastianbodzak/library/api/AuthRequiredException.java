package pl.com.sebastianbodzak.library.api;

/**
 * Created by Dell on 2016-10-20.
 */
public class AuthRequiredException extends RuntimeException {

    public AuthRequiredException() {
        super("Authentication required but no user in current session");
    }
}
