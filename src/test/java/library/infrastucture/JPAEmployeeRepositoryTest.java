package library.infrastucture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.domain.EmployeeRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Dell on 2016-10-12.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/application.xml")
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@WebAppConfiguration
@Sql("/fixtures/employees.sql")
public class JpaEmployeeRepositoryTest {

    private String occupiedLogin = "login";
    private String freeLogin = "freeLogin";


    @Autowired
    private EmployeeRepository employeeRepository;

    @Sql("/fixtures/employees.sql")
    @Test
    @Transactional
    public void shouldConfirmThatLoginIsOccupied() {
        boolean result = employeeRepository.isLoginOccupied(occupiedLogin);

        assertTrue(result);
    }

    @Sql("/fixtures/employees.sql")
    @Test
    @Transactional
    public void shouldConfirmedThatLoginIsAvaliable() {
        boolean result = employeeRepository.isLoginOccupied(freeLogin);

        assertFalse(result);
    }

}
