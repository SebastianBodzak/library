package pl.com.sebastianbodzak.library.domain;

import javax.persistence.*;
import java.util.Set;

import static pl.com.sebastianbodzak.library.domain.BookStatus.AVAILABLE;

/**
 * Created by Dell on 2016-10-11.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;
    private String signature;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
    @ElementCollection
    private Set<String> keyWords;
    private int bookAmount;

    private Book() {}

    public Book(String title, String author, String signature, BookStatus status, Set<String> keyWords, int bookAmount) {
        this.title = title;
        this.author = author;
        this.signature = signature;
        this.status = status;
        this.keyWords = keyWords;
        this.bookAmount = bookAmount;
    }

    public void addBook(Book book) {
        book.status = AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSignature() {
        return signature;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Set<String> getKeyWords() {
        return keyWords;
    }

    public int getBookAmount() {
        return bookAmount;
    }
}
