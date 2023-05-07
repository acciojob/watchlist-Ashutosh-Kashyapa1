package com.driver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class MovieRepository {
    private Map<String,Movie> movieMap=new HashMap<>();
    private Map<String,Director> directorMap=new HashMap<>();
    private Map<String, List<String>> directorMovieMap=new HashMap<>();
    public void addMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void addMovieDirectorPair(String movieName, String directorName) {
        List<String> mov=new ArrayList<>();
        if(directorMovieMap.containsKey(directorName))
            mov=directorMovieMap.get(directorName);
        mov.add(movieName);
        directorMovieMap.put(directorName,mov);

    }

    public Movie findMovie(String movieName) {
        if(movieMap.containsKey(movieName))
            return movieMap.get(movieName);
        return null;
    }

    public Director findDirector(String directorName) {
        if(directorMap.containsKey(directorName))
            return directorMap.get(directorName);
        return null;
    }

    public List<String> getAllMovieByDirector(String director) {
        List<String> movie=new ArrayList<>();
        if(directorMovieMap.containsKey(director))
            movie=directorMovieMap.get(director);
        return movie;
    }

    public List<String> getAllMovie() {
        List<String> movie=new ArrayList<>();
        for(String k:movieMap.keySet())
            movie.add(k);
        return movie;
    }

    public void removeDirector(String directorName) {
        if(directorMovieMap.containsKey(directorName))
            directorMovieMap.remove(directorName);
        if(directorMap.containsKey(directorName))
            directorMap.remove(directorName);
    }

    public void removeMovie(String movieToDelete) {
        if(movieMap.containsKey(movieToDelete))
            movieMap.remove(movieToDelete);
    }

    public List<String> getAllDirector() {
        List<String> movie=new ArrayList<>();
        for(String director:directorMap.keySet())
            movie.add(director);
        return movie;
    }
}
