package com.example.application.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.models.Friend;
import com.example.application.views.UserInformationActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendHolder> {

    Context c;
    List<Friend> friends;

    public FriendAdapter(Context c, List<Friend> friends) {
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
    public void onBindViewHolder(@NonNull FriendHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.mNickname.setText(friends.get(position).getNickname());
        holder.mStatus.setText(friends.get(position).getStatus());
        holder.mImageView.setImageBitmap(friends.get(position).getImg());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend friend = new Friend();
                friend.setNickname(friends.get(position).getNickname());
                friend.setStatus(friends.get(position).getStatus());

                Intent intent = new Intent(v.getContext(), UserInformationActivity.class);
                intent.putExtra("User", (Serializable) friend);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }
}
