package library.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.com.sebastianbodzak.library.api.EmailSender;
import pl.com.sebastianbodzak.library.api.PasswordHasher;
import pl.com.sebastianbodzak.library.api.SessionManager;
import pl.com.sebastianbodzak.library.api.requests.SignupRequest;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.EmployeeRepository;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

/**
 * Created by Dell on 2016-10-12.
 */
@RunWith(MockitoJUnitRunner.class)
public class SessionManagerTest {

    private SessionManager sessionManager;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private PasswordHasher passwordHasher;

    @Mock
    private SignupRequest request;

    private Long anyId = 1L;

    private String password = "password";

    private String hashedPassword = "hashedPassword";

    @Mock
    private EmailSender emailSender;

    @Mock
    private Employee employee;

    @Before
    public void setUp() {
        sessionManager = new SessionManager(employeeRepository, passwordHasher, emailSender);
    }

    @Test
    public void shouldSignupEmployee() {
        doNothing().when(request).validate();
        when(employeeRepository.findByEmployeeId(anyId)).thenReturn(employee);
        when(passwordHasher.hashPassword(password)).thenReturn(hashedPassword);

//        sessionManager.signupByEmployee(request);
    }
}
