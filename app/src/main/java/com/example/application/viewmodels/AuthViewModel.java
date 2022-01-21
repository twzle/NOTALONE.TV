package com.example.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.application.repositories.AuthRepository;
import com.example.application.responses.AuthResponse;
import com.example.application.responses.UserResponse;

public class AuthViewModel extends ViewModel {
    private final AuthRepository authRepository;

    public AuthViewModel(){
        authRepository = new AuthRepository();
    }

    public LiveData<AuthResponse> getAuth(String login, String password, String vk_id, String fb_id, String g_id){
        return authRepository.getAuth(login, password, vk_id, fb_id, g_id);
    }

}
