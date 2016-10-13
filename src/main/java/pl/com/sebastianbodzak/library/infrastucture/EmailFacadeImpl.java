package pl.com.sebastianbodzak.library.infrastucture;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import pl.com.sebastianbodzak.library.api.EmailFacade;
import pl.com.sebastianbodzak.library.domain.EmailMessage;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Dell on 2016-10-13.
 */
@Component
public class EmailFacadeImpl implements EmailFacade{

    private JavaMailSender sender;

    public EmailFacadeImpl(JavaMailSender sender) {
        this.sender = sender;
    }

    @Override
    public void sendEmail(EmailMessage content, String email) {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = null;
        try{
            helper = new MimeMessageHelper(message, true);
            helper.setTo(email);
            helper.setSubject(content.getTitle());
            helper.setText(content.getContent());
            sender.send(message);
        }
        catch (MessagingException ex) {
            ex.printStackTrace();
        }
    }
}
