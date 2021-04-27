package com.example.myapplication.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.models.Movie;
import com.example.myapplication.adapters.MovieAdapter;
import com.example.myapplication.network.Api;
import com.example.myapplication.network.ApiService;
import com.example.myapplication.responses.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FavouritesFragment extends Fragment {

    RecyclerView mRecyclerView;
    MovieAdapter mMovieAdapter;
    TextView emptyList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);
        LoadDetails(view);
        return view;
    }


    private void LoadDetails(View view){
        ApiService apiService = new ApiService();
        Api api = apiService.getNotAloneApiService().create(Api.class);
        Call<MovieResponse> call = api.getCatalogNewest("odsu6JggH90Z1D69AVCw", 1);

        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                MovieResponse m_response=response.body();
                List<Movie> movies = m_response.getData();

                int count = 0;
                for (Movie movie : movies) {
                    movie.setMovieImg(R.drawable.ic_profile);
                }
                DisplayMovieList(movies, view);
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {

            }
        });
        return;
    }

    private void DisplayMovieList(List<Movie> movies, View view){
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        movieList.addAll(movies);

        TextView mTextView = (TextView) view.findViewById(R.id.no_rooms);
        emptyList= view.findViewById(R.id.empty_recycler_view_movies);
        mRecyclerView= view.findViewById(R.id.recyclerview_watch_later);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        mMovieAdapter = new MovieAdapter(this.getContext(), movieList);
        mRecyclerView.setAdapter(mMovieAdapter);

        if (!movieList.isEmpty()){
            emptyList.setVisibility(View.GONE);
        }
    }


}
