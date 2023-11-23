package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class AdminViewComplaint extends AppCompatActivity {
    RecyclerView recyclerView;
    FirebaseDatabase db;
    ComplaintAdapter comAdapter;
    ArrayList<Complaint> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_view_complaint);

        recyclerView = findViewById(R.id.adminViewComplaint);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
        DatabaseReference ref = db.getReference();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        comAdapter = new ComplaintAdapter(this, list);
        recyclerView.setAdapter(comAdapter);

        ref.child("complaints").addValueEventListener(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot snap : snapshot.getChildren()){
                    String topic = snap.child("topic").getValue(String.class);
                    String content = snap.child("content").getValue(String.class);
                    String name = snap.child("name").getValue(String.class);
                    Complaint complaint = new Complaint(topic, content, name);
                    list.add(complaint);
                }
                Collections.reverse(list);
                comAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error){

            }
        });
    }
}