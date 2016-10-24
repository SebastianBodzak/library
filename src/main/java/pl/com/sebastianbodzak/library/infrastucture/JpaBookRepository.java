package pl.com.sebastianbodzak.library.infrastucture;

import org.springframework.stereotype.Repository;
import pl.com.sebastianbodzak.library.domain.Book;
import pl.com.sebastianbodzak.library.domain.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dell on 2016-10-24.
 */
@Repository
public class JpaBookRepository implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Book book) {
        entityManager.persist(book);
    }
}
