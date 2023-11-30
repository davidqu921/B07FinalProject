package com.example.b07projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class ViewComments extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase db;
    ArrayList<Comment> list;
    Button btnBack;

    CommentsAdapter myAdapter;

    String eventName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments);

        recyclerView = findViewById(R.id.studentViewComments);
        eventName = getIntent().getStringExtra("Event");
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com");
        DatabaseReference ref = db.getReference("event");



        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        myAdapter = new CommentsAdapter(this,list);
        recyclerView.setAdapter(myAdapter);



        ref.child(eventName).child("comment").addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap : snapshot.getChildren()){
                    String username = snap.child("username").getValue(String.class);
                    long rating = snap.child("rating").getValue(Long.class);
                    String review = snap.child("review").getValue(String.class);

                    // Create a Comment object
                    Comment comment = new Comment(username,(int)rating, review);

                    // Add the Comment object to the list
                    list.add(comment);

                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });
        btnBack = findViewById(R.id.CommentsBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }
}