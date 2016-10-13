package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.domain.EmailMessage;
import pl.com.sebastianbodzak.library.domain.EmailMessageRepository;

/**
 * Created by Dell on 2016-10-13.
 */
@Service
public class EmailSender {

    private EmailFacade emailFacade;
    private EmailMessageRepository emailMessageRepository;

    public EmailSender(EmailFacade emailFacade, EmailMessageRepository emailMessageRepository) {
        this.emailFacade = emailFacade;
        this.emailMessageRepository = emailMessageRepository;
    }

    @Transactional
    public void sendEmail(String email, String typeOfMessage) {
        EmailMessage message = emailMessageRepository.loadMessageById(typeOfMessage);
        emailFacade.sendEmail(message, email);
    }

}
