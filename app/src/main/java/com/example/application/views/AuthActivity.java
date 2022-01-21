package com.example.application.views;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.application.R;
import com.example.application.models.Auth;
import com.example.application.models.User;
import com.example.application.network.ApiService;
import com.example.application.network.NotAloneApi;
import com.example.application.responses.AuthResponse;
import com.example.application.utilities.Utils;
import com.example.application.viewmodels.AuthViewModel;
import com.example.application.viewmodels.UserViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends BaseActivity implements View.OnClickListener {

    EditText login_text, password_text;
    Button btn_login, btn_signin, btn_log_as;
    AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);

        setupSystemInterfaceTools();
        findViews();
        hideKeyboards();
        onInitializeButtons();
        FullScreencall();
    };

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        String login = login_text.getText().toString();
        String password = password_text.getText().toString();
        switch(v.getId()){
            case R.id.button_enter:
                getAuthorized(login, password);
                break;
            case R.id.button_enter_as:
                startActivity(new Intent(AuthActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.button_reg :
                startActivity(new Intent(AuthActivity.this, SignInActivity.class));
                finish();
                break;
        }
    }


    private void getAuthorized(String login, String password){
        authViewModel.getAuth(login, password, null, null,null).observe(this, authResponse -> {
            if (authResponse != null){
                if (authResponse.getData() != null){
                    Auth auth = authResponse.getData();
                    createAuthIntention(auth);
                }
            }
        });
    }

    private void createAuthIntention(Auth auth){
        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
        intent.putExtra("TOKEN", auth.getToken());
        intent.putExtra("ID", auth.getId());
        startActivity(intent);
        finish();
    }

    private void setupSystemInterfaceTools() {
        setContentView(R.layout.activity_auth);
        getSupportActionBar().hide();
        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.dark));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    private void hideKeyboards() {
        HideKeyboardEditText(login_text);
        HideKeyboardEditText(password_text);
    }

    private void findViews() {
        login_text = findViewById(R.id.login_reg);
        password_text = findViewById(R.id.pass);


        btn_login = (Button) findViewById(R.id.button_enter);
        btn_signin=(Button) findViewById(R.id.button_reg);
        btn_log_as=(Button) findViewById(R.id.button_enter_as);
    }

    private void onInitializeButtons(){
        btn_login = (Button) findViewById(R.id.button_enter);
        btn_signin=(Button) findViewById(R.id.button_reg);
        btn_log_as=(Button) findViewById(R.id.button_enter_as);

        btn_login.setOnClickListener(this);
        btn_signin.setOnClickListener(this);
        btn_log_as.setOnClickListener(this);
    }
}