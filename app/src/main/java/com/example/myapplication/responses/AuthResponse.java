package com.example.myapplication.responses;

import com.example.myapplication.models.AuthInformation;

public class AuthResponse {
    private boolean result;

    private AuthInformation data;


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public AuthInformation getData() {
        return data;
    }

    public void setData(AuthInformation data) {
        this.data = data;
    }

    public AuthResponse(boolean result, AuthInformation data) {
        this.result = result;
        this.data = data;
    }
}
