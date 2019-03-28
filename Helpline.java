package com.example.shreyaghose.umeed;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Helpline extends AppCompatActivity {

    private RecyclerView mUserList;
    private DatabaseReference mUsers;
    Button B1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychologists);
        B1=findViewById(R.id.button2);
        mUsers = FirebaseDatabase.getInstance().getReference().child("Psychologists");
        mUserList = findViewById(R.id.user_list);
        mUserList.setHasFixedSize(true);
        mUserList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Query liked = mUsers.orderByChild("Psychologists");


        FirebaseRecyclerOptions<PsychologistsClass> options =
                new FirebaseRecyclerOptions.Builder<PsychologistsClass>()
                        .setQuery(mUsers, PsychologistsClass.class)
                        .build();
        FirebaseRecyclerAdapter<PsychologistsClass, Psychologists.UserViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<PsychologistsClass, Psychologists.UserViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Psychologists.UserViewHolder holder, int position, @NonNull PsychologistsClass model) {

                holder.setName(model.getName());
                holder.setContact(model.getContact());
            }

            @NonNull
            @Override
            public Psychologists.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_row, parent, false);
                return new Psychologists.UserViewHolder(view);
            }
        };
        firebaseRecyclerAdapter.startListening();
        mUserList.setAdapter(firebaseRecyclerAdapter);

    }
    public static class UserViewHolder extends RecyclerView.ViewHolder{

        View mView;

        public UserViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setName(String Name)
        {
            TextView user_name = (TextView) mView.findViewById(R.id.user_name);
            user_name.setText(Name);
        }

        public void setContact(String Contact)
        {
            TextView user_contact = (TextView) mView.findViewById(R.id.user_contact);
            user_contact.setText(Contact);
        }

    }

}
