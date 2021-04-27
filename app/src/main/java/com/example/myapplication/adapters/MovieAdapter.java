package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.views.AboutActivity;
import com.example.myapplication.models.Movie;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieHolder> {

    Context c;
    ArrayList<Movie> Movies_watchLater;

    public MovieAdapter(Context c, ArrayList<Movie> Movies_watchLater) {
        this.c = c;
        this.Movies_watchLater = Movies_watchLater;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorites_watch_later, null);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {
        holder.mMoviename.setText(Movies_watchLater.get(position).getTitle());
        holder.mImageView.setImageResource(Movies_watchLater.get(position).getMovieImg());
        holder.mKinopoisk.setText(String.format("Кинопоиск: %s", Float.toString(Movies_watchLater.get(position).getKinopoisk())));
        holder.mIMDB.setText(String.format("IMBD: %s", Float.toString(Movies_watchLater.get(position).getImdb())));
        holder.mGenres.setText(String.format("Жанры: %s", Movies_watchLater.get(position).getGenres()));
        holder.mYear.setText(String.format("Год: %s", Integer.toString(Movies_watchLater.get(position).getYear())));
        holder.mDate.setText(String.format("Добавлено: %s", Movies_watchLater.get(position).getDate_update()));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), AboutActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return Movies_watchLater.size();
    }
}

