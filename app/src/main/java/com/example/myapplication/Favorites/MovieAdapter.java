package com.example.myapplication.Favorites;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FavouritesFragment;
import com.example.myapplication.Friends.Friend;
import com.example.myapplication.Friends.FriendHolder;
import com.example.myapplication.ProfileActivity;
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
        holder.mMoviename.setText(Movies_watchLater.get(position).getMoviename());
        holder.mImageView.setImageResource(Movies_watchLater.get(position).getMovieImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), FavouritesFragment.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return Movies_watchLater.size();
    }
}

