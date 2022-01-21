package com.example.application.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.application.network.ApiService;
import com.example.application.network.NotAloneApi;
import com.example.application.responses.MovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {

    private final NotAloneApi api;

    public MovieRepository(){
        ApiService apiService = new ApiService();
        api = apiService.getNotAloneApiService().create(NotAloneApi.class);
    }

    public LiveData<MovieResponse> getNewestMovies(){
        MutableLiveData<MovieResponse> data = new MutableLiveData<>();

        Call<MovieResponse> call = api.getCatalogNewest("odsu6JggH90Z1D69AVCw", 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(@NonNull Call<MovieResponse> call,@NonNull Response<MovieResponse> response) {
                    data.setValue(response.body());
                    Log.v("Newest Movies Loading Success", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call,@NonNull Throwable t) {
                    data.setValue(null);
                    Log.v("Newest Movies Loading Error", t.getMessage());
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
                Log.v("Popular Movies Loading Success", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<MovieResponse> call,@NonNull Throwable t) {
                data.setValue(null);
                Log.v("Popular Movies Loading Error", t.getMessage());
            }
        });
        return data;
    }
}
