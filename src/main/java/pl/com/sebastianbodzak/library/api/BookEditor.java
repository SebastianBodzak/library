package pl.com.sebastianbodzak.library.api;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.com.sebastianbodzak.library.api.requests.AddBookRequest;
import pl.com.sebastianbodzak.library.domain.*;

import static pl.com.sebastianbodzak.library.domain.JobTitle.LIBRARIAN;

/**
 * Created by Dell on 2016-10-24.
 */
@Service
public class BookEditor {

    private BookRepository bookRepository;
    private BookFactory bookFactory;
    private EmployeeRepository employeeRepository;

    public BookEditor(BookRepository bookRepository, BookFactory bookFactory, EmployeeRepository employeeRepository) {
        this.bookRepository = bookRepository;
        this.bookFactory = bookFactory;
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @RequiresAuth(roles = LIBRARIAN)
    public void addBook(AddBookRequest request) {
        request.verify();
        Employee employee = employeeRepository.findByEmployeeId(request.getEmployeeId());
        Book book = bookFactory.create(request, employee);
        bookRepository.save(book);
    }
}
