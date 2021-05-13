package com.example.myapplication.models;


import java.util.List;

public class User {
    private int id;
    private String login;
    private String nickname;
    private int activity;
    private String email;

    private Info info;

    private List<Integer> friends;

    private List<Integer> black_list;

    private Privilege privilege;

    private Socials socials;

    private Settings settings;

    private Ban ban;

    private int role;

    private int mark;

    public class Ban{
        private boolean status;
        private String reason;

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public Ban(boolean status, String reason) {
            this.status = status;
            this.reason = reason;
        }
    }

    public class Settings{
        private boolean rooms_public;
        private boolean message_audio;
        private String site_background;
        private boolean favourites_public;

        public boolean isRooms_public() {
            return rooms_public;
        }

        public void setRooms_public(boolean rooms_public) {
            this.rooms_public = rooms_public;
        }

        public boolean isMessage_audio() {
            return message_audio;
        }

        public void setMessage_audio(boolean message_audio) {
            this.message_audio = message_audio;
        }

        public String getSite_background() {
            return site_background;
        }

        public void setSite_background(String site_background) {
            this.site_background = site_background;
        }

        public boolean isFavourites_public() {
            return favourites_public;
        }

        public void setFavourites_public(boolean favourites_public) {
            this.favourites_public = favourites_public;
        }

        public Settings(boolean rooms_public, boolean message_audio, String site_background, boolean favourites_public) {
            this.rooms_public = rooms_public;
            this.message_audio = message_audio;
            this.site_background = site_background;
            this.favourites_public = favourites_public;
        }
    }

    public class Socials{
        private String vk_id;
        private String fb_id;
        private String g_id;

        public String getVk_id() {
            return vk_id;
        }

        public void setVk_id(String vk_id) {
            this.vk_id = vk_id;
        }

        public String getFb_id() {
            return fb_id;
        }

        public void setFb_id(String fb_id) {
            this.fb_id = fb_id;
        }

        public String getG_id() {
            return g_id;
        }

        public void setG_id(String g_id) {
            this.g_id = g_id;
        }

        public Socials(String vk_id, String fb_id, String g_id) {
            this.vk_id = vk_id;
            this.fb_id = fb_id;
            this.g_id = g_id;
        }
    }

    public class Privilege{
        private int premium_end;
        private int donate_amount;

        public int getPremium_end() {
            return premium_end;
        }

        public void setPremium_end(int premium_end) {
            this.premium_end = premium_end;
        }

        public int getDonate_amount() {
            return donate_amount;
        }

        public void setDonate_amount(int donate_amount) {
            this.donate_amount = donate_amount;
        }

        public Privilege(int premium_end, int donate_amount) {
            this.premium_end = premium_end;
            this.donate_amount = donate_amount;
        }
    }

    public class Info{
        private String gender;
        private String avatar;
        private int date_reg;
        private boolean email_confirm;

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getAvatarID() {
            return avatar;
        }

        public void setAvatarID(int avatarID) {
            this.avatar = avatar;
        }

        public int getDate_reg() {
            return date_reg;
        }

        public void setDate_reg(int date_reg) {
            this.date_reg = date_reg;
        }

        public boolean isEmail_confirm() {
            return email_confirm;
        }

        public void setEmail_confirm(boolean email_confirm) {
            this.email_confirm = email_confirm;
        }

        public Info(String gender, int avatarID, int date_reg, boolean email_confirm) {
            this.gender = gender;
            this.avatar = avatar;
            this.date_reg = date_reg;
            this.email_confirm = email_confirm;
        }
    }

    public User(int id, String login, String nickname, int activity, String email) {
        this.id = id;
        this.login = login;
        this.nickname = nickname;
        this.activity = activity;
        this.email = email;
    }

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

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Info getInfo() {
        return info;
    }
}

