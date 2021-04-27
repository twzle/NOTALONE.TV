package com.example.myapplication.responses;

import com.example.myapplication.models.Movie;
import com.example.myapplication.models.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResponse {

    @SerializedName("result")
    private boolean result;

    @SerializedName("data")
    private List<Movie> data;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public List<Movie> getData() {
        return data;
    }

    public void setData(List<Movie> data) {
        this.data = data;
    }

    public MovieResponse(boolean result, List<Movie> data) {
        this.result = result;
        this.data = data;
    }
}
