package pl.coderslab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.repository.BookRepository;


@RestController
@RequestMapping("/book")
public class BookController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final BookRepository bookRepository;

    public BookController(BookDao bookDao, PublisherDao publisherDao, BookRepository bookRepository) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
    }
    @GetMapping("/create")
    public String createBook() {

        bookRepository.findAll().forEach(System.out::println);
//        bookRepository.findById(1L).ifPresent(System.out::println);
//        bookRepository.findByRating(4).stream().forEach(System.out::println);

        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);
        Book book = new Book();
        book.setTitle("Thinking in Java");
        book.setRating(4);
        book.setPublisher(publisher);
        bookDao.saveBook(book);
        return "Id dodanej książki to: " + book.getId();
    }
    @GetMapping("/read")
    public Book readBook() {
        Book book = bookDao.findById(1);
        return book;
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

    @GetMapping("/find-by-title")
    public String findByTitle() {
        bookRepository.findByTitleQuery("Thinking in Java - 2nd Edition")
                .forEach(System.out::println);

        return "result";
    }
}
