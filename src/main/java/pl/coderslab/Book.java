package pl.coderslab;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@Data
@ToString(exclude = {  "authors" })
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tytul")
    private String title;
    private int rating;
    private String description;
    @ManyToMany
    private List<Author> authors;
    @ManyToOne
    private Publisher publisher;
    @ManyToOne
    private Category category;

}
