package pl.com.sebastianbodzak.library.infrastucture;

import org.springframework.stereotype.Repository;
import pl.com.sebastianbodzak.library.domain.Employee;
import pl.com.sebastianbodzak.library.domain.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dell on 2016-10-11.
 */
@Repository
public class JPAEmployeeRepository implements EmployeeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public boolean isLoginOccupied(String login) {
        return false;
    }

    @Override
    public Employee findByEmployeeId(Long employeeId) {
        return entityManager.find(Employee.class, employeeId);
    }
}
