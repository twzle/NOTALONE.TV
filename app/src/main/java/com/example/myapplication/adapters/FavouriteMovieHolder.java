package com.example.myapplication.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class FavouriteMovieHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mMoviename;
    TextView mKinopoisk;
    TextView mIMDB;
    TextView mYear;
    TextView mGenres;
    TextView mDate;

    public FavouriteMovieHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView=itemView.findViewById(R.id.iv_favorites_movieimg);
        this.mMoviename=itemView.findViewById(R.id.iv_favorites_moviename);
        this.mKinopoisk=itemView.findViewById(R.id.iv_favorites_kinopoisk);
        this.mIMDB=itemView.findViewById(R.id.iv_favorites_imdb);
        this.mYear=itemView.findViewById(R.id.iv_year);
        this.mGenres=itemView.findViewById(R.id.iv_genre);
        this.mDate=itemView.findViewById(R.id.iv_favorites_date);
    }
}