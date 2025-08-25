package pl.coderslab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;

    public BookController(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    @GetMapping("/create")
    public String createBook() {
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(4);
        bookDao.saveBook(book);
        return "Id dodanej książki to: " + book.getId();
    }
    @GetMapping("/read")
    public String readBook() {
        Book book = bookDao.findById(1);
        return book.toString();
    }

    @GetMapping("/update")
    public String updateBook() {
        Book book = bookDao.findById(1);
        book.setTitle("Thinking in Java - 2nd Edition");
        book.setRating(5);
        bookDao.update(book);
        return "Zaktualizowano książkę: " + book.toString();
    }

    @GetMapping("/delete")
    public String deleteBook() {
        Book book = bookDao.findById(1);
        bookDao.delete(book);
        return "Usunięto książkę: " + book.toString();
    }
}
