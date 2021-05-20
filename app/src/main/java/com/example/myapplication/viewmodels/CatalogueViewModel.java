package com.example.myapplication.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.repositories.MovieRepository;
import com.example.myapplication.responses.MovieResponse;

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
