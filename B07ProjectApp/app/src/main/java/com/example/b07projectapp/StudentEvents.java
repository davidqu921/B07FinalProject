package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_events);
    }
    public void onClickAddComments(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentComment.class);
        startActivity(intent);
    }


    public void readNext(){
        //Create references
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView7 = findViewById(R.id.textView7);
    }
}