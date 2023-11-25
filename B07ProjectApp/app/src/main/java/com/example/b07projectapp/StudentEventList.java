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
import android.widget.SearchView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StudentEventList extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase db;
    MyAdapter myAdapter;
    ArrayList<Event> list;
    Button btnBack;
    MyAdapter.RecyclerViewClickListener listener;

    SearchView searchView;

    public void onclickEvent(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentEvents.class);
        startActivity(intent);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_event_list);

        searchView= findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        recyclerView = findViewById(R.id.StudentEventList);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com");
        DatabaseReference ref = db.getReference();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        setOnClickListener();
        myAdapter = new MyAdapter(this,list,listener);
        recyclerView.setAdapter(myAdapter);

        ref.child("event").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String title = dataSnapshot.child("title").getValue(String.class);
                    String location = dataSnapshot.child("location").getValue(String.class);
                    String date = dataSnapshot.child("date").getValue(String.class);
                    String description = dataSnapshot.child("description").getValue(String.class);
                    Event event = new Event(title,location,date,description);
                    list.add(event);
                }

                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnBack = findViewById(R.id.StudentEventBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void filterList(String newText) {
        ArrayList<Event> filteredList = new ArrayList<>();
        for(Event event : list) {
            if (event.getEventTitle().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(event);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No Events Found", Toast.LENGTH_SHORT).show();
        }else{
            myAdapter.setFilteredList(filteredList);
        }
    }

    private void setOnClickListener() {
        listener = new MyAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getApplicationContext(),StudentEvents.class);
                intent.putExtra("title",list.get(position).getEventTitle());
                intent.putExtra("location",list.get(position).getLocation());
                intent.putExtra("description",list.get(position).getDescription());
                intent.putExtra("date",list.get(position).getDate());
                startActivity(intent);
            }
        };
    }
}