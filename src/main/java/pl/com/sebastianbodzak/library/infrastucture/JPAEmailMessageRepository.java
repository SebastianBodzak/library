package pl.com.sebastianbodzak.library.infrastucture;

import org.springframework.stereotype.Repository;
import pl.com.sebastianbodzak.library.domain.EmailMessage;
import pl.com.sebastianbodzak.library.domain.EmailMessageRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dell on 2016-10-13.
 */
@Repository
public class JpaEmailMessageRepository implements EmailMessageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public EmailMessage loadMessageById(String typeOfMessage) {
        return entityManager.find(EmailMessage.class, typeOfMessage);
    }
}
