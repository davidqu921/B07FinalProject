package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PostsRequireMinor extends AppCompatActivity {
    Button yes1Btn, no1Btn, back2Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require_minor);
        yes1Btn = findViewById(R.id.yes1Btn);
        no1Btn = findViewById(R.id.no1Btn);
        back2Btn = (Button) findViewById(R.id.back2Btn);
        back2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentDashboard();
            }
        });

        yes1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireMinor.this, "Congratulations, You've met the requirements!", Toast.LENGTH_SHORT).show();
            }
        });
        no1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireMinor.this, "Sorry, You've not met the requirements.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openStudentDashboard(){
        onBackPressed();
    }

}