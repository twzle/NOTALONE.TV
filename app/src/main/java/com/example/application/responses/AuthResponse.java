package com.example.application.responses;

import com.example.application.models.Auth;

public class AuthResponse {
    private boolean result;

    private Auth data;


    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Auth getData() {
        return data;
    }

    public void setData(Auth data) {
        this.data = data;
    }

    public AuthResponse(boolean result, Auth data) {
        this.result = result;
        this.data = data;
    }
}
