package pl.com.sebastianbodzak.library.infrastucture;

import org.springframework.stereotype.Repository;
import pl.com.sebastianbodzak.library.domain.Worker;
import pl.com.sebastianbodzak.library.domain.WorkerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dell on 2016-10-11.
 */
@Repository
public class JPAWorkerRepository implements WorkerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Worker worker) {
        entityManager.persist(worker);
    }

    @Override
    public boolean isLoginOccupied(String login) {
        return false;
    }
}
