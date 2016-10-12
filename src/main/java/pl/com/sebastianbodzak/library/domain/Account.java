package pl.com.sebastianbodzak.library.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by Dell on 2016-10-11.
 */
@Embeddable
public class Account implements Serializable {

//    @Id
    @GeneratedValue
    private Long number;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime closedAt;
    @OneToOne
    private Employee createdBy;
    @OneToOne
    private Employee closedBy;

    private Account() {}

    private String createNumber() {
        return UUID.randomUUID().toString();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }

    public Employee getCreatedBy() {
        return createdBy;
    }

    public Employee getClosedBy() {
        return closedBy;
    }

    public Long getNumber() {
        return number;
    }
}
