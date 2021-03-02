package com.example.myapplication.Favorites;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class MovieHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mMoviename, mStatus;
    public MovieHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView=itemView.findViewById(R.id.iv_movie_catalogue_img);
        this.mMoviename=itemView.findViewById(R.id.iv_catalogue_moviename);
    }
}