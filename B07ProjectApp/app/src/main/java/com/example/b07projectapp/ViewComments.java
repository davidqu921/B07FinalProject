package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewComments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_comments);
    }
    public void onClickAddComments(View view) {
        Intent intent = new Intent(getApplicationContext(), StudentComment.class);
        String eventStr = getIntent().getStringExtra("Event");
        intent.putExtra("Event", eventStr);
        String sStr = getIntent().getStringExtra("stu");
        intent.putExtra("stu", sStr);
        if (getIntent().getStringExtra("username") != null) {
            String user = getIntent().getStringExtra("username");
            intent.putExtra("username", user);
        }
        startActivity(intent);
    }
}