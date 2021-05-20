package com.example.myapplication.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.R;
import com.example.myapplication.models.Movie;
import com.example.myapplication.network.Api;
import com.example.myapplication.network.ApiService;
import com.example.myapplication.responses.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private final Api api;

    public MovieRepository(){
        ApiService apiService = new ApiService();
        api = apiService.getNotAloneApiService().create(Api.class);
    }

    public LiveData<MovieResponse> getNewestMovies(){
        MutableLiveData<MovieResponse> data = new MutableLiveData<>();

        Call<MovieResponse> call = api.getCatalogNewest("odsu6JggH90Z1D69AVCw", 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call,@NonNull Response<MovieResponse> response) {
                    data.setValue(response.body());
                    Log.v("Error", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call,@NonNull Throwable t) {
                    data.setValue(null);
                    Log.v("Error", t.getMessage());
            }
        });
        return data;
    }

    public LiveData<MovieResponse> getPopularMovies(){
        MutableLiveData<MovieResponse> data = new MutableLiveData<>();

        Call<MovieResponse> call = api.getCatalogPopular("odsu6JggH90Z1D69AVCw", 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call,@NonNull Response<MovieResponse> response) {
                data.setValue(response.body());
                Log.v("Error", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call,@NonNull Throwable t) {
                data.setValue(null);
                Log.v("Error", t.getMessage());
            }
        });
        return data;
    }
}
