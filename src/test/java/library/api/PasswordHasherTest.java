package library.api;

import org.junit.Before;
import org.junit.Test;
import pl.com.sebastianbodzak.library.api.PasswordHasher;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dell on 2016-10-12.
 */
public class PasswordHasherTest {

    private String password = "password";
    private PasswordHasher passwordHasher;

    @Before
    public void setUp() {
        passwordHasher = new PasswordHasher();
    }

    @Test
    public void shouldHashPassword() {
        String hashedPassword = passwordHasher.hashPassword(password);

        assertNotEquals(password, hashedPassword);
        assertNotNull(hashedPassword);
        assertTrue(hashedPassword.length() > 10);
    }
}
