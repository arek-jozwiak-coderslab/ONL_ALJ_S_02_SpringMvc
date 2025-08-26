package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.Book;
import pl.coderslab.Category;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    List<Book> findByRating(int rating);
//    List<Book> findBooksByRating(int rating);

    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);
    List<Book> findByCategoryId(Long categoryId);

    @Query("select b from Book b where b.title=?1")
    List<Book> findByTitleQuery(String title);

    @Query("select b from Book b where b.category=?1")
    List<Book> findByCategoryQuery(Category category);

}
