package com.example.application.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.application.R;
import com.example.application.utilities.Utils;

import java.util.Objects;

public class SplashActivity extends BaseActivity {

//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.dark));
        setContentView(R.layout.activity_splash);

        FullScreencall();

        Objects.requireNonNull(getSupportActionBar()).hide();

        Utils.getGuestId();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, AuthActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}