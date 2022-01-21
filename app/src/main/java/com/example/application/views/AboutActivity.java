package com.example.application.views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.application.R;

import java.net.URI;
import java.net.URISyntaxException;
import tech.gusavila92.websocketclient.WebSocketClient;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener{
    private WebSocketClient webSocketClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        createWebSocketClient();
        Button but1 = (Button) findViewById(R.id.but1);
        Button but2 = (Button) findViewById(R.id.but2);
        Button but3 = (Button) findViewById(R.id.but3);
        Button but4 = (Button) findViewById(R.id.but4);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("WebSocket", "Button was clicked");
        // Send button id string to WebSocket Server
        switch (v.getId()) {
            case (R.id.but1):
                webSocketClient.send("1");
                System.out.println("but 1 pressed");
                break;
            case (R.id.but2):
                webSocketClient.send("2");
                System.out.println("but 2 pressed");
                break;
            case (R.id.but3):
                webSocketClient.send("3");
                System.out.println("but 3 pressed");
                break;
            case (R.id.but4):
                webSocketClient.send("4");
                System.out.println("but 4 pressed");
                break;
        }
    }


    private void createWebSocketClient() {
        URI uri;
        try {
            System.out.println("made a connection");
            // Connect to local host
            uri = new URI("ws://10.0.2.2:8080/websocket");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }
        webSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen() {
                Log.i("WebSocket", "Session is starting");
                webSocketClient.send("Hello World!");
                System.out.println("YOU OPENED THAT SHIT");
            }

            @Override
            public void onTextReceived(String s) {
                Log.i("WebSocket", "Message received");
                final String message = s;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            TextView textView = findViewById(R.id.about_progress);
                            textView.setText(message);
                            System.out.println("textReceieved");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            @Override
            public void onBinaryReceived(byte[] data) {
            }

            @Override
            public void onPingReceived(byte[] data) {
            }

            @Override
            public void onPongReceived(byte[] data) {
            }

            @Override
            public void onException(Exception e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onCloseReceived() {
                Log.i("WebSocket", "Closed ");
                System.out.println("onCloseReceived");
            }
        };
        webSocketClient.setConnectTimeout(10000);
        webSocketClient.setReadTimeout(60000);
        webSocketClient.enableAutomaticReconnection(5000);
        webSocketClient.connect();
    }

    public void sendMessage(View view) {
        Log.i("WebSocket", "Button was clicked");
        // Send button id string to WebSocket Server
        switch (view.getId()) {
            case (R.id.but1):
                webSocketClient.send("1");
                System.out.println("but 1 pressed");
                break;
            case (R.id.but2):
                webSocketClient.send("2");
                System.out.println("but 2 pressed");
                break;
            case (R.id.but3):
                webSocketClient.send("3");
                System.out.println("but 3 pressed");
                break;
            case (R.id.but4):
                webSocketClient.send("4");
                System.out.println("but 4 pressed");
                break;
        }

    }
}