package com.example.application.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.application.models.Friend;
import com.example.application.network.JsonPlaceHolderApi;
import com.example.application.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendRepository {

    private final JsonPlaceHolderApi jsonPlaceHolderApi;

    public FriendRepository(){
        ApiService apiService = new ApiService();
        jsonPlaceHolderApi = apiService.getApiService().create(JsonPlaceHolderApi.class);
    }

    public LiveData<List<Friend>> getFriends(){
        MutableLiveData<List<Friend>> data = new MutableLiveData<>();

        Call<List<Friend>> call = jsonPlaceHolderApi.getFriends();
        call.enqueue(new Callback<List<Friend>>() {
            @Override
            public void onResponse(@NonNull Call<List<Friend>> call, @NonNull Response<List<Friend>> response) {
                data.setValue(response.body());
                Log.v("Error", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<List<Friend>> call,@NonNull Throwable t) {
                data.setValue(null);
                Log.v("Error", t.getMessage());
            }
        });
        return data;
    }
}
