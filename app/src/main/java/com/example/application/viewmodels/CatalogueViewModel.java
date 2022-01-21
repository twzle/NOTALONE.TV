package com.example.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.application.repositories.MovieRepository;
import com.example.application.responses.MovieResponse;

public class CatalogueViewModel extends ViewModel  {

    private final MovieRepository movieRepository;

    public CatalogueViewModel(){
        movieRepository = new MovieRepository();
    }

    public LiveData<MovieResponse> getNewestMovies(){
        return movieRepository.getNewestMovies();
    }

    public LiveData<MovieResponse> getPopularMovies(){
        return movieRepository.getPopularMovies();
    }
}
