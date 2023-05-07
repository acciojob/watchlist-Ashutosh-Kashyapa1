package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        if(Objects.nonNull(movieRepository.findMovie(movieName)) && Objects.nonNull(movieRepository.findDirector(directorName))){
            movieRepository.addMovieDirectorPair(movieName,directorName);
        }

    }

    public Movie findMovieByName(String movieName) {
        return movieRepository.findMovie(movieName);
    }

    public Director findDirectorByName(String name) {
        return movieRepository.findDirector(name);
    }

    public List<String> getAllMovieByDirector(String director) {
        return movieRepository.getAllMovieByDirector(director);
    }

    public List<String> getAllMovie() {
        return movieRepository.getAllMovie();
    }

    public void deleteDirectorByName(String directorName) {
        List<String> movieToDelete=movieRepository.getAllMovieByDirector(directorName);
        movieRepository.removeDirector(directorName);
        for(String key:movieToDelete){
            movieRepository.removeMovie(key);
        }
    }

    public void deleteAllDirector() {
        List<String> directorList=movieRepository.getAllDirector();
        for(String director:directorList){
            deleteDirectorByName(director);
        }
    }
}
