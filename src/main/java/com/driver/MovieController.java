package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity("Movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity("Movie added successfully", HttpStatus.CREATED);
    }
    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movieName,@RequestParam String directorName){
        movieService.addMovieDirectorPair(movieName,directorName);
        return new ResponseEntity("Movie added successfully", HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie=movieService.findMovieByName(name);
        return new ResponseEntity(movie, HttpStatus.OK);
    }
    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity  getDirectorByName(@PathVariable String name){
        Director director=movieService.findDirectorByName(name);
        return new ResponseEntity(director, HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director){
        List<String> movieList=movieService.getAllMovieByDirector(director);
        return new ResponseEntity(movieList, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity  findAllMovies(){
        List<String> movieList=movieService.getAllMovie();
        return new ResponseEntity(movieList, HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String directorName){
        movieService.deleteDirectorByName(directorName);
        return new ResponseEntity("removed successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieService.deleteAllDirector();
        return new ResponseEntity("All director deleted", HttpStatus.OK);
    }





}
