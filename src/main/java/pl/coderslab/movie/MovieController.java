package pl.coderslab.movie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@Slf4j
public class MovieController {

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/create-movie")
    public Movie createMovie() {

        return Movie.builder().
                title("Inception").
                director("Christopher Nolan").
                releaseYear(2010).
                genre("Sci-Fi").build();

    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        log.info("Creating movie: {}", movie);
        return movieRepository.save(movie);
    }
}
