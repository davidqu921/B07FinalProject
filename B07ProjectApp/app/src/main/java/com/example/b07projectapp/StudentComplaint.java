package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import android.os.Bundle;

public class StudentComplaint extends AppCompatActivity {

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_complaint);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }

    public void onClickSubmitComplaint(View view){
        DatabaseReference ref = db.getReference();
        EditText topic = (EditText) findViewById(R.id.editTextComplaintTopic);
        EditText complaint = (EditText) findViewById(R.id.editTextStudentComplaint);
        String content = complaint.getText().toString();
        String topicStr = topic.getText().toString();
        complaint.setText("");
        topic.setText("");

        String complaintKey = ref.child("complaints").push().getKey();
        ref.child("complaints").child(complaintKey).child("topic").setValue(topicStr);
        ref.child("complaints").child(complaintKey).child("content").setValue(content);
    }

    public void onClickGoBackStudentDashBoard(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentDashboard.class);
        startActivity(intent);
    }
}