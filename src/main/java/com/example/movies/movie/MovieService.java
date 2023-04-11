package com.example.movies.movie;


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

    public void deleteMovie(Movie movie) throws IllegalAccessException {
        movieRepository.delete(movie);
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

    @GetMapping
    public Optional<Movie> getMovieById(Long id){
        return  movieRepository.findById(id);
    }
    public void editMovie(Movie updatedMovie) {
        Optional<Movie> existingMovie = getMovieById(updatedMovie.getId());
        if (existingMovie.isPresent()) {
            Movie movieToUpdate = existingMovie.get();
            movieToUpdate.setTitle(updatedMovie.getTitle());
            movieToUpdate.setActors(updatedMovie.getActors());
            movieToUpdate.setYear(updatedMovie.getYear());
            movieToUpdate.setGenre(updatedMovie.getGenre());
            movieToUpdate.setDescription(updatedMovie.getDescription());
            movieToUpdate.setLength(updatedMovie.getLength());
            movieToUpdate.setPoster(updatedMovie.getPoster());
            movieToUpdate.setDirector(updatedMovie.getDirector());
            movieRepository.save(movieToUpdate);
        }
    }


}
