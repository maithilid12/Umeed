package com.example.shreyaghose.umeed;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

public class Alternatives extends AppCompatActivity {
    FloatingActionMenu floatingmenu;
    FloatingActionButton add, add2, add3;
    TextView textView, textView1, textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alternatives);
        floatingmenu = (FloatingActionMenu) findViewById(R.id.FloatingActionMenu);
        add = findViewById(R.id.Item_Activity);
        add2= findViewById(R.id.Item_Help);
        add3=findViewById(R.id.Feedback);
        textView=findViewById(R.id.textview5);
        textView1=findViewById(R.id.textview6);
        textView2=findViewById(R.id.textview7);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Alternatives.this,Psychologists.class));
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Alternatives.this,CONTACTS_DISP.class));
            }
        });
        add3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i90 = new Intent(Intent.ACTION_VIEW);
                i90.setData(Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfLILJ3jL2mil3hiK-b9Iphy8KQ1cppsIMoPxY-B0fES7FvMw/viewform?c=0&w=1"));
                startActivity(i90);
            }
        });
    }
}
