package pl.com.sebastianbodzak.library.infrastucture;

import org.springframework.stereotype.Component;
import pl.com.sebastianbodzak.library.api.ListOfMessagesResponse;
import pl.com.sebastianbodzak.library.api.EmailMessageDto;
import pl.com.sebastianbodzak.library.api.MessagesCatalog;
import pl.com.sebastianbodzak.library.domain.EmailMessage;
import pl.com.sebastianbodzak.library.domain.EmailMessage_;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Created by Dell on 2016-10-20.
 */
@Component
public class JpaMessagesCatalog implements MessagesCatalog {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ListOfMessagesResponse listAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmailMessageDto> query = builder.createQuery(EmailMessageDto.class);
        Root<EmailMessage> root = query.from(EmailMessage.class);
        query.getOrderList();
        selectMessagesDto(builder, query, root);
        Query jpaQuery = entityManager.createQuery(query);

        return new ListOfMessagesResponse(jpaQuery.getResultList());
    }

    private void selectMessagesDto(CriteriaBuilder builder, CriteriaQuery<EmailMessageDto> query, Root<EmailMessage> root) {
        query.select(builder.construct(EmailMessageDto.class,
                root.get(EmailMessage_.typeOfMessage),
                root.get(EmailMessage_.title),
                root.get(EmailMessage_.content)
        ));
    }
}
