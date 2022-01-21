package com.example.application.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.application.R;
import com.example.application.models.AuthInformation;
import com.example.application.network.ApiService;
import com.example.application.network.NotAloneApi;
import com.example.application.responses.AuthResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        getSupportActionBar().hide();
        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.dark));
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        EditText v = findViewById(R.id.login_reg);
        EditText g = findViewById(R.id.pass);
        HideKeyboardEditText(v);
        HideKeyboardEditText(g);
        onInitializeButtons();
        FullScreencall();
    };

    @Override
    public void onClick(View v) {
        EditText login_text = findViewById(R.id.login_reg);
        EditText password_text = findViewById(R.id.pass);
        String login = login_text.getText().toString();
        String password = password_text.getText().toString();
        switch(v.getId()){
            case R.id.button_enter:
                getAuthorized(login, password);
                break;
            case R.id.button_enter_as :
                startActivity(new Intent(AuthActivity.this, MainActivity.class));
                finish();
                break;
            case R.id.button_reg :
                startActivity(new Intent(AuthActivity.this, SignInActivity.class));
                finish();
                break;
        }
    }

    public void getAuthorized(String login, String password){
        ApiService apiService = new ApiService();
        NotAloneApi api = apiService.getNotAloneApiService().create(NotAloneApi.class);
        Call<AuthResponse> call = api.auth("odsu6JggH90Z1D69AVCw", login, password, null, null, null);

        boolean auth_result = false;

        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
                if (response.body() != null) {
                    AuthInformation information = response.body().getData();
                    if (response.body().isResult()) {
                        Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                        intent.putExtra("TOKEN", response.body().getData().getToken());
                        intent.putExtra("ID", response.body().getData().getId());
                        startActivity(intent);
                        finish();
                    } else {
                        Log.e("TAG", "NUll");
                    }
                } else
                    Log.e("TAG", "NUll");
            }

            @Override
            public void onFailure(Call<AuthResponse> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
        return;
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