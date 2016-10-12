package pl.com.sebastianbodzak.library.api;

/**
 * Created by Dell on 2016-10-12.
 */
public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message) {
        super(message);
    }
}
