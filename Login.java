package com.example.shreyaghose.umeed;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    private EditText email, password;
    private Button login;
    private ProgressBar progressBar;
    FirebaseAuth li;
    FirebaseAuth.AuthStateListener asl;

    @Override
    protected void onStart()
    {
        super.onStart();

        FirebaseUser currentuser=li.getCurrentUser();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);
        li=FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.Email);
        password=findViewById(R.id.Password);
        login=findViewById(R.id.Login);
        progressBar=findViewById(R.id.progressBar);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty())
                {
                    email.setError("Email ID is empty");
                }
                else if (password.getText().toString().isEmpty()) {
                    password.setError("Password is empty");
                }
                else {
                    input();
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }
    protected void input()
    {
        li.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = li.getCurrentUser();
                            Toast.makeText(Login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, Activities.class);
                            startActivity(intent);
                            progressBar.setVisibility(View.GONE);
                        }
                        else
                        {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(Login.this, "Authentication failed, try again", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}