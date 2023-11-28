package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostsRequire extends AppCompatActivity {
    Button specialistBtn, minorBtn, back1Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require);

        specialistBtn = (Button) findViewById(R.id.specialistBtn);
        specialistBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSpecialistMajor();
            }
        });

        minorBtn = (Button) findViewById(R.id.minorBtn);
        minorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMinor();
            }
        });

        back1Btn = (Button) findViewById(R.id.back1Btn);
        back1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentDashboard();
            }
        });
    }

    public void openSpecialistMajor(){
        Intent intent = new Intent(this, PostsRequireSpecialistMajor.class);
        startActivity(intent);
    }
    public void openMinor(){
        Intent intent = new Intent(this, PostsRequireMinor.class);
        startActivity(intent);
    }

    public void openStudentDashboard(){
        Intent intent = new Intent(this, StudentDashboard.class);
        startActivity(intent);
    }
}

