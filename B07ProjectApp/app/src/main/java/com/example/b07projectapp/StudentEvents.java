package com.example.b07projectapp;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentEvents extends AppCompatActivity {
    //String title;
    FirebaseDatabase fire = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");

    int limit = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_events);
        TextView Title = findViewById(R.id.textView5);
        TextView desc = findViewById(R.id.textView7);
        TextView loc = findViewById(R.id.textView9);
        TextView date = findViewById(R.id.textView17);
        DatabaseReference event = fire.getReference("event");
        event.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren()) {
                    limit++;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        event.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren()) {
                    Title.setText(ds.getKey ());
                    desc.setText(ds.child("description").getValue(String.class));
                    loc.setText(ds.child("location").getValue(String.class));
                    date.setText(ds.child("date").getValue(String.class));
                    break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }
    public void onClickAddComments(View view) {
        Intent intent = new Intent(getApplicationContext(), ViewComments.class);
        //intent.putExtra("Event", eventTitle);
        startActivity(intent);
    }
    private int c = 1;
    public void onClickNext(View view) {
        TextView Title = findViewById(R.id.textView5);
        TextView desc = findViewById(R.id.textView7);
        TextView loc = findViewById(R.id.textView9);
        TextView date = findViewById(R.id.textView17);
        DatabaseReference event = fire.getReference("event");
        if(c<limit)
            c++;
        else
            makeText(StudentEvents.this, "End Reached", LENGTH_SHORT).show();
        event.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int counter = 0;
                for (DataSnapshot ds: snapshot.getChildren()) {
                    Title.setText(ds.getKey ());
                    desc.setText(ds.child("description").getValue(String.class));
                    loc.setText(ds.child("location").getValue(String.class));
                    date.setText(ds.child("date").getValue(String.class));

                    counter++;
                    if(counter>=c)
                        break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void onClickPast(View view) {
        if (c == 1) {
            makeText(StudentEvents.this, "End Reached", LENGTH_SHORT).show();
        }
        else {
            TextView Title = findViewById(R.id.textView5);
            TextView desc = findViewById(R.id.textView7);
            TextView loc = findViewById(R.id.textView9);
            TextView date = findViewById(R.id.textView17);
            DatabaseReference event = fire.getReference("event");
            if (c > 1)
                c--;
            event.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    int counter = 0;
                    for (DataSnapshot ds : snapshot.getChildren()) {

                        Title.setText(ds.getKey ());
                        desc.setText(ds.child("description").getValue(String.class));
                        loc.setText(ds.child("location").getValue(String.class));
                        date.setText(ds.child("date").getValue(String.class));
                        counter++;
                        if (counter >= c)
                            break;
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    }
}