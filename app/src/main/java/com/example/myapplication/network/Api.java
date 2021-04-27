package com.example.myapplication.network;

import com.example.myapplication.models.Movie;
import com.example.myapplication.models.Friend;
import com.example.myapplication.responses.MovieResponse;
import com.example.myapplication.responses.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {
    @GET("users")
    Call<List<Friend>> getFriends();
    @GET("posts")
    Call<List<Movie>> getMovies();

    @FormUrlEncoded
    @POST("getUser")
    Call<UserResponse> getUser(@Field("apiKey") String apiKey, @Field("userID") int userID);

    @FormUrlEncoded
    @POST("getCatalogNewest")
    Call<MovieResponse> getCatalogNewest(@Field("apiKey") String apiKey, @Field("page") int page);

}
