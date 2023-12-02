package com.example.b07projectapp;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentEvents extends AppCompatActivity {

    FirebaseDatabase fire = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    DatabaseReference event = fire.getReference("event");
    private String eventStr;
    boolean joined = false;
    private int lim;
    private String eventAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //int counter = getIntent().getIntExtra("counter", 0);
        setContentView(R.layout.activity_student_events);
        TextView Title = findViewById(R.id.textView5);
        TextView desc = findViewById(R.id.textView7);
        TextView location = findViewById(R.id.textView9);
        TextView date = findViewById(R.id.textView17);
        TextView limits = findViewById(R.id.textView15);
        TextView rating = findViewById(R.id.textView12);
        Button join = findViewById(R.id.button21);
        event.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String sStr = getIntent().getStringExtra("username");
                if (sStr == null)
                    sStr = getIntent().getStringExtra("student");
                for (DataSnapshot ds : snapshot.getChildren()) {
                    if (ds.getKey().equals(getIntent().getStringExtra("title"))) {
                        eventAuthor = ds.child("poster").getValue(String.class);
                        lim = ds.child("limit").getValue(Integer.class);
                        Title.setText(ds.getKey());
                        desc.setText(ds.child("description").getValue(String.class));
                        location.setText(ds.child("location").getValue(String.class));
                        date.setText(ds.child("date").getValue(String.class));
                        limits.setText(String.valueOf(lim));
                        RatingBar ratingSet = findViewById(R.id.ratingBar);
                        limitCheck(ds.getKey());
                        rating.setText(" None");
                        join.setText("Join Event");
                        String Username = getIntent().getStringExtra("studentUsername");
                        if (Username != null) {
                            if (ds.child("participants").hasChild(Username)) {
                                join.setText("Remove Participation");
                                joined = true;
                            } else {
                                join.setText("Join Event");
                                joined = false;
                            }
                        }
                        eventStr = ds.getKey();
                        if (ds.hasChild("comment")) {
                            event.child(ds.getKey()).child("comment").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    int countRating = 0;
                                    float sum = 0;
                                    for (DataSnapshot dat : snapshot.getChildren()) {
                                        if (dat.hasChild("rating")) {
                                            if (dat.child("rating").getValue(Integer.class) == 0)
                                                continue;
                                            sum += (dat.child("rating").getValue(Integer.class));
                                            countRating++;
                                        } else
                                            ratingSet.setRating(0);
                                    }
                                    if (countRating > 0) {
                                        float mean = sum / countRating;
                                        ratingSet.setRating(mean);
                                    } else {
                                        ratingSet.setRating(0);

                                    }

                                    rating.setText("  " + countRating + " ratings");
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                }
                            });
                        } else {
                            ratingSet.setRating((float) 0);
                        }
                        break;
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void onClickAddComments(View view) {
        String username = getIntent().getStringExtra("username");
        String sStr = getIntent().getStringExtra("student");
        if (eventAuthor.equals(username) || sStr != null) {
            Intent intent = new Intent(getApplicationContext(), ViewComments.class);
            boolean adminComment = false;
            intent.putExtra("student", sStr);
            intent.putExtra("Event", eventStr);
            intent.putExtra("student", getIntent().getStringExtra("student"));
            if (getIntent().getStringExtra("username") != null) {
                intent.putExtra("username", username);
                adminComment = true;
            }
            if (adminComment) {
                intent.putExtra("joined", true);
            } else intent.putExtra("joined", joined);
            if (getIntent().getStringExtra("studentUsername") != null) {
                String stStr = getIntent().getStringExtra("studentUsername");
                intent.putExtra("studentUsername", stStr);
            }
            startActivity(intent);
        }
        else
            makeText(StudentEvents.this, "You must be the poster of this event to see comments", Toast.LENGTH_LONG).show();
    }
    public void onClickJoin(View view) {
        if (getIntent().getStringExtra("student") == null)
            makeText(StudentEvents.this, "Sign In as Student First", LENGTH_SHORT).show();
        else {
            DatabaseReference ref = fire.getReference();
            ref.child("event").child(eventStr).child("participants").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    int numberOfParticipants = 0;
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        numberOfParticipants++;
                    }
                    String sStr = getIntent().getStringExtra("student");
                    String Username = getIntent().getStringExtra("studentUsername");
                    if (lim > numberOfParticipants && !joined) {
                        ref.child("event").child(eventStr).child("participants").child(Username).child("name").setValue(sStr);
                        makeText(StudentEvents.this, "Event Joined!", LENGTH_SHORT).show();
                    } else if (joined) {
                        ref.child("event").child(eventStr).child("participants").child(Username).child("name").removeValue();
                        makeText(StudentEvents.this, "You are no longer attending the event", LENGTH_SHORT).show();
                    } else makeText(StudentEvents.this, "No Spots Left", LENGTH_SHORT).show();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    }

    public void onClickParticipants(View view) {
        String user = getIntent().getStringExtra("username");
        if (eventAuthor.equals(user)) {
            Intent i = new Intent(getApplicationContext(), Admin_View_Participants.class);
            i.putExtra("eventNameStr", eventStr);
            startActivity(i);
        }else
            makeText(StudentEvents.this, "You must be the poster of this event to see participants", Toast.LENGTH_LONG).show();
    }

    public void limitCheck(String evented) {
        TextView limits = findViewById(R.id.textView15);
        String lim = (String) limits.getText();
        //TextView Title = findViewById(R.id.textView5);
        DatabaseReference events = event.child(evented);
        events.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int index = 0;
                if (!snapshot.hasChild("participants")) ;
                else {
                    for (DataSnapshot ds : snapshot.child("participants").getChildren()) {
                        index++;
                    }
                }
                limits.setText(String.valueOf(index) + "/" + lim);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void onClickGoBack(View view) {
        onBackPressed();
    }
}