package com.example.movies.movie;

import com.example.movies.authorization.LogInHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
//@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
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
