package com.example.application.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.application.R;
import com.example.application.models.User;
import com.example.application.utilities.Utils;
import com.example.application.viewmodels.UserViewModel;

import java.util.Objects;

public class ProfileActivity extends BaseActivity implements  View.OnClickListener {
    String TOKEN = null;
    Integer ID = null;

    ImageView avatar;
    TextView nickname;
    TextView status;

    UserViewModel userViewModel;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);

        setupSystemInterfaceTools();
        findViews();
        onInitializeButtons();

        checkIntent();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.about :
                startActivity(new Intent(ProfileActivity.this, AboutActivity.class));
                break;
            case R.id.logout :
                startActivity(new Intent(ProfileActivity.this, AuthActivity.class));
                finish();
                break;
            case R.id.donate :
                startActivity(new Intent(ProfileActivity.this, SupportActivity.class));
                break;
        }
    }

    private void getUser(int userID) {
        userViewModel.getUser(userID).observe(this, userResponse -> {
            if (userResponse != null){
                if (userResponse.getData() != null){
                    User user = userResponse.getData();


                    TextView nickname = (TextView) findViewById(R.id.nickname_reg);
                    TextView status = (TextView) findViewById(R.id.statusText);
                    nickname.setText(user.getNickname());
                    status.setText(user.getLogin());

                    Glide.with(avatar.getContext())
                            .load(Utils.checkLinkEntry("https://notalone.tv", user.getInfo().getAvatarID()))
                            .placeholder(R.drawable.ic_profile)
                            .into(avatar);
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void checkIntent() {
        if (getIntent().getExtras().get("TOKEN") != null && getIntent().getExtras().get("ID") != null) {
            TOKEN = getIntent().getExtras().get("TOKEN").toString();
            ID = getIntent().getExtras().getInt("ID");
        } else {
            nickname.setText("Guest");
            status.setText(Long.toString(Utils.getGuestId()));
        }

        if (ID==null)
            getUser(561758);
    }

    private void setupSystemInterfaceTools() {
        setContentView(R.layout.activity_profile);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_30);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.dark));

        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.dark));

    }

    private void findViews() {
        nickname = (TextView) findViewById(R.id.nickname_reg);
        status = (TextView) findViewById(R.id.statusText);
        avatar = findViewById(R.id.image_profile);
    }

    private void onInitializeButtons(){
        final Button btn_lvl=(Button)findViewById(R.id.lvl);
        final Button btn_edit_profile=(Button)findViewById(R.id.edit_profile);
        final Button btn_subscribe=(Button)findViewById(R.id.subscribe);
        final Button btn_status=(Button)findViewById(R.id.status);
        final Button btn_friends=(Button)findViewById(R.id.friends);
        final Button btn_settings=(Button)findViewById(R.id.settings);
        final Button btn_donate = (Button)findViewById(R.id.donate);
        final Button btn_news = (Button)findViewById(R.id.news);
        final Button btn_about = (Button)findViewById(R.id.about);
        final Button btn_logout = (Button)findViewById(R.id.logout);

        btn_lvl.setOnClickListener(this);
        btn_edit_profile.setOnClickListener(this);
        btn_subscribe.setOnClickListener(this);
        btn_status.setOnClickListener(this);
        btn_friends.setOnClickListener(this);
        btn_settings.setOnClickListener(this);
        btn_donate.setOnClickListener(this);
        btn_news.setOnClickListener(this);
        btn_about.setOnClickListener(this);
        btn_logout.setOnClickListener(this);

    }
}
