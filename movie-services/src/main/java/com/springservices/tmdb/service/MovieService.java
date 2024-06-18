package com.springservices.tmdb.service;

import com.springservices.tmdb.model.Movie;
import com.springservices.tmdb.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // CRUD CREATE,READ,UPDATE,DELETE

    public Movie create(Movie movie) {
        if (movie == null){
            throw new RuntimeException("Invalid Movie");
        }
        return movieRepository.save(movie);
    }
    public Movie read(Long id) {

        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }
    public  void update(Long id, Movie update) {
        if(update == null || id == null ){
            throw new RuntimeException("Invalid Movie");
        }
        if(movieRepository.existsById(id)){
           Movie movie = movieRepository.getReferenceById(id);
           movie.setTitle(update.getTitle());
           movie.setDirector(update.getDirector());
           movie.setActors(update.getActors());
           movieRepository.save(movie);
        }else {
            throw new RuntimeException("Movie not found");
        }
    }
    public void delete(Long id) {
        if(movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        }else{
            throw new RuntimeException("Movie not found");
        }
    }


}
