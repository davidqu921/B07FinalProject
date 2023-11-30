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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class StudentComplaint extends AppCompatActivity {

    FirebaseDatabase db;
    String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_complaint);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");

        // get the current day and time and format string time
        Calendar c = Calendar.getInstance();
        java.util.Date date = c.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM, HH:mm", Locale.getDefault());
        time = dateFormat.format(date);
    }

    public void onClickSubmitComplaint(View view){
        DatabaseReference ref = db.getReference();
        EditText topic = (EditText) findViewById(R.id.editTextComplaintTopic);
        EditText complaint = (EditText) findViewById(R.id.editTextStudentComplaint);
        EditText edname = (EditText) findViewById(R.id.editTextComplaintStuName);
        String content = complaint.getText().toString();
        String topicStr = topic.getText().toString();
        String name = edname.getText().toString();

        // change empty name to "anonymous"
        if(name.isEmpty()){
            name = "anonymous";
        }

        if(topicStr.isEmpty() || content.isEmpty()){
            Toast.makeText(getApplicationContext(), "Unsuccessful. Please fill out required fields", Toast.LENGTH_LONG).show();
        }
        else {
            edname.setText("");
            complaint.setText("");
            topic.setText("");

            String complaintKey = ref.child("complaints").push().getKey();
            ref.child("complaints").child(complaintKey).child("topic").setValue(topicStr);
            ref.child("complaints").child(complaintKey).child("content").setValue(content);
            ref.child("complaints").child(complaintKey).child("name").setValue(name);
            ref.child("complaints").child(complaintKey).child("time").setValue(time);

            Toast.makeText(getApplicationContext(), "Complaint submitted !", Toast.LENGTH_LONG).show();
            // redirect to main dashboard
            Intent intent = new Intent(getApplicationContext(), StudentDashboard.class);
            startActivity(intent);
        }
    }

    public void onClickGoBackStudentDashBoard(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentDashboard.class);
        startActivity(intent);
    }
}