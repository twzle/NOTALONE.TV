package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication.views.AboutActivity;
import com.example.myapplication.models.Movie;
import com.example.myapplication.R;

import java.util.ArrayList;

public class FavouriteMovieAdapter extends RecyclerView.Adapter<FavouriteMovieHolder> {

    Context c;
    ArrayList<Movie> watchLater_movies;

    public FavouriteMovieAdapter(Context c, ArrayList<Movie> watchLater_movies) {
        this.c = c;
        this.watchLater_movies = watchLater_movies;
    }

    @NonNull
    @Override
    public FavouriteMovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_watch_later, null);
        return new FavouriteMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavouriteMovieHolder holder, int position) {
        holder.mMoviename.setText(watchLater_movies.get(position).getTitle());
        holder.mKinopoisk.setText(String.format("Кинопоиск: %s", Float.toString(watchLater_movies.get(position).getKinopoisk())));
        holder.mIMDB.setText(String.format("IMBD: %s", Float.toString(watchLater_movies.get(position).getImdb())));
        holder.mGenres.setText(String.format("Жанры: %s", watchLater_movies.get(position).getGenres()));
        holder.mYear.setText(String.format("Год: %s", Integer.toString(watchLater_movies.get(position).getYear())));
        holder.mDate.setText(String.format("Добавлено: %s", watchLater_movies.get(position).getDate_update()));

        Glide.with(holder.itemView.getContext())
                .load(watchLater_movies.get(position).getPoster())
                .placeholder(watchLater_movies.get(position).getMovieImg())
                .apply(new RequestOptions().override(120, 180))
                .into(holder.mImageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), AboutActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return watchLater_movies.size();
    }
}

