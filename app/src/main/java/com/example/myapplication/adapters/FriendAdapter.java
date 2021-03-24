package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.views.ProfileActivity;
import com.example.myapplication.R;
import com.example.myapplication.models.Friend;
import com.example.myapplication.views.UserInformationActivity;

import java.io.Serializable;
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
