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

import java.util.ArrayList;

public class FavouritesFragment extends Fragment {

    RecyclerView mRecyclerView;
    MovieAdapter mMovieAdapter;
    TextView emptyList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourites, container, false);
        TextView mTextView = (TextView) view.findViewById(R.id.no_rooms);
        emptyList= view.findViewById(R.id.empty_recycler_view_movies);
        //mTextView.setVisibility(View.GONE);

        mRecyclerView= view.findViewById(R.id.recyclerview_watch_later);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        mMovieAdapter = new MovieAdapter(this.getContext(), getMovieList());
        mRecyclerView.setAdapter(mMovieAdapter);

        if (!getMovieList().isEmpty()){
            emptyList.setVisibility(View.GONE);
        }



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
}
