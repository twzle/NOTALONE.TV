package com.example.myapplication.network;

import com.example.myapplication.models.Movie;
import com.example.myapplication.models.Friend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("users")
    Call<List<Friend>> getFriends();
    @GET("posts")
    Call<List<Movie>> getMovies();
}
