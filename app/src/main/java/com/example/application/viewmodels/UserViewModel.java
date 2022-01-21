package com.example.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.application.models.Friend;
import com.example.application.repositories.FriendRepository;
import com.example.application.repositories.UserRepository;
import com.example.application.responses.UserResponse;

import java.util.List;

public class UserViewModel extends ViewModel {
    private final UserRepository userRepository;

    public UserViewModel(){
        userRepository = new UserRepository();
    }

    public LiveData<UserResponse> getUser(int userID){
        return userRepository.getUser(userID);
    }

}
