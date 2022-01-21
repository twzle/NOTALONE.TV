package com.example.application.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.application.network.ApiService;
import com.example.application.network.NotAloneApi;
import com.example.application.responses.MovieResponse;
import com.example.application.responses.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private final NotAloneApi api;

    public UserRepository(){
        ApiService apiService = new ApiService();
        api = apiService.getNotAloneApiService().create(NotAloneApi.class);
    }

    public LiveData<UserResponse> getUser(int userID){
        MutableLiveData<UserResponse> data = new MutableLiveData<>();

        Call<UserResponse> call = api.getUser("odsu6JggH90Z1D69AVCw", userID);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                data.setValue(response.body());
                Log.v("User Loading Success", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call,@NonNull Throwable t) {
                data.setValue(null);
                Log.v("User Loading Error", t.getMessage());
            }
        });
        return data;
    }

}
