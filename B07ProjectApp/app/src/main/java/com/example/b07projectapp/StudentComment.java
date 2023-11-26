package com.example.b07projectapp;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        //String student = getIntent().getStringExtra("student");
        String username = getIntent().getStringExtra("stu");
        String admin = getIntent().getStringExtra("username");
        //makeText(StudentComment.this, student, LENGTH_SHORT).show();
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
            //cmnt.setText("");
            RatingBar date = findViewById(R.id.editTextNumber);
            float stars = date.getNumStars();
            //date.setText("");
            //makeText(StudentComment.this, TitleStr, LENGTH_SHORT).show();
            if (stars > 5 || stars <1) {
                makeText(StudentComment.this, "Rating must be a number between 1 and 5", LENGTH_SHORT).show();

            }
            else {
            if(cmntStr.isEmpty()){
                makeText(StudentComment.this, "Fill In All Empty Fields", LENGTH_SHORT).show();
            }
            else {
                String pathway = username+cmntStr;
                if (pathway.isEmpty())
                    makeText(StudentComment.this, "Comment Already Submitted", LENGTH_SHORT).show();
                else if (admin == null) {

                    ref.child("event").child(TitleStr).child("comment").child(pathway).child("review").setValue(cmntStr);
                    ref.child("event").child(TitleStr).child("comment").child(pathway).child("rating").setValue(stars);
                    ref.child("event").child(TitleStr).child("comment").child(pathway).child("username").setValue(stars);
                } else {
                    pathway = admin+cmntStr;
                    ref.child("event").child(TitleStr).child("comment").child(pathway).child("review").setValue(cmntStr);
                    ref.child("event").child(TitleStr).child("comment").child(pathway).child("rating").setValue(stars);
                    ref.child("event").child(TitleStr).child("comment").child(pathway).child("username").setValue(stars);
                }
                makeText(StudentComment.this, "Comment Submitted", LENGTH_SHORT).show();
            }
            }
        }
    }

    public void onClickGoBackStudentDashBoard(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentEvents.class);
        startActivity(intent);
    }
}