package com.springservices.tmdb.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String director;

    @ElementCollection
    private List<String> actors = new ArrayList<>();


}
