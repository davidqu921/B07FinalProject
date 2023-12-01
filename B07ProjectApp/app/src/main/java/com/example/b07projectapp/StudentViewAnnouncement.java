package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class StudentViewAnnouncement extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase db;
    StudentAnnouncementAdapter adapter;
    ArrayList<Announcement> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_view_announcement);

        recyclerView = findViewById(R.id.StudentViewAnnouncement);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
        DatabaseReference ref = db.getReference();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new StudentAnnouncementAdapter(this, list);
        recyclerView.setAdapter(adapter);

        ref.child("announcements").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snap : snapshot.getChildren()){
                    String title = snap.child("title").getValue(String.class);
                    String time = snap.child("time").getValue(String.class);
                    String name = snap.child("name").getValue(String.class);
                    String content = snap.child("content").getValue(String.class);
                    Announcement announcement = new Announcement(name, title, time, content);
                    list.add(announcement);
                }
                Collections.reverse(list);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

    public void onClickStudentAnnouncementGoBack(View view) {
        onBackPressed();
    }
}