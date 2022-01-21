package com.example.application.repositories;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.application.network.ApiService;
import com.example.application.network.NotAloneApi;
import com.example.application.responses.AuthResponse;
import com.example.application.responses.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {
    private final NotAloneApi api;

    public AuthRepository(){
        ApiService apiService = new ApiService();
        api = apiService.getNotAloneApiService().create(NotAloneApi.class);
    }

    public LiveData<AuthResponse> getAuth(String login, String password, String vk_id, String fb_id, String g_id){
        MutableLiveData<AuthResponse> data = new MutableLiveData<>();

        Call<AuthResponse> call = api.auth("odsu6JggH90Z1D69AVCw", login, password, vk_id, fb_id, g_id);
        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(@NonNull Call<AuthResponse> call, @NonNull Response<AuthResponse> response) {
                data.setValue(response.body());
                Log.v("Auth Success", response.message());
            }

            @Override
            public void onFailure(@NonNull Call<AuthResponse> call,@NonNull Throwable t) {
                data.setValue(null);
                Log.v("Auth Error", t.getMessage());
            }
        });
        return data;
    }

}
