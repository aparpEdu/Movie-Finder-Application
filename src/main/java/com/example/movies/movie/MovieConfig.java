//package com.example.movies.movie;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Configuration
//public class MovieConfig {
//        @Bean
//        CommandLineRunner commandLineRunner(MovieRepository repository){
//        return args -> {
//            List<Movie> movies = new ArrayList<>();
//
//        Movie movie2 = new Movie();
//        movie2.setActors("Kimberly Woods, Armen");
//        movie2.setDescription("New girl Trinity, moves across the street from creepy neighbor, Mr. Peterson. She joins Nicky & their less courageous friends on terrifying stealth missions to find out what horrific secrets are hiding in Peterson's horror house basement.");
//        movie2.setLength(90);
//        movie2.setPoster(new URL("https://m.media-amazon.com/images/M/MV5BOGFmM2JiNzYtZWE4Mi00OTY2LTliZDctNTVjYjM1YzY0ZjMzXkEyXkFqcGdeQXVyMTU0NTQxNTM4._V1_FMjpg_UX1000_.jpg"));
//        movie2.setTitle("Hello Neighbor: Welcome to Raven Brooks");
//        movie2.setYear(2020);
//        movie2.setDirector("David Shatraw");
//        movie2.setGenre("Animation, Horror, Mystery");
//        movies.add(movie2);
//
//        Movie movie3 = new Movie();
//        movie3.setActors("Leonardo DiCaprio, Tom Hanks");
//        movie3.setDescription("Barely 21 yet, Frank is a skilled forger who has passed as a doctor, lawyer and pilot. FBI agent Carl becomes obsessed with tracking down the con man, who only revels in the pursuit.");
//        movie3.setLength(141);
//        movie3.setPoster(new URL("https://m.media-amazon.com/images/M/MV5BNDQ1YmNmNDctMTZiZS00OGU3LWIyN2YtMWIwMmVhNDQ0MjY5XkEyXkFqcGdeQXVyMjQ0NzE0MQ@@._V1_.jpg"));
//        movie3.setTitle("Catch Me If You Can");
//        movie3.setYear(2002);
//        movie3.setDirector("Steven Spielberg");
//        movie3.setGenre("Comedy, Action");
//        movies.add(movie3);
//
//        Movie movie4 = new Movie();
//        movie4.setActors("Leonardo DiCaprio, Jonah Hill");
//        movie4.setDescription("Based on the true story of Jordan Belfort, from his rise to a wealthy stock-broker living the high life to his fall involving crime, corruption and the federal government.");
//        movie4.setLength(180);
//        movie4.setPoster(new URL("https://m.media-amazon.com/images/M/MV5BMjIxMjgxNTk0MF5BMl5BanBnXkFtZTgwNjIyOTg2MDE@._V1_.jpg"));
//        movie4.setTitle("The Wolf of Wall Street");
//        movie4.setYear(2013);
//        movie4.setDirector("Martin Scorese");
//        movie4.setGenre("Comedy, Crime");
//        movies.add(movie4);
//
//        Movie movie5 = new Movie();
//        movie5.setActors("Antonio Banderas, Salma Hayek");
//        movie5.setDescription("When Puss in Boots discovers that his passion for adventure has taken its toll and he has burned through eight of his nine lives, he launches an epic journey to restore them by finding the mythical Last Wish.");
//        movie5.setLength(142);
//        movie5.setPoster(new URL("https://m.media-amazon.com/images/M/MV5BNjMyMDBjMGUtNDUzZi00N2MwLTg1MjItZTk2MDE1OTZmNTYxXkEyXkFqcGdeQXVyMTQ5NjA0NDM0._V1_.jpg"));
//        movie5.setTitle("Puss in Boots: The Last Wish");
//        movie5.setYear(2022);
//        movie5.setDirector("Joel Crawford");
//        movie5.setGenre("Animation, Comedy");
//        movies.add(movie5);
//
//        Movie movie6 = new Movie();
//        movie6.setActors("Riley Keough, Sam Claflin");
//        movie6.setDescription("Following the rise of rock band Daisy Jones and The Six through the 1970s Los Angeles music scene on their quest for worldwide icon status.");
//        movie6.setLength(120);
//        movie6.setPoster(new URL("https://images3.penguinrandomhouse.com/cover/9781984845306"));
//        movie6.setTitle("Daisy Jones & The Six");
//        movie6.setYear(2018);
//        movie6.setDirector("Riley Keough");
//        movie6.setGenre("Drama, Music");
//        movies.add(movie6);
//
//        Movie movie7 = new Movie();
//        movie7.setActors("Karl Urban, Jack Quaid");
//        movie7.setDescription("A group of vigilantes set out to take down corrupt superheroes who abuse their superpowers.");
//        movie7.setLength(100);
//        movie7.setPoster(new URL("https://www.themoviedb.org/t/p/original/mY7SeH4HFFxW1hiI6cWuwCRKptN.jpg"));
//        movie7.setTitle("The Boys");
//        movie7.setYear(2019);
//        movie7.setDirector("Eric Kripke");
//        movie7.setGenre("Action, Comedy");
//        movies.add(movie7);
//
//        Movie movie8 = new Movie();
//        movie8.setActors("Zachary Levi, Asher Angel");
//        movie8.setDescription("The film continues the story of teenage Billy Batson who, upon reciting the magic word SHAZAM! is transformed into his adult Super Hero alter ego, Shazam.");
//        movie8.setLength(130);
//        movie8.setPoster(new URL("https://assets-prd.ignimgs.com/2023/01/24/shzam2-vert-main-2764x4096-dom-1674589983500.jpg"));
//        movie8.setTitle("Shazam! Fury of the Gods");
//        movie8.setYear(2023);
//        movie8.setDirector("David F. Sandberg");
//        movie8.setGenre("Action, Adventure");
//        movies.add(movie8);
//
//        Movie movie9 = new Movie();
//        movie9.setActors("Morrigan Thompson, Crystal Starnes");
//        movie9.setDescription("A group of young adults visit a boarded up campsite named Crystal Lake where they soon encounter the mysterious Jason Voorhees and his deadly intentions.");
//        movie9.setLength(120);
//        movie9.setPoster(new URL("https://m.media-amazon.com/images/M/MV5BMTQ5ODI5NTMzN15BMl5BanBnXkFtZTcwNzY4MTYxMg@@._V1_.jpg"));
//        movie9.setTitle("Friday the 13th");
//        movie9.setYear(2023);
//        movie9.setDirector("Oktober Layne");
//        movie9.setGenre("Comedy, Thriller");
//        movies.add(movie9);
//
//            repository.saveAll(movies);
//        };
//
//    }
//}
