package pl.com.sebastianbodzak.library.api.requests;

import pl.com.sebastianbodzak.library.api.InvalidRequestException;

import java.util.List;
import java.util.Set;

import static pl.com.sebastianbodzak.library.api.Utils.validateString;

/**
 * Created by Dell on 2016-10-24.
 */
public class AddBookRequest {

    private Long employeeId;
    private String title;
    private List<String> authors;
    private String signature;
    private Set<String> keyWords;

    public void verify() {
        if (employeeId == null)
            throw new InvalidRequestException("Employee Id is required");
        if (validateString(title))
            throw new InvalidRequestException("Invalid title");
        for (String author : authors)
            if (validateString(author))
                throw new InvalidRequestException("Invalid authors");
        if (validateString(signature))
            throw new InvalidRequestException("Invalid signature");
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Set<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(Set<String> keyWords) {
        this.keyWords = keyWords;
    }
}
