package com.example.shreyaghose.umeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Loginorchat extends AppCompatActivity {

    Button chat, log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginorchat);

        chat=findViewById(R.id.Chat);
        log=findViewById(R.id.login);

        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Loginorchat.this,Chatbot.class);
                startActivity(intent);
            }
        });

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Loginorchat.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
