package pl.com.sebastianbodzak.library.api.responses;

import pl.com.sebastianbodzak.library.api.dtos.EmailMessageDto;

import java.util.List;

/**
 * Created by Dell on 2016-10-20.
 */
public class ListOfMessagesResponse {

    private List<EmailMessageDto> messages;

    public ListOfMessagesResponse(List<EmailMessageDto> messages) {
        this.messages = messages;
    }

    public List<EmailMessageDto> getMessages() {
        return messages;
    }

    public void setMessages(List<EmailMessageDto> messages) {
        this.messages = messages;
    }
}
