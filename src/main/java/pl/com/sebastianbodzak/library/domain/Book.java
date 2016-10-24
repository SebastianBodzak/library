package pl.com.sebastianbodzak.library.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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
    @ElementCollection
    private List<String> authors = new ArrayList<>();
    private String signature;
    @Enumerated(EnumType.STRING)
    private BookStatus status;
    @ElementCollection
    private Set<String> keyWords;
    @OneToOne
    private Employee addBy;

    private Book() {}

    public Book(String title, List<String> authors, String signature, Set<String> keyWords, Employee addBy) {
        this.title = title;
        this.authors = authors;
        this.signature = signature;
        this.status = AVAILABLE;
        this.keyWords = keyWords;
        this.addBy = addBy;
    }

    public void addBook(Book book) {
        book.status = AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getAuthors() {
        return authors;
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

}
