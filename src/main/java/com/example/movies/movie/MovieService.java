package com.example.movies.movie;


import com.example.movies.genre.Genres;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void addNewMovie(Movie movie) throws IllegalAccessException {
        Optional<Movie> movieByTitle = movieRepository.findMoviesByTitle(movie.getTitle());
        if(movieByTitle.isPresent()) {
            throw new IllegalAccessException("A film with this title already exist in the database!");
        }
        movieRepository.save(movie);
    }
    @GetMapping
    public List<Movie> getMovieByGenre(Genres genre){
        return  movieRepository.findMoviesByGenreContains(genre);

    }

    @GetMapping
    public List<Movie> getMovieByTitle(String title){
//        return movieRepository.findMoviesByTitleContaining(title);
        return movieRepository.findByTitleIgnoreCaseContaining(title);
    }
    @GetMapping
    public List<Movie> getMoviesByYear(Integer year){
        return  movieRepository.findMoviesByYear(year);
    }
    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
}
