package com.example.b07projectapp;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

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
import java.util.concurrent.TimeUnit;

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
        ref.child(eventName).child("comment").addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot snap : snapshot.getChildren()) {
                        String username = snap.child("username").getValue(String.class);
                        float rating = snap.child("rating").getValue(Long.class);
                        String review = snap.child("review").getValue(String.class);
                        // Create a Comment object
                        Comment comment = new Comment(username, rating, review);
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
    public void onClickAddComments(View view) {
        if(getIntent().getBooleanExtra("joined", false)) {
            Intent intent = new Intent(getApplicationContext(), StudentComment.class);
            String eventStr = getIntent().getStringExtra("Event");
            intent.putExtra("Event", eventStr);
            String sStr = getIntent().getStringExtra("stu");
            intent.putExtra("stu", sStr);
            intent.putExtra("student", getIntent().getStringExtra("student"));
            if (getIntent().getStringExtra("username") != null) {
                String user = getIntent().getStringExtra("username");
                intent.putExtra("username", user);
            }
            finish();
            startActivity(intent);
        }
        else makeText(this, "You must join the event before leaving a review", LENGTH_SHORT).show();
    }
}