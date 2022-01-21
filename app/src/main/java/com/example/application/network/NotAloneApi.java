package com.example.application.network;

import com.example.application.responses.AuthResponse;
import com.example.application.responses.MovieResponse;
import com.example.application.responses.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface NotAloneApi {
    @FormUrlEncoded
    @POST("getUser")
    Call<UserResponse> getUser(@Field("apiKey") String apiKey, @Field("userID") int userID);

    @FormUrlEncoded
    @POST("getCatalogNewest")
    Call<MovieResponse> getCatalogNewest(@Field("apiKey") String apiKey, @Field("page") int page);

    @FormUrlEncoded
    @POST("getCatalogPopular")
    Call<MovieResponse> getCatalogPopular(@Field("apiKey") String apiKey, @Field("page") int page);

    @FormUrlEncoded
    @POST("auth")
    Call<AuthResponse> auth(@Field("apiKey") String apiKey, @Field("login") String login, @Field("password") String password, @Field("vk_id") String vk_id, @Field("fb_id") String fb_id, @Field("g_id") String g_id);

}
