package com.example.application.responses;

import com.example.application.models.User;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("result")
    private boolean result;

    @SerializedName("data")
    private User data;

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }

    public UserResponse(boolean result, User data) {
        this.result = result;
        this.data = data;
    }
}

