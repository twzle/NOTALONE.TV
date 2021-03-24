package com.example.myapplication.adapters;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

public class FriendHolder extends RecyclerView.ViewHolder {

    ImageView mImageView;
    TextView mNickname, mStatus;
    public FriendHolder(@NonNull View itemView) {
        super(itemView);
        this.mImageView=itemView.findViewById(R.id.iv_friend_profile_img);
        this.mNickname=itemView.findViewById(R.id.iv_friend_nickname);
        this.mStatus=itemView.findViewById(R.id.iv_friend_status);
    }
}
