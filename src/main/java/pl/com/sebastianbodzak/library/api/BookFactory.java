package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Component;
import pl.com.sebastianbodzak.library.api.requests.AddBookRequest;
import pl.com.sebastianbodzak.library.domain.Book;
import pl.com.sebastianbodzak.library.domain.Employee;

/**
 * Created by Dell on 2016-10-24.
 */
@Component
public class BookFactory {

    public Book create(AddBookRequest request, Employee addBy) {
        return new Book(request.getTitle(), request.getAuthors(), request.getSignature(), request.getKeyWords(), addBy);
    }
}
