package pl.com.sebastianbodzak.library.domain;

import org.hibernate.annotations.NaturalId;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Dell on 2016-10-11.
 */
@Entity
public class Worker {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private PersonalData data;
    private String proffesion;
    @NaturalId
    private String login;
    private String hashedPassword;

    private Worker() {}

    public Worker(PersonalData data, String proffesion, String login, String hashedPassword) {
        this.data = data;
        this.proffesion = proffesion;
        this.login = login;
        this.hashedPassword = hashedPassword;
    }

    public Long getId() {
        return id;
    }


}
