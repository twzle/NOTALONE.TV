package com.example.myapplication.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class NewestMovieHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mMoviename;

    public NewestMovieHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView=itemView.findViewById(R.id.iv_newest_movieimg);
        this.mMoviename=itemView.findViewById(R.id.iv_newest_moviename);
    }
}
