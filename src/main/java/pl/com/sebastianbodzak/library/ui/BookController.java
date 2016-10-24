package pl.com.sebastianbodzak.library.ui;

import org.springframework.web.bind.annotation.*;
import pl.com.sebastianbodzak.library.api.BookEditor;
import pl.com.sebastianbodzak.library.api.requests.AddBookRequest;

/**
 * Created by Dell on 2016-10-24.
 */
@RestController
@RequestMapping("/book")
public class BookController {

    private BookEditor bookEditor;

    public BookController(BookEditor bookEditor) {
        this.bookEditor = bookEditor;
    }

    @PutMapping("/add/{employeeId}")
    public void addBook(@PathVariable Long employeeId, @RequestBody AddBookRequest request) {
        request.setEmployeeId(employeeId);
        bookEditor.addBook(request);
    }
}
