package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class AdminViewAnnouncement extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase db;
    AdminAnnouncementAdapter adapter;
    ArrayList<Announcement> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_announcement);


        recyclerView = findViewById(R.id.AdminViewAnnouncement);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
        DatabaseReference ref = db.getReference();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        adapter = new AdminAnnouncementAdapter(this, list);
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
            public void onCancelled(@NonNull DatabaseError error){

            }
        });
    }

    public void onClickAdminAnnouncementGoBack(View view) {
        onBackPressed();
    }

    public void onClickAdminNewAnnouncement(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminPostAnnouncement.class);
        startActivity(intent);
    }
}