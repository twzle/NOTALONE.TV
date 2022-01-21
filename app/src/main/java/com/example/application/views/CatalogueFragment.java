package com.example.application.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.adapters.CatalogueMovieAdapter;
import com.example.application.models.Movie;
import com.example.application.viewmodels.CatalogueViewModel;

import java.util.ArrayList;
import java.util.List;

public class CatalogueFragment extends Fragment {

    RecyclerView newestMoviesRecyclerView;
    RecyclerView popularMoviesRecyclerView;

    CatalogueMovieAdapter newestMoviesAdapter;
    CatalogueMovieAdapter popularMoviesAdapter;

    private CatalogueViewModel catalogueViewModel;
    List<Movie> newestMovies = new ArrayList<Movie>();
    List<Movie> popularMovies = new ArrayList<Movie>();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalogue, container, false);
        catalogueViewModel = new ViewModelProvider(requireActivity()).get(CatalogueViewModel.class);
        doInitialization(view);

        getNewestMovies();
        getPopularMovies();
        return view;
    }

    private void doInitialization(View view){
        newestMoviesRecyclerView = view.findViewById(R.id.recyclerview_newest_movies);
        newestMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        newestMoviesAdapter = new CatalogueMovieAdapter(this.getContext(), newestMovies);
        newestMoviesRecyclerView.setAdapter(newestMoviesAdapter);

        popularMoviesRecyclerView = view.findViewById(R.id.recyclerview_popular_movies);
        popularMoviesRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        popularMoviesAdapter = new CatalogueMovieAdapter(this.getContext(), popularMovies);
        popularMoviesRecyclerView.setAdapter(popularMoviesAdapter);
    }

    private void getNewestMovies(){
        catalogueViewModel.getNewestMovies().observe(getViewLifecycleOwner(), newestMoviesResponse -> {
            if (newestMoviesResponse != null){
                if (newestMoviesResponse.getData() != null){
                    List<Movie> movies = newestMoviesResponse.getData();

                    for (Movie movie : movies) {
                        movie.setMovieImg(R.drawable.ic_profile);
                    }
                    newestMovies.addAll(movies);
                    newestMoviesAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void getPopularMovies(){
        catalogueViewModel.getPopularMovies().observe(getViewLifecycleOwner(), popularMoviesResponse -> {
            if (popularMoviesResponse != null){
                if (popularMoviesResponse.getData() != null){
                    List<Movie> movies = popularMoviesResponse.getData();

                    for (Movie movie : movies) {
                        movie.setMovieImg(R.drawable.ic_profile);
                    }
                    popularMovies.addAll(movies);
                    popularMoviesAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
