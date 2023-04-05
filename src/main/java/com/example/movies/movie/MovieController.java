package com.example.movies.movie;

import com.example.movies.authorization.LogInHelper;
import com.example.movies.genre.Genres;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }



    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("greeting", "Welcome to our site!");
        return "home";
    }


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
//    @GetMapping("/movies/title/{title}")
//    public String getMoviesByTitle(Model model,@PathVariable  String title){
//        List<Movie> movies = movieService.getMovieByTitle(title);
//        model.addAttribute("movies", movies);
//        return "movie";
//    }


    @GetMapping("/movies/search")
    public String getMovieByCategory(Model model,
                                     @RequestParam("selectedCategory") String selectedCategory,
                                     @RequestParam(name = "searchValue", required = false) String searchValue) {
        List<Movie> movies = null;
        if (searchValue == null || searchValue.isBlank()) {
            movies = movieService.getAllMovies();
        } else {
            String genreName = searchValue.substring(0, 1).toUpperCase() + searchValue.substring(1).replace(" ", "");
            if (selectedCategory.equals("title")) {
                movies = movieService.getMovieByTitle(searchValue);
            } else if (selectedCategory.equals("genre")) {
                movies = movieService.getMovieByGenre(Genres.valueOf(genreName));
            } else if (selectedCategory.equals("year")) {
                movies = movieService.getMoviesByYear(Integer.parseInt(searchValue));
            } else {
                movies = movieService.getAllMovies();
            }
        }
        model.addAttribute("movies", movies);
        return "movie";
    }

    @GetMapping("/movies/{genre}")
    public String getMovieByGenre(@PathVariable String genre, Model model) {
        String genreName = genre.substring(0, 1).toUpperCase() + genre.substring(1).replace(" ", "");
        List<Movie> movies = movieService.getMovieByGenre(Genres.valueOf(genreName));
        model.addAttribute("movies", movies);
        return "movie";
    }

    @GetMapping("/admin/edit")
    public String editMovie(Model model) {
        List<Movie> movie = movieService.getMovieByTitle("The Girls");
        model.addAttribute("movie", movie.get(0));
        return "edit";
    }

    @PostMapping("/admin/edit")
    public String updateMovie(@ModelAttribute("movie") Movie updatedMovie) throws IllegalAccessException {
        movieService.editMovie(updatedMovie);
        return "redirect:/";
    }

}
