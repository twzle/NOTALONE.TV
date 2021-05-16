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
import com.example.myapplication.R;
import com.example.myapplication.models.Movie;
import com.example.myapplication.views.AboutActivity;

import java.util.ArrayList;

public class NewestMovieAdapter extends RecyclerView.Adapter<NewestMovieHolder> {

    Context c;
    ArrayList<Movie> newest_movies;

    public NewestMovieAdapter(Context c, ArrayList<Movie> Movies_watchLater) {
        this.c = c;
        this.newest_movies = Movies_watchLater;
    }

    @NonNull
    @Override
    public NewestMovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.newest_movie, null);
        return new NewestMovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewestMovieHolder holder, int position) {
        holder.mMoviename.setText(newest_movies.get(position).getTitle());

        Glide.with(holder.itemView.getContext())
                .load(newest_movies.get(position).getPoster())
                .placeholder(newest_movies.get(position).getMovieImg())
                .apply(new RequestOptions().override(120, 180).fitCenter().dontAnimate())
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
        return newest_movies.size();
    }
}


