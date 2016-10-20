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
@NamedQueries({
        @NamedQuery(name = "Employee.isLoginOccupied", query = "SELECT count(e) FROM Employee e WHERE login =:login"),
        @NamedQuery(name = "Employee.findByLoginAndPassword", query = "FROM Employee WHERE login =:login AND hashedPassword =:hP")
})
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonalData data;

    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;

    @NaturalId(mutable = true)
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

    public void register(String login, String hashedPassword) {
        checkState(!isRegistered());

        this.login = login;
        this.hashedPassword = hashedPassword;
    }

    public Long getId() {
        return id;
    }

    public boolean checkIfhas(JobTitle ...jobTitle) {
        for (JobTitle title : jobTitle)
            if (this.jobTitle.equals(title))
                return true;
        return false;
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

    public PersonalData getData() {
        return data;
    }

    public Employee getRegisterBy() {
        return registerBy;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }
}
