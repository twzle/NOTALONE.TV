package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;


import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Friends.Friend;

public class ProfileActivity extends BaseActivity implements  View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_30);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.dark));

        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.dark));

        onInitializeButtons();

        if (getIntent().getExtras()!=null) {
            Friend friend;
            friend = (Friend) getIntent().getSerializableExtra("User");
            TextView nickname = (TextView) findViewById(R.id.nickname_reg);
            TextView status = (TextView) findViewById(R.id.statusText);
            nickname.setText(friend.getNickname());
            status.setText(friend.getStatus());
        }

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

    public void onInitializeButtons(){
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
