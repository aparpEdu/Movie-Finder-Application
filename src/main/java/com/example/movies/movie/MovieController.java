package com.example.movies.movie;

import com.example.movies.authorization.LogInHelper;
import com.example.movies.genre.Genres;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

//    @PostMapping
//    public void addMovie(@RequestBody Movie movie) throws IllegalAccessException{
//        movieService.addNewMovie(movie);
//    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("greeting", "Welcome to our site!");
        return "home";
    }

//    @GetMapping
//    public ResponseEntity<List<Movie>> getAllMovies(){
//      return   movieService.getAllMovies();
//    }

    @GetMapping("/admin")
    public String panel(Model model){
        if(LogInHelper.getInstance().isAdmin()) {
            return "admin";
        }
        return "login";
    }
    @GetMapping("/admin/add")
    public String addMoviePage(Model model){
        if(LogInHelper.getInstance().isAdmin()) {
            return "add";
        }
        return "login";
    }
    @PostMapping ("/admin/add")
    public String addMovie(@ModelAttribute("movie") Movie movie,Model model) throws IllegalAccessException {
       movieService.addNewMovie(movie);
        return "add";
    }

    @GetMapping("/movies")
    public String getAllMovies(Model model){
        List<Movie> movies = movieService.getAllMovies();
        model.addAttribute("movies", movies);
        return "movie";
    }

//    @GetMapping("/movies/{genre}")
//    public String getMovieByGenre(@PathVariable String genre, Model model) {
//        String genreName = genre.substring(0, 1).toUpperCase() + genre.substring(1).toLowerCase();
//        List<Movie> movies = movieService.getMovieByGenre(Genres.valueOf(genreName));
//        model.addAttribute("movies", movies);
//        return "movie";
//    }
    @GetMapping("/movies/{genre}")
    public String getMovieByGenre(@PathVariable String genre, Model model) {
        String genreName = genre.substring(0, 1).toUpperCase() + genre.substring(1).replace(" ", "");
        List<Movie> movies = movieService.getMovieByGenre(Genres.valueOf(genreName));
        model.addAttribute("movies", movies);
        return "movie";
    }


}
