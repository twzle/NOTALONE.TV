package com.example.application.models;

public class AuthInformation {
    private int id;
    private String login;
    private String nickname;
    private String token;
    private String activity;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AuthInformation(int id, String login, String nickname, String token, String activity, String email) {
        this.id = id;
        this.login = login;
        this.nickname = nickname;
        this.token = token;
        this.activity = activity;
        this.email = email;
    }
}
