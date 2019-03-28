package com.example.shreyaghose.umeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView mv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mv=(ImageView)findViewById(R.id.image);
        final Intent intent =new Intent(MainActivity.this,Loginorchat.class);
        Animation myanim= AnimationUtils.loadAnimation(this,R.anim.mytransition);
        mv.startAnimation(myanim);
        Thread timer= new Thread()
        {
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}