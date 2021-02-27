package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.nfc.cardemulation.CardEmulation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendHolder> {

    Context c;
    ArrayList<Friend> friends;

    public FriendAdapter(Context c, ArrayList<Friend> friends) {
        this.c = c;
        this.friends = friends;
    }

    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_list_row, null);
        return new FriendHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendHolder holder, int position) {
        holder.mNickname.setText(friends.get(position).getNickname());
        holder.mStatus.setText(friends.get(position).getStatus());
        holder.mImageView.setImageResource(friends.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(),ProfileActivity.class));

            }
        });
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }
}