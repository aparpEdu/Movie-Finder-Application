package com.example.movies.movie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    private final MovieService movieService;

    public SearchController(MovieService movieService) {
        this.movieService = movieService;
    }

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
}
