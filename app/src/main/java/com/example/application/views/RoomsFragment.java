package com.example.application.views;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.application.R;
import com.example.application.models.Friend;
import com.example.application.adapters.FriendAdapter;
import com.example.application.utilities.Utils;
import com.example.application.viewmodels.FriendViewModel;

import java.util.ArrayList;
import java.util.List;

public class RoomsFragment extends Fragment{

    FriendViewModel friendViewModel;

    RecyclerView friendRecyclerView;

    List<Friend> friends = new ArrayList<>();

    FriendAdapter friendAdapter;

    TextView emptyList;
    Utils mUtils;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rooms, container, false);
        friendViewModel = new ViewModelProvider(requireActivity()).get(FriendViewModel.class);
        doInitiliazition(view);
        changeViewVisibility(view);

        // PRE-LOADS
        getFriends();
        return view;
    }

    private void changeViewVisibility(View view) {
        emptyList= view.findViewById(R.id.empty_recycler_view);

        friendAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if (friends.isEmpty()){
                    emptyList.setVisibility(View.VISIBLE);
                } else {
                    emptyList.setVisibility(View.GONE);
                }
            }
        });
    }


    private void doInitiliazition(View view){
        friendRecyclerView = view.findViewById(R.id.recyclerview_online_friends);
        friendRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        friendAdapter = new FriendAdapter(this.getContext(), friends);
        friendRecyclerView.setAdapter(friendAdapter);
    }


    private void getFriends(){
        friendViewModel.getFriends().observe(getViewLifecycleOwner(), friendsResponse -> {
            if (friendsResponse != null){
                for (Friend friend : friendsResponse) {
                    Bitmap icon = mUtils.getBitmapFromVectorDrawable(getContext(),R.drawable.ic_profile);
                    friend.setImg(icon);
                }

                friends.addAll(friendsResponse);
                friendAdapter.notifyDataSetChanged();
                }
        });
    }

}

