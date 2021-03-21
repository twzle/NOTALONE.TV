package com.example.myapplication.Network;

import com.example.myapplication.Favorites.Movie;
import com.example.myapplication.Friends.Friend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("users")
    Call<List<Friend>> getFriends();
    @GET("posts")
    Call<List<Movie>> getMovies();
}
