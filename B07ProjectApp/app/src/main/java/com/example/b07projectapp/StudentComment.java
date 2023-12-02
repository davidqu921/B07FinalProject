package com.example.b07projectapp;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentComment extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_comment);
        String TitleStr = getIntent().getStringExtra("Event");
        TextView Title = findViewById(R.id.textView11);
        Title.setText(TitleStr);
    }
    public void onClickSubmitComment(View view){
        String username = getIntent().getStringExtra("studentUsername");
        String admin = getIntent().getStringExtra("username");
        if (username == null && admin == null) {
            makeText(StudentComment.this, "Log In First", LENGTH_SHORT).show();
            startActivity(new Intent(StudentComment.this, MainActivity.class));
        }
        else {
           String TitleStr = getIntent().getStringExtra("Event");
            if(TitleStr == null){
                makeText(StudentComment.this, "Something went wrong", LENGTH_SHORT).show();
                startActivity(new Intent(StudentComment.this, MainActivity.class));
            }

            DatabaseReference ref = db.getReference();
            EditText cmnt = findViewById(R.id.editTextStudentComment);
            String cmntStr = cmnt.getText().toString();
            RatingBar star = findViewById(R.id.editTextNumber);
            float stars = star.getRating();
            String pathway, name;
            if(admin == null){
                pathway = username + cmntStr;
                name = username;
            }
            else {
                pathway = admin + cmntStr;
                name = admin;
            }
            if(cmntStr.isEmpty()) {
                makeText(StudentComment.this, "Fill In All Empty Fields", LENGTH_SHORT).show();
            }
            else {
                ref.child("event").child(TitleStr).child("comment").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int rating =0;
                        if (0.0==stars);
                        else if(stars <= 1.0)
                            rating = 1;
                        else if (stars <= 2.0)
                            rating = 2;
                        else if (stars <= 3.0)
                            rating = 3;
                        else if (stars <= 4.0)
                            rating = 4;
                        else if (stars <= 5.0)
                            rating = 5;
                        boolean found = false;
                        for (DataSnapshot ds : snapshot.getChildren()) {
                            if (ds.getKey().equals(pathway)) {
                                found = true;
                                break;
                            }
                        }
                        if (found)
                            makeText(StudentComment.this, "Comment Already Submitted", LENGTH_SHORT).show();
                        else {
                            ref.child("event").child(TitleStr).child("comment").child(pathway).child("review").setValue(cmntStr);
                            ref.child("event").child(TitleStr).child("comment").child(pathway).child("rating").setValue(Integer.valueOf(String.valueOf(rating)));
                            ref.child("event").child(TitleStr).child("comment").child(pathway).child("username").setValue(name);
                            makeText(StudentComment.this, "Comment Submitted", LENGTH_SHORT).show();
                            star.setRating(0);
                            cmnt.setText("");
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        }
    }
    public void onClickGoBack(View view) {
        onBackPressed();
    }
}