package com.example.b07projectapp;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

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
        if(getIntent().getBooleanExtra("joined", false)) {
            Intent intent = new Intent(getApplicationContext(), StudentComment.class);
            String eventStr = getIntent().getStringExtra("Event");
            intent.putExtra("Event", eventStr);
            String sStr = getIntent().getStringExtra("stu");
            intent.putExtra("stu", sStr);
            intent.putExtra("student", getIntent().getStringExtra("student"));
            if (getIntent().getStringExtra("username") != null) {
                String user = getIntent().getStringExtra("username");
                intent.putExtra("username", user);
            }
            startActivity(intent);
        }
        else makeText(this, "You must join the event before leaving a review", LENGTH_SHORT).show();
    }
    public void onClickGoBack (View view){
        onBackPressed();
    }
}