package com.example.application.views;

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
import com.example.application.network.ApiService;
import com.example.application.network.NotAloneApi;
import com.example.application.responses.UserResponse;
import com.example.application.utilities.Utils;
import com.example.application.viewmodels.CatalogueViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends BaseActivity implements  View.OnClickListener {
    String TOKEN = null;
    Integer ID = null;

    ImageView avatar;

    CatalogueViewModel cvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cvm = new ViewModelProvider(this).get(CatalogueViewModel.class);

        setContentView(R.layout.activity_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_close_30);

        getWindow().setNavigationBarColor(getResources().getColor(R.color.dark));

        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.dark));

        onInitializeButtons();

        if (getIntent().getExtras().get("TOKEN") != null && getIntent().getExtras().get("ID") != null) {
            TOKEN = getIntent().getExtras().get("TOKEN").toString();
            ID = getIntent().getExtras().getInt("ID");
        } else {
            TextView nickname = (TextView) findViewById(R.id.nickname_reg);
            TextView status = (TextView) findViewById(R.id.statusText);
            nickname.setText("Guest");
            status.setText(Long.toString(Utils.getGuestId()));
        }


        avatar = findViewById(R.id.image_profile);

        if (ID!=null)
            LoadDetails(ID);

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

    private  void LoadDetails(int id){
        ApiService apiService = new ApiService();
        NotAloneApi api = apiService.getNotAloneApiService().create(NotAloneApi.class);
        Call<UserResponse> call = api.getUser("odsu6JggH90Z1D69AVCw", id);

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.code()==200) {
                    UserResponse u_response = response.body();
                    User user = u_response.getData();
                    TextView nickname = (TextView) findViewById(R.id.nickname_reg);
                    TextView status = (TextView) findViewById(R.id.statusText);
                    nickname.setText(user.getNickname());
                    status.setText(user.getLogin());

                    Glide.with(avatar.getContext())
                            .load("https://notalone.tv" +user.getInfo().getAvatarID())
                            .placeholder(R.drawable.ic_profile)
                            .into(avatar);

                }

                Log.v("TAG", Integer.toString(response.code()) + "\t" + response.message());

                System.out.println(Integer.toString(response.code()) + "\t" + response.message());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.v("TAG", t.getMessage());

                System.out.println(t.getMessage());
            }
        });
        return;
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
