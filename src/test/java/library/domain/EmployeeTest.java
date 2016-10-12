package library.domain;

import org.junit.Before;
import org.junit.Test;
import pl.com.sebastianbodzak.library.domain.Address;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.PersonalData;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static pl.com.sebastianbodzak.library.domain.JobTitle.LIBRARIAN;

/**
 * Created by Dell on 2016-10-12.
 */
public class EmployeeTest {

    private Employee employee;
    private PersonalData personalData;
    private Address address;
    private String login = "login";
    private String password = "password";

    @Before
    public void setUp() {
        address = new Address("City", "Street", "00-000");
        personalData = new PersonalData("firstName", "lastName", "mail@mail.com", "123456789", address);

        employee = new Employee(personalData, LIBRARIAN, null);
    }

    @Test
    public void shouldRegisterEmployee() {
        employee.register(login, password);

        assertEquals(login, employee.getLogin());
        assertTrue(employee.isRegistered());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldNotRegisterEmployee() {
        employee.register(login, password);

        employee.register(login, password);
    }

    @Test
    public void shouldReturnFalseBecauseEmployeeIsNotRegister() {
        boolean result = employee.isRegistered();

        assertFalse(result);
    }
}
