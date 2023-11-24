package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostsRequire extends AppCompatActivity {
    Button btn5, btn6, btn15;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require);

        btn5 = (Button) findViewById(R.id.button5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSpecialistMajor();
            }
        });

        btn6 = (Button) findViewById(R.id.eventListBack);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMinor();
            }
        });

        btn15 = (Button) findViewById(R.id.button15);
        btn15.setOnClickListener(new View.OnClickListener() {
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