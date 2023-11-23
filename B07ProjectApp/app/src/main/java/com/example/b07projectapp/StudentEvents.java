package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StudentEvents extends AppCompatActivity {
    FirebaseDatabase fire = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_events);
        DatabaseReference dref = fire.getReference();

    }
    public void onClickAddComments(View view) {
        Intent intent = new Intent(getApplicationContext(), ViewComments.class);
        //intent.putExtra("Event", eventTitle);

        startActivity(intent);
    }


    public void readNext(){
        //Create references
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView7 = findViewById(R.id.textView7);
    }
}