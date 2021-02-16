package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RoomsFragment extends Fragment {

    RecyclerView mRecyclerView;
    FriendAdapter mfriendAdapter;
    TextView emptyList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rooms, container, false);
        TextView mTextView = (TextView) view.findViewById(R.id.no_rooms);
        emptyList= view.findViewById(R.id.empty_recycler_view);
        mTextView.setVisibility(View.GONE);

        mRecyclerView= view.findViewById(R.id.recyclerview_online_friends);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        mfriendAdapter = new FriendAdapter(this.getContext(), getFriendList());
        mRecyclerView.setAdapter(mfriendAdapter);

        if (!getFriendList().isEmpty()){
            emptyList.setVisibility(View.GONE);
        }


        return view;
    }

    private ArrayList<Friend> getFriendList(){
        ArrayList<Friend> friends = new ArrayList<>();

        Friend friend = new Friend();
        friend.setNickname("INEXY");
        friend.setStatus("here we go");
        friend.setImg(R.drawable.ic_profile);
//        friends.add(friend);

        friend = new Friend();
        friend.setNickname("NEXY");
        friend.setStatus("kek");
        friend.setImg(R.drawable.ic_profile);
//        friends.add(friend);

        friend = new Friend();
        friend.setNickname("Admin");
        friend.setStatus("вы");
        friend.setImg(R.drawable.ic_profile);
//        friends.add(friend);

        friend = new Friend();
        friend.setNickname("Guest");
        friend.setStatus("undefined");
        friend.setImg(R.drawable.ic_profile);
//        friends.add(friend);

        return friends;
    }

}

