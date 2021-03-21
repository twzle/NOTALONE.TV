package com.example.myapplication.Friends;

import android.graphics.Bitmap;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
public class Friend implements Serializable {

    @SerializedName("username")
    private String nickname;
    @SerializedName("name")
    private String status;
    private Bitmap img;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }
}
