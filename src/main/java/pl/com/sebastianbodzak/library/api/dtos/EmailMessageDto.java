package pl.com.sebastianbodzak.library.api.dtos;

/**
 * Created by Dell on 2016-10-20.
 */
public class EmailMessageDto {

    private String typeOfMessage;
    private String title;
    private String content;

    public EmailMessageDto(String typeOfMessage, String title, String content) {
        this.typeOfMessage = typeOfMessage;
        this.title = title;
        this.content = content;
    }

    public String getTypeOfMessage() {
        return typeOfMessage;
    }

    public void setTypeOfMessage(String typeOfMessage) {
        this.typeOfMessage = typeOfMessage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
