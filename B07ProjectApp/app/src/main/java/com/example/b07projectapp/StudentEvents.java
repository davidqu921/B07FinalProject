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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentEvents extends AppCompatActivity {
    //String title;
    FirebaseDatabase fire = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    private String eventStr;
    int limit = 0;
    boolean joined = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sStr = getIntent().getStringExtra("student");
        setContentView(R.layout.activity_student_events);
        TextView Title = findViewById(R.id.textView5);
        TextView desc = findViewById(R.id.textView7);
        TextView loc = findViewById(R.id.textView9);
        TextView date = findViewById(R.id.textView17);
        TextView limits = findViewById(R.id.textView15);
        TextView rating = findViewById(R.id.textView12);
        Button join = findViewById(R.id.button21);
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
                    limits.setText(String.valueOf( ds.child("limit").getValue(Integer.class)));
                    RatingBar ct = findViewById(R.id.ratingBar);
                    ct.setRating(0);
                    rating.setText(" None");
                    join.setText("Join Event");
                    if(ds.hasChild("comment")) {
                        event.child(ds.getKey()).child("comment").addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                int cRating = 0;
                                float sum = 0;
                                for (DataSnapshot dat: snapshot.getChildren()){
                                    if (dat.hasChild("rating")) {
                                        sum +=(dat.child("rating").getValue(Integer.class));

                                        //makeText(StudentEvents.this, String.valueOf(sum), LENGTH_SHORT).show();
                                        cRating++;
                                    }
                                }
                                float mean = sum / cRating;
                                rating.setText("  " + cRating + " ratings");
                                ct.setRating(mean);
                            }
                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                            }
                        });
                    }
                    joined = false;
                    if(ds.hasChild("participants"))
                        if(ds.child("participants").hasChild(sStr)) {
                            join.setText("Remove Participation");
                            joined = true;
                        }

                    else
                            join.setText("Join Event");
                    //ds.child("")
                    eventStr = ds.getKey();
                    break;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

    private int c = 1;
    public void onClickNext(View view) {

        String sStr = getIntent().getStringExtra("student");

        TextView Title = findViewById(R.id.textView5);
        TextView desc = findViewById(R.id.textView7);
        TextView loc = findViewById(R.id.textView9);
        TextView date = findViewById(R.id.textView17);
        Button join = findViewById(R.id.button21);
        TextView limits = findViewById(R.id.textView15);
        TextView rating = findViewById(R.id.textView12);
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


                    counter++;
                    if(counter>=c) {
                        Title.setText(ds.getKey ());
                        desc.setText(ds.child("description").getValue(String.class));
                        loc.setText(ds.child("location").getValue(String.class));
                        date.setText(ds.child("date").getValue(String.class));
                        limits.setText(String.valueOf(ds.child("limit").getValue(Integer.class)));
                        RatingBar ct = findViewById(R.id.ratingBar);
                        ct.setRating(0);
                        rating.setText(" None");
                        join.setText("Join Event");
                        if(ds.hasChild("comment")) {
                            event.child(ds.getKey()).child("comment").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    int cRating = 0;
                                    float sum = 0;
                                    for (DataSnapshot dat: snapshot.getChildren()){
                                        if (dat.hasChild("rating")) {
                                            sum +=(dat.child("rating").getValue(Integer.class));
                                            cRating++;
                                        }
                                    }
                                    float mean = sum / cRating;
                                    rating.setText("  " + cRating + " ratings");
                                    ct.setRating(mean);
                                }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                    }
                                });
                        }
                        joined = false;
                        if(sStr != null && ds.hasChild("participants"))
                            if( ds.child("participants").hasChild(sStr)) {
                                join.setText("Remove Participation");
                                joined = true;
                            }
                            else
                                join.setText("Join Event");
                        eventStr = ds.getKey();
                        break;
                    }
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
            String sStr = getIntent().getStringExtra("student");
            TextView Title = findViewById(R.id.textView5);
            TextView desc = findViewById(R.id.textView7);
            TextView loc = findViewById(R.id.textView9);
            TextView limits = findViewById(R.id.textView15);
            TextView date = findViewById(R.id.textView17);
            Button join = findViewById(R.id.button21);
            TextView rating = findViewById(R.id.textView12);
            DatabaseReference event = fire.getReference("event");
            if (c > 1)
                c--;
            event.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    int counter = 0;
                    for (DataSnapshot ds : snapshot.getChildren()) {



                        counter++;
                        if (counter >= c){
                            Title.setText(ds.getKey ());
                            desc.setText(ds.child("description").getValue(String.class));
                            loc.setText(ds.child("location").getValue(String.class));
                            date.setText(ds.child("date").getValue(String.class));
                            limits.setText(String.valueOf(ds.child("limit").getValue(Integer.class)));
                            RatingBar ct = findViewById(R.id.ratingBar);
                            ct.setRating(0);
                            join.setText("Join Event");
                            rating.setText(" None");
                            if(ds.hasChild("comment")) {
                                event.child(ds.getKey()).child("comment").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        int cRating = 0;
                                        float sum = 0;
                                        for (DataSnapshot dat: snapshot.getChildren()){
                                            if (dat.hasChild("rating")) {
                                                sum +=(dat.child("rating").getValue(Integer.class));
                                                cRating++;
                                            }
                                        }
                                        float mean = sum / cRating;
                                        rating.setText("  " + cRating + " ratings");
                                        ct.setRating(mean);
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                    }
                                });
                            }
                            if(sStr != null && ds.hasChild("participants"))
                                if(ds.child("participants").hasChild(sStr)) {
                                    join.setText("Remove Participation");
                                    joined = true;
                                }
                            eventStr = ds.getKey();
                            break;
                        }
                    }
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
    }
    public void onClickAddComments(View view) {
        Intent intent = new Intent(getApplicationContext(), ViewComments.class);
        String sStr = getIntent().getStringExtra("student");
        intent.putExtra("student", sStr);
        intent.putExtra("Event", eventStr);
        if (getIntent().getStringExtra("username") != null) {
            String user = getIntent().getStringExtra("username");
            intent.putExtra("username", user);
        }
        //makeText(StudentEvents.this, eventStr, LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void onClickJoin(View view){
        DatabaseReference ref = fire.getReference();
        if (getIntent().getStringExtra("student") == null)
            makeText(StudentEvents.this, "SignIn as Student First", LENGTH_SHORT).show();
        else{
                String sStr = getIntent().getStringExtra("student");
                ref.child("event").child(eventStr).child("participants").child(sStr).child("name").setValue(sStr);
                if (!joined)
                    makeText(StudentEvents.this, "Event Joined!", LENGTH_SHORT).show();
                else {
                    ref.child("event").child(eventStr).child("participants").child(sStr).child("name").removeValue();
                    makeText(StudentEvents.this, "You are no longer attending the event", LENGTH_SHORT).show();

                }
        }
    }
}