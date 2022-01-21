package com.example.application.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;

public class CatalogueMovieHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mMoviename;

    public CatalogueMovieHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView=itemView.findViewById(R.id.iv_newest_movieimg);
        this.mMoviename=itemView.findViewById(R.id.iv_newest_moviename);
    }
}
