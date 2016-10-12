package pl.com.sebastianbodzak.library.api;

import com.google.common.hash.Hashing;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * Created by Dell on 2016-10-12.
 */
@Component
public class PasswordHasher {

    public String hashPassword(String password) {
        return Hashing.sha1().hashString(password, Charset.defaultCharset()).toString();
    }
}
