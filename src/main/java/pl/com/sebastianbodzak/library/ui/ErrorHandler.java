package pl.com.sebastianbodzak.library.ui;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.sebastianbodzak.library.api.AuthRequiredException;
import pl.com.sebastianbodzak.library.api.InvalidRequestException;

/**
 * Created by Dell on 2016-10-12.
 */
@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<String> handleInvalidRequestException(InvalidRequestException exception) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<String>(
                "{'error': '" + exception.getMessage() + "' }",
                headers,
                HttpStatus.UNPROCESSABLE_ENTITY
        );
    }

    @ExceptionHandler(AuthRequiredException.class)
    public ResponseEntity<String> handlerAuthRequiredException() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, "application/json");
        return new ResponseEntity<String>(
                "{'error': 'authentication required'}",
                headers,
                HttpStatus.UNAUTHORIZED);
    }
}
