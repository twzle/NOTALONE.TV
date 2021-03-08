package com.example.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.net.URISyntaxException;
import tech.gusavila92.websocketclient.WebSocketClient;

public class SupportActivity extends BaseActivity implements View.OnClickListener{
    MainActivity main = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        onInitializeElements();
    }

    public void onInitializeElements(){
        EditText a = findViewById(R.id.support_name);
        EditText b = findViewById(R.id.support_question);
        EditText c = findViewById(R.id.support_text);
        EditText d = findViewById(R.id.donation_ammount);
        EditText e = findViewById(R.id.donation_message);
        HideKeyboardEditText(a);
        HideKeyboardEditText(b);
        HideKeyboardEditText(c);
        HideKeyboardEditText(d);
        HideKeyboardEditText(e);

        Button support = (Button) findViewById(R.id.support_btn);
        support.setOnClickListener(this);

        Button donate = (Button) findViewById(R.id.donate_btn);
        donate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast toast;
        InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
        switch (v.getId()){
            case R.id.support_btn:
                toast = Toast.makeText(getApplicationContext(), "Сообщение отправлено", Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.donate_btn:
                toast = Toast.makeText(getApplicationContext(), "Вы поддержали проект", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }
}