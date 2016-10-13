package pl.com.sebastianbodzak.library.api;

import pl.com.sebastianbodzak.library.domain.EmailMessage;

/**
 * Created by Dell on 2016-10-13.
 */
public interface EmailFacade {

    void sendEmail(EmailMessage content, String email);
}
