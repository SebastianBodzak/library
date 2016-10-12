package pl.com.sebastianbodzak.library.domain;

import org.hibernate.annotations.NaturalId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.google.common.base.Preconditions.checkState;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

/**
 * Created by Dell on 2016-10-11.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonalData data;

    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @NaturalId
    private String login;

    private String hashedPassword;

    @OneToOne
    private Employee registerBy;

    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime registeredAt;

    private Employee() {}

    public Employee(PersonalData data, JobTitle jobTitle, Employee registerBy) {
        this.data = data;
        this.jobTitle = jobTitle;
        this.registerBy = registerBy;
        this.registeredAt = LocalDateTime.now();
    }

    public void registerEmployee(String login, String hashedPassword) {
        this.login = login;
        this.hashedPassword = hashedPassword;
    }

    public Long getId() {
        return id;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public String getLogin() {
        return login;
    }

    public boolean isRegistered() {
        return login != null;
    }

    public void setupAccount(String login, String password) {
        checkState(!isRegistered());
        this.login = login;
        this.hashedPassword = password;
    }
}