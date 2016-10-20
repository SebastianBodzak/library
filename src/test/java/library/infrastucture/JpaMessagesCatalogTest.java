package library.infrastucture;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.api.ListOfMessagesResponse;
import pl.com.sebastianbodzak.library.api.MessagesCatalog;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Dell on 2016-10-20.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration("/application.xml")
@TestPropertySource({"/jdbc-test.properties", "/hibernate-test.properties"})
@Sql("/fixtures/messages.sql")
public class JpaMessagesCatalogTest {

    @Autowired
    private MessagesCatalog messagesCatalog;

    private static final int QUANTITY_OF_MESSAGES = 3;

    @Sql("/fixtures/messages.sql")
    @Test
    @Transactional
    public void shouldLoadAllMessages() {
        ListOfMessagesResponse result = messagesCatalog.listAll();

        assertEquals(QUANTITY_OF_MESSAGES, result.getMessages().size());
    }

}
