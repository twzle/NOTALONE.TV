package com.example.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.application.models.Friend;
import com.example.application.repositories.FriendRepository;
import com.example.application.repositories.MovieRepository;
import com.example.application.responses.MovieResponse;

import java.util.List;

public class FriendViewModel extends ViewModel {

    private final FriendRepository friendRepository;

    public FriendViewModel(){
        friendRepository = new FriendRepository();
    }

    public LiveData<List<Friend>> getFriends(){
        return friendRepository.getFriends();
    }

}
