package pl.com.sebastianbodzak.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Dell on 2016-10-13.
 */
@Entity
public class EmailMessage {

    @Id
    @Column(unique = true)
    private String typeOfMessage;
    private String title;
    private String content;

    private EmailMessage() {}

    public EmailMessage(String typeOfMessage, String title, String content) {
        this.typeOfMessage = typeOfMessage;
        this.title = title;
        this.content = content;
    }

    public void changeMessage(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTypeOfMessage() {
        return typeOfMessage;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
