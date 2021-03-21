package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Favorites.Movie;
import com.example.myapplication.Favorites.MovieAdapter;
import com.example.myapplication.Friends.Friend;
import com.example.myapplication.Friends.FriendAdapter;
import com.example.myapplication.Network.Api;
import com.example.myapplication.Network.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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


    private ArrayList<Movie> getMovieList(){

        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        movie.setMoviename("Джокер");
        movie.setMovieImg(R.drawable.ic_profile);
        movies.add(movie);

        movie = new Movie();
        movie.setMoviename("Идеальные незнакомцы");
        movie.setMovieImg(R.drawable.ic_profile);
        movies.add(movie);

        movie = new Movie();
        movie.setMoviename("А в душе я танцую");
        movie.setMovieImg(R.drawable.ic_profile);
        movies.add(movie);

        movie = new Movie();
        movie.setMoviename("1000 слов");
        movie.setMovieImg(R.drawable.ic_profile);
        movies.add(movie);


        return movies;
    }

    private void LoadDetails(View view){
        ApiService apiService = new ApiService();
        Api api = apiService.getApiService().create(Api.class);
        Call<List<Movie>> call = api.getMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                List<Movie> movies = null;
                movies=response.body();

                int count = 0;
                for (Movie movie : movies) {
                    movie.setMovieImg(R.drawable.ic_profile);
                }
                DisplayUserList(movies, view);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
        return;
    }

    private void DisplayUserList(List<Movie> movies, View view){
        movies = movies.subList(0,15);
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
