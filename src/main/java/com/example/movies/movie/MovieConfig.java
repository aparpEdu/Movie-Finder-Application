//package com.example.movies.movie;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class MovieConfig {
//        @Bean
//        CommandLineRunner commandLineRunner(MovieRepository repository){
//        return args -> {
//            List<Movie> movies = new ArrayList<>();
//            Movie movie1 = new Movie();
//            movie1.setActors("Pavel Ivanov, Kalchev OG");
//            movie1.setDescription("Pavel is chasing Kalchev with a chainsaw and a hockey mask throughout the whole movie");
//            movie1.setLength(120);
//            movie1.setPoster(new URL("https://m.media-amazon.com/images/M/MV5BMTQ5ODI5NTMzN15BMl5BanBnXkFtZTcwNzY4MTYxMg@@._V1_.jpg"));
//            movie1.setTitle("Friday 15th");
//            movie1.setYear(2023);
//            movie1.setDirector("Paralisky");
//            movie1.setGenre("Comedy, Thriller");
//            movies.add(movie1);
//
//            // movie 2
//            Movie movie2 = new Movie();
//            movie2.setActors("Riley Keough");
//            movie2.setDescription("Following the rise of rock band Daisy Jones and The Six through the 1970s Los Angeles music scene on their quest for worldwide icon status.");
//            movie2.setLength(120);
//            movie2.setPoster(new URL("https://images3.penguinrandomhouse.com/cover/9781984845306"));
//            movie2.setTitle("Dfaisy Jones & The Six");
//            movie2.setYear(2018);
//            movie2.setDirector("Scott Neustadter");
//            movie2.setGenre("Comedy, Thriller");
//            movies.add(movie2);
//
//            // movie 3
//            Movie movie3 = new Movie();
//            movie3.setActors("Karl Urban, Antony Starr ...");
//            movie3.setDescription("A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers.");
//            movie3.setLength(100);
//            movie3.setPoster(new URL("https://www.themoviedb.org/t/p/original/mY7SeH4HFFxW1hiI6cWuwCRKptN.jpg"));
//            movie3.setTitle("The Girls");
//            movie3.setYear(2019);
//            movie3.setDirector("Eric Kripke");
//            movie3.setGenre("Comedy, Action");
//            movies.add(movie3);
//
//            repository.saveAll(movies);
//        };
//
//    }
//}
