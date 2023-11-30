package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PostsRequireOutsideCMS extends AppCompatActivity {
    Button yes4Btn, no4Btn, back5Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require_outside_cms);
        yes4Btn = findViewById(R.id.yes4Btn);
        no4Btn = findViewById(R.id.no4Btn);
        back5Btn = (Button) findViewById(R.id.back5Btn);
        back5Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentDashboard();
            }
        });

        yes4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireOutsideCMS.this, "Congratulations, You've met the requirements!", Toast.LENGTH_SHORT).show();
            }
        });
        no4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireOutsideCMS.this, "Sorry, You've not met the requirements.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openStudentDashboard(){
        onBackPressed();
    }
}