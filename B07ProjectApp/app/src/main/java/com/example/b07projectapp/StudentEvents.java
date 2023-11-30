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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StudentEvents extends AppCompatActivity {
    //String title;
    FirebaseDatabase fire = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    DatabaseReference event = fire.getReference("event");
    private String eventStr;
    int limit = 0;
    boolean joined = false;
    private int c = 1;
    private int x = c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int counter = getIntent().getIntExtra("counter", 0);
        setContentView(R.layout.activity_student_events);
        TextView Title = findViewById(R.id.textView5);
        TextView desc = findViewById(R.id.textView7);
        TextView loc = findViewById(R.id.textView9);
        TextView date = findViewById(R.id.textView17);
        TextView limits = findViewById(R.id.textView15);
        TextView rating = findViewById(R.id.textView12);
        Button join = findViewById(R.id.button21);

        event.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds: snapshot.getChildren())
                    limit++;
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        event.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String sStr = getIntent().getStringExtra("username");
                if (sStr == null)
                    sStr = getIntent().getStringExtra("student");
                int counting = 0;
                for (DataSnapshot ds: snapshot.getChildren()) {
                    if (counting == counter) {
                        c = counter+1;
                        Title.setText(ds.getKey ());
                        desc.setText(ds.child("description").getValue(String.class));
                        loc.setText(ds.child("location").getValue(String.class));
                        date.setText(ds.child("date").getValue(String.class));
                        limits.setText(String.valueOf( ds.child("limit").getValue(Integer.class)));
                        RatingBar ct = findViewById(R.id.ratingBar);
                        limitCheck(ds.getKey());
                        rating.setText(" None");
                        join.setText("Join Event");
                        joined = true;

                        String Username = getIntent().getStringExtra("stu");
                        if (Username != null) {
                            if (ds.hasChild("participants"))

                                if (ds.child("participants").hasChild(Username)) {
                                    join.setText("Remove Participation");
                                    joined = true;
                                } else {
                                    join.setText("Join Event");
                                    joined = false;
                                }
                        }
                        eventStr = ds.getKey();
                        if(ds.hasChild("comment")) {
                            event.child(ds.getKey()).child("comment").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    int cRating = 0;
                                    float sum = 0;
                                    for (DataSnapshot dat: snapshot.getChildren()){
                                        if (dat.hasChild("rating")) {
                                            if (dat.child("rating").getValue(Integer.class) == 0)
                                                continue;
                                            sum +=(dat.child("rating").getValue(Integer.class));
                                            //makeText(StudentEvents.this, String.valueOf(sum), LENGTH_SHORT).show();
                                            cRating++;
                                        }else
                                            ct.setRating(0);
                                    }
                                    if (cRating > 0) {
                                        float mean = sum / cRating;
                                        //makeText(StudentEvents.this, String.valueOf(mean), LENGTH_SHORT).show();
                                        ct.setRating(mean);
                                    }else {
                                        ct.setRating(0);

                                    }

                                    rating.setText("  " + cRating + " ratings");
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                }
                            });
                        }
                        else {
                            ct.setRating((float) 0);
                            //makeText(StudentEvents.this, String.valueOf(0), LENGTH_SHORT).show();
                        }
                        break;
                    }
                    else
                        counting++;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }


    public void onClickNext(View view) {

        //String sStr = getIntent().getStringExtra("student");

        TextView Title = findViewById(R.id.textView5);
        TextView desc = findViewById(R.id.textView7);
        TextView loc = findViewById(R.id.textView9);
        TextView date = findViewById(R.id.textView17);
        Button join = findViewById(R.id.button21);
        TextView limits = findViewById(R.id.textView15);
        TextView rating = findViewById(R.id.textView12);
        if(c<limit){
            c++;
            x=c;
        }
        else
            makeText(StudentEvents.this, "End Reached", LENGTH_SHORT).show();
        event.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String sStr = getIntent().getStringExtra("username");
                if (sStr == null)
                    sStr = getIntent().getStringExtra("student");
                int counter = 0;
                for (DataSnapshot ds: snapshot.getChildren()) {

                    c=x;
                    counter++;
                    if(counter>=c) {
                        Title.setText(ds.getKey ());
                        desc.setText(ds.child("description").getValue(String.class));
                        loc.setText(ds.child("location").getValue(String.class));
                        date.setText(ds.child("date").getValue(String.class));
                        limits.setText(String.valueOf(ds.child("limit").getValue(Integer.class)));
                        limitCheck(ds.getKey());
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
                                    ct.setRating(0);
                                    for (DataSnapshot dat: snapshot.getChildren()){
                                        if (dat.hasChild("rating")) {
                                            if (dat.child("rating").getValue(Integer.class) == 0)
                                                continue;
                                            sum +=(dat.child("rating").getValue(Integer.class));
                                            cRating++;
                                        }
                                    }
                                    if (cRating > 0) {
                                        float mean = sum / cRating;
                                        rating.setText("  " + cRating + " ratings");
                                        ct.setRating(mean);
                                    }
                                    else
                                        ct.setRating(0);
                                }
                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                }
                            });
                        }
                        joined = true;
                        String Username = getIntent().getStringExtra("stu");
                        if(Username != null && sStr != null && ds.hasChild("participants"))
                            if( ds.child("participants").hasChild(Username)) {
                                join.setText("Remove Participation");
                                joined = true;
                            }
                            else {
                                c=x;
                                joined = false;
                            }
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
            if (c > 1) {
                c--;
                x=c;
            }

            event.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String sStr = getIntent().getStringExtra("username");
                    if (sStr == null)
                        sStr = getIntent().getStringExtra("student");
                    int counter = 0;
                    for (DataSnapshot ds : snapshot.getChildren()) {

                        c=x;

                        counter++;
                        if (counter >= c){
                            String evnt = ds.getKey();
                            Title.setText(ds.getKey ());
                            desc.setText(ds.child("description").getValue(String.class));
                            loc.setText(ds.child("location").getValue(String.class));
                            date.setText(ds.child("date").getValue(String.class));
                            limits.setText(String.valueOf(ds.child("limit").getValue(Integer.class)));
                            RatingBar ct = findViewById(R.id.ratingBar);
                            limitCheck(ds.getKey());
                            ct.setRating(0);
                            join.setText("Join Event");
                            rating.setText(" None");
                            if(ds.hasChild("comment")) {
                                event.child(evnt).child("comment").addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                                        ct.setRating(0);
                                        int cRating = 0;
                                        float sum = 0;
                                        for (DataSnapshot dat: snapshot.getChildren()){
                                            if (dat.hasChild("rating")) {
                                                if (dat.child("rating").getValue(Integer.class) == 0)
                                                    continue;
                                                sum +=(dat.child("rating").getValue(Integer.class));
                                                cRating++;
                                                ct.setRating(0);
                                            }
                                        }
                                        float mean = sum / cRating;
                                        rating.setText("  " + cRating + " ratings");
                                        ct.setRating(mean);
                                        return;
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError error) {
                                    }
                                });
                            }
                            String Username = getIntent().getStringExtra("stu");
                            if(Username != null && sStr != null && ds.hasChild("participants")) {
                                if (ds.child("participants").hasChild(Username)) {
                                    join.setText("Remove Participation");
                                    joined = true;
                                }
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
        intent.putExtra("joined", joined);
        intent.putExtra("student", getIntent().getStringExtra("student"));
        if (getIntent().getStringExtra("username") != null) {
            String user = getIntent().getStringExtra("username");
            intent.putExtra("username", user);
        }

        if (getIntent().getStringExtra("stu") != null) {
            String stStr = getIntent().getStringExtra("stu");
            intent.putExtra("stu", stStr);
        }
        //makeText(StudentEvents.this, eventStr, LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void onClickJoin(View view){
        DatabaseReference ref = fire.getReference();
        if (getIntent().getStringExtra("student") == null)
            makeText(StudentEvents.this, "Sign In as Student First", LENGTH_SHORT).show();
        else{
            String sStr = getIntent().getStringExtra("student");
            String Username = getIntent().getStringExtra("stu");
            ref.child("event").child(eventStr).child("participants").child(Username).child("name").setValue(sStr);
            if (!joined)
                makeText(StudentEvents.this, "Event Joined!", LENGTH_SHORT).show();
            else {
                ref.child("event").child(eventStr).child("participants").child(Username).child("name").removeValue();
                makeText(StudentEvents.this, "You are no longer attending the event", LENGTH_SHORT).show();

            }
        }
    }

    public void onClickParticipants(View view){
        Intent i = new Intent(getApplicationContext(), Admin_View_Participants.class);
        i.putExtra("eventx", eventStr);
        startActivity(i);
    }

    public void limitCheck(String evented){
        TextView limits = findViewById(R.id.textView15);
        String lim = (String) limits.getText();
        TextView Title = findViewById(R.id.textView5);
        DatabaseReference events = event.child(evented);
        events.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int index = 0 ;
                if(!snapshot.hasChild("participants"));
                else {
                    for (DataSnapshot ds : snapshot.child("participants").getChildren()) {
                        index++;
                    }
                }
                limits.setText(String.valueOf(index)+"/"+lim);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void onClickGoBack (View view){
        onBackPressed();
    }

}