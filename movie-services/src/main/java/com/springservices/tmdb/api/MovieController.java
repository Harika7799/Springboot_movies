package com.springservices.tmdb.api;

import com.springservices.tmdb.model.Movie;
import com.springservices.tmdb.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
@Slf4j
public class MovieController {

    @Autowired
    public MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
       Movie movie = movieService.read(id);
       log.info("Returned movie id: {}", id);
        return ResponseEntity.ok(movie);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie createMovie = movieService.create(movie);
        log.info("Created movie id: {}", createMovie.getId());
        return ResponseEntity.ok(createMovie);
    }
    @PutMapping("/{id}")
    public void updateMovie(@PathVariable Long id,@RequestBody Movie movie){
        movieService.update(id, movie);
        log.info("Updated movie id: {}", id);
    }
    @DeleteMapping("/{id}")
    public void deletemovie(@PathVariable Long id){
        movieService.delete(id);
        log.info("Deleted movie id: {}", id);
    }

}