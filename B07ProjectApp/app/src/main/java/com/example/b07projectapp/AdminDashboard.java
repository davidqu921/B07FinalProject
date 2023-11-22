package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
    }

    public void onClickAdminComplaintView(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminComplaintView.class);
        startActivity(intent);
    }

    public void onClickViewEvent(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentEvents.class);
        if (getIntent().getStringExtra("username") != null) {
            String user = getIntent().getStringExtra("username");
            intent.putExtra("username", user);
        }
        startActivity(intent);
    }

    public void onClickAddEvent(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminAddEvent.class);
        if (getIntent().getStringExtra("username") != null) {
            String user = getIntent().getStringExtra("username");
            intent.putExtra("username", user);
        }
        startActivity(intent);
    }
}