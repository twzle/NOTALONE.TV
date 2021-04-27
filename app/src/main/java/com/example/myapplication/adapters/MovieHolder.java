package com.example.myapplication.adapters;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import org.w3c.dom.Text;

public class MovieHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mMoviename;
    TextView mKinopoisk;
    TextView mIMDB;
    TextView mYear;
    TextView mGenres;
    TextView mDate;

    public MovieHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView=itemView.findViewById(R.id.iv_movie_catalogue_img);
        this.mMoviename=itemView.findViewById(R.id.iv_catalogue_moviename);
        this.mKinopoisk=itemView.findViewById(R.id.iv_kinopoisk);
        this.mIMDB=itemView.findViewById(R.id.iv_imdb);
        this.mYear=itemView.findViewById(R.id.iv_year);
        this.mGenres=itemView.findViewById(R.id.iv_genre);
        this.mDate=itemView.findViewById(R.id.iv_date);
    }
}