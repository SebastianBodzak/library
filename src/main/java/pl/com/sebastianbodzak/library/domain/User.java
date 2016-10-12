package pl.com.sebastianbodzak.library.domain;

import javax.persistence.*;

/**
 * Created by Dell on 2016-10-11.
 */
@Entity
public class User {

    @EmbeddedId
    private Account accountNumber;

    @OneToOne
    private PersonalData data;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;

    private User() {}

    public User(Account accountNumber, PersonalData data, UserStatus userStatus) {
        this.accountNumber = accountNumber;
        this.data = data;
        this.userStatus = userStatus;
    }

    public PersonalData getData() {
        return data;
    }

    public UserStatus getUserStatus() {
        return userStatus;
    }

    public Account getAccountNumber() {
        return accountNumber;
    }
}
