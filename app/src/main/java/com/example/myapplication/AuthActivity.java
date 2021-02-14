package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AuthActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullScreencall();
        setContentView(R.layout.auth_screen);
        getSupportActionBar().hide();
        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.dark));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        EditText v = findViewById(R.id.login);
        EditText g = findViewById(R.id.pass);
        HideKeyboardEditText(v);
        HideKeyboardEditText(g);
        onInitializeButtons();
    };

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button_enter:
                break;
            case R.id.button_enter_as :
                startActivity(new Intent(AuthActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.button_reg :
                break;
        }
    }

    public void onInitializeButtons(){
        Button btn_login = (Button) findViewById(R.id.button_enter);
        Button btn_signin=(Button) findViewById(R.id.button_reg);
        Button btn_log_as=(Button) findViewById(R.id.button_enter_as);

        btn_login.setOnClickListener(this);
        btn_signin.setOnClickListener(this);
        btn_log_as.setOnClickListener(this);
    }
}