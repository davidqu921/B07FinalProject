package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PostsRequireInsideCMS extends AppCompatActivity {
    Button yes3Btn, no3Btn, back4Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require_inside_cms);
        yes3Btn = findViewById(R.id.yes3Btn);
        no3Btn = findViewById(R.id.no3Btn);
        back4Btn = (Button) findViewById(R.id.back4Btn);
        back4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentDashboard();
            }
        });

        yes3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireInsideCMS.this, "Congratulations, You've met the requirements!", Toast.LENGTH_SHORT).show();
            }
        });
        no3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireInsideCMS.this, "Sorry, You've not met the requirements.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openStudentDashboard(){
        Intent intent = new Intent(this, StudentDashboard.class);
        startActivity(intent);
    }
}