package pl.com.sebastianbodzak.library.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Dell on 2016-10-11.
 */
//@Embeddable
public class Account {

//    @Id
//    @GeneratedValue
    private String number;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime closedAt;
    private Worker createdBy;
    private Worker closedBy;

    private Account() {}

    public Account(String number) {
        this.number = createNumber();
    }

    private String createNumber() {
        return UUID.randomUUID().toString();
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public Worker getCreatedBy() {
        return createdBy;
    }

    public Worker getClosedBy() {
        return closedBy;
    }
}
