package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentComment extends AppCompatActivity {
    FirebaseDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_comment);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }
    public void onClickSubmitComplaint(View view){
        DatabaseReference ref = db.getReference();
        EditText complaint = (EditText) findViewById(R.id.editTextStudentComment);
        String content = complaint.getText().toString();
        complaint.setText("");

        String commentKey = ref.child("Comments").push().getKey();
        ref.child("Comments").child(commentKey).child("content").setValue(content);
    }

    public void onClickGoBackStudentDashBoard(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentEvents.class);
        startActivity(intent);
    }
}