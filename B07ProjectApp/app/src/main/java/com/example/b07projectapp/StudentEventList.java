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
import android.widget.SearchView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class StudentEventList extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com");
    EventsAdapter eventsAdapter;
    ArrayList<Event> list;
    Button btnBack;
    EventsAdapter.RecyclerViewClickListener listener;
    String searchCheckString;

    SearchView searchView;

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
                searchCheckString = newText;
                filterList(newText);
                return true;
            }
        });

        recyclerView = findViewById(R.id.StudentEventList);

        DatabaseReference ref = db.getReference();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        setOnClickListener();
        eventsAdapter = new EventsAdapter(this,list,listener);
        recyclerView.setAdapter(eventsAdapter);

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
                eventsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        btnBack = findViewById(R.id.StudentEventBack);
        btnBack.setOnClickListener(v -> onBackPressed());
    }
    private void filterList(String newText) {
        ArrayList<Event> filteredList = new ArrayList<>();
        for(Event event : list) {
            if (event.getEventTitle().toLowerCase().contains(newText.toLowerCase())) {
                filteredList.add(event);
            }
        }
        if (!filteredList.isEmpty()) {
            eventsAdapter.setFilteredList(filteredList);
        }
    }

    private void  filterList(String newText, ArrayList<Event> lst) {
        for(Event event : list) {
            if (event.getEventTitle().toLowerCase().contains(newText.toLowerCase())) {
                lst.add(event);
            }
        }
    }

    private void setOnClickListener() {
        listener = new EventsAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                ArrayList<Event> lists = new ArrayList<>();
                if (searchCheckString == null)
                    lists = list;
                else
                    filterList(searchCheckString, lists);
                if(lists.isEmpty())
                    makeText(getApplicationContext(), "No Events with " + searchCheckString, LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(getApplicationContext(), StudentEvents.class);
                    intent.putExtra("student", getIntent().getStringExtra("student"));
                    intent.putExtra("title", lists.get(position).getEventTitle());
                    if (getIntent().getStringExtra("studentUsername") != null) {
                        String stStr = getIntent().getStringExtra("studentUsername");
                        intent.putExtra("studentUsername", stStr);
                    }
                    if (getIntent().getStringExtra("username") != null) {
                        String user = getIntent().getStringExtra("username");
                        intent.putExtra("username", user);
                    }
                    startActivity(intent);
                }
            }
        };
    }
}
