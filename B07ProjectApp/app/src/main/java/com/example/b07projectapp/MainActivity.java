package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStudentSignUp(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUpStudent.class);
        startActivity(intent);
    }

    public void onClickStudentDashBoard(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentDashboard.class);
        startActivity(intent);
    }

//    public void onClickAdminSignUp(View view) {
//        Intent intent = new Intent(getApplicationContext(), SignUpAdmin.class);
//        startActivity(intent);
//    }
}