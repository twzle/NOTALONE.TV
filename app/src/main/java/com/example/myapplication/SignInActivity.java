package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignInActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        this.getWindow().setStatusBarColor(this.getResources().getColor(R.color.dark));
        EditText a = findViewById(R.id.login_reg);
        EditText b = findViewById(R.id.pass_reg);
        EditText c = findViewById(R.id.repeat_pass_reg);
        EditText d = findViewById(R.id.nickname_reg);
        EditText e = findViewById(R.id.email_reg);
        HideKeyboardEditText(a);
        HideKeyboardEditText(b);
        HideKeyboardEditText(c);
        HideKeyboardEditText(d);
        HideKeyboardEditText(e);
        FullScreencall();

        Button btn = (Button) findViewById(R.id.already_have_an_account);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.already_have_an_account:
                startActivity(new Intent(SignInActivity.this, AuthActivity.class));
                finish();
                break;
        }
    }
}