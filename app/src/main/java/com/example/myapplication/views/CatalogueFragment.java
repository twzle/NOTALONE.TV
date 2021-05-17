package com.example.myapplication.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapters.CatalogueMovieAdapter;
import com.example.myapplication.models.Movie;
import com.example.myapplication.network.Api;
import com.example.myapplication.network.ApiService;
import com.example.myapplication.responses.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogueFragment extends Fragment {

    RecyclerView mRecyclerView;
    CatalogueMovieAdapter mMovieAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalogue, container, false);
        LoadNewestMovies(view);
        LoadPopularMovies(view);
        return view;
    }

    private void LoadNewestMovies(View view){
        ApiService apiService = new ApiService();
        Api api = apiService.getNotAloneApiService().create(Api.class);
        Call<MovieResponse> call = api.getCatalogNewest("odsu6JggH90Z1D69AVCw", 1);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse m_response=response.body();
                List<Movie> movies = m_response.getData();

                for (Movie movie : movies) {
                    movie.setMovieImg(R.drawable.ic_profile);
                }
                DisplayNewestMovies(movies, view);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        return;
    }

    private void LoadPopularMovies(View view){
        ApiService apiService = new ApiService();
        Api api = apiService.getNotAloneApiService().create(Api.class);
        Call<MovieResponse> call = api.getCatalogPopular("odsu6JggH90Z1D69AVCw", 1);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse m_response=response.body();
                List<Movie> movies = m_response.getData();

                for (Movie movie : movies) {
                    movie.setMovieImg(R.drawable.ic_profile);
                }
                DisplayPopularMovies(movies, view);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        return;
    }

    private void DisplayNewestMovies(List<Movie> movies, View view){
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        movieList.addAll(movies);

        mRecyclerView= view.findViewById(R.id.recyclerview_newest_movies);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mMovieAdapter = new CatalogueMovieAdapter(this.getContext(), movieList);
        mRecyclerView.setAdapter(mMovieAdapter);
    }

    private void DisplayPopularMovies(List<Movie> movies, View view){
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        movieList.addAll(movies);

        mRecyclerView= view.findViewById(R.id.recyclerview_popular_movies);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        mMovieAdapter = new CatalogueMovieAdapter(this.getContext(), movieList);
        mRecyclerView.setAdapter(mMovieAdapter);
    }
}
