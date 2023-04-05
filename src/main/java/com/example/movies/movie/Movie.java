package com.example.movies.movie;

import jakarta.persistence.*;
import lombok.Data;

import java.net.URL;


@Entity
@Table(name = "\"movie\"", schema = "movies")
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "title")
    private String title;


//    private Genre genre;
    @Column(name = "genre")
    private String genre ;
    @Column(name = "actors")
    private String actors;

    @Column(name = "movie_year")
    private Integer year;

    @Column(name =  "poster")
    private URL poster;

    @Column(name = "description")
    private String description;

    @Column(name = "length")
    private Integer length;

    @Column(name ="director")
    private String director;

}
