package com.example.application.network;

import com.example.application.models.Movie;
import com.example.application.models.Friend;
import com.example.application.responses.AuthResponse;
import com.example.application.responses.MovieResponse;
import com.example.application.responses.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @GET("users")
    Call<List<Friend>> getFriends();
    @GET("posts")
    Call<List<Movie>> getMovies();

}
