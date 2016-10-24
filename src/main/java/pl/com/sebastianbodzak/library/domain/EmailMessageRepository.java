package pl.com.sebastianbodzak.library.domain;

/**
 * Created by Dell on 2016-10-13.
 */
public interface EmailMessageRepository {

    void save(EmailMessage emailMessage);

    EmailMessage loadMessageById(String typeOfMessage);
}
