package pl.com.sebastianbodzak.library.domain;

import org.hibernate.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.Set;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

/**
 * Created by Dell on 2016-10-11.
 */
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Book> books;

    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime orderedAt;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime realizedAt;

    private Order() {}

    public Order(User user, Set<Book> books, LocalDateTime orderedAt, OrderStatus orderStatus, LocalDateTime realizedAt) {
        this.user = user;
        this.books = books;
        this.orderedAt = orderedAt;
        this.orderStatus = orderStatus;
        this.realizedAt = realizedAt;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public LocalDateTime getOrderedAt() {
        return orderedAt;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public LocalDateTime getRealizedAt() {
        return realizedAt;
    }
}
