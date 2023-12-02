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
        Intent intent = new Intent(getApplicationContext(), AdminViewComplaint.class);
        startActivity(intent);
    }
    public void onClickViewEvent(View view) {
        Intent i = new Intent(getApplicationContext(), StudentEventList.class);
        if (getIntent().getStringExtra("username") != null) {
            String user = getIntent().getStringExtra("username");
            i.putExtra("username", user);
        }
        startActivity(i);
    }
    public void onClickAddEvent(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminAddEvent.class);
        String user = getIntent().getStringExtra("username");
        intent.putExtra("username", user);
        startActivity(intent);
    }
    public void onClickAnnouncement(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminViewAnnouncement.class);
        startActivity(intent);
    }

    public void onClickAdminSignOut(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);

        //set the name of admin to be empty
        LoggedInAdmin.getInstance().setName("");

        startActivity(intent);
    }
    public void onClickViewMyEvent(View view) {
        Intent i = new Intent(getApplicationContext(), Admin_My_Events.class);
        if (getIntent().getStringExtra("username") != null) {
            String user = getIntent().getStringExtra("username");
            i.putExtra("username", user);
        }
        startActivity(i);
    }
}