package pl.com.sebastianbodzak.library.infrastucture;

import org.springframework.stereotype.Repository;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dell on 2016-10-11.
 */
@Repository
public class JpaEmployeeRepository implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public boolean isLoginOccupied(String login) {
        return entityManager.createNamedQuery("Employee.isLoginOccupied", Long.class).
                setParameter("login", login).
                getSingleResult() > 0;
    }

    @Override
    public Employee findByEmployeeId(Long employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }

    @Override
    public Employee findByLoginAndPassword(String login, String hashedPassword) {
        List<Employee> employees = entityManager.createNamedQuery("Employee.findByLoginAndPassword", Employee.class).
                setParameter("login", login).setParameter("hP", hashedPassword).getResultList();

        return Utils.returnSingleResult(employees);
    }
}
