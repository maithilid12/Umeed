package com.example.shreyaghose.umeed;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activities extends AppCompatActivity {

    ImageButton alternatives, quiz, map, graphs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);

        alternatives=findViewById(R.id.alternatives);
        quiz=findViewById(R.id.quiz);
        map=findViewById(R.id.maps);
        graphs=findViewById(R.id.graph);

        alternatives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Activities.this,Alternatives.class);
                startActivity(intent);

            }
        });

        graphs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           Intent i6=new Intent(Activities.this,Graph.class);
           startActivity(i6);

            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.co.in/maps/place/iTalkTherapy+Counsellor+and+Psychologist/@19.1743598,72.8393147,17z/data=!3m1!4b1!4m5!3m4!1s0x3be7b6f871783865:0x5ff5ede0bbc3386c!8m2!3d19.1743547!4d72.8415034"));
                startActivity(i);
            }
        });

        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(Intent.ACTION_VIEW);
                i3.setData(Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSdIDzvs-tVp-EnPs5V1o5z1B1405T0k55QNIABsjA9p25cPMw/viewform?c=0&w=1"));
                startActivity(i3);
            }
        });
    }
}
