package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostsRequireSpecialistMajor extends AppCompatActivity {
    private Button yes2Btn, no2Btn, back3Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require_specialist_major);

        yes2Btn = (Button) findViewById(R.id.yes2Btn);
        yes2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInsideCMS();
            }
        });
        no2Btn = (Button) findViewById(R.id.no2Btn);
        no2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOutSideCMS();
            }
        });
        back3Btn = (Button) findViewById(R.id.back3Btn);
        back3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentDashboard();
            }
        });

    }
    public void openInsideCMS(){
        Intent intent = new Intent(this, PostsRequireInsideCMS.class);
        startActivity(intent);
    }

    public void openOutSideCMS(){
        Intent intent = new Intent(this, PostsRequireOutsideCMS.class);
        startActivity(intent);
    }
    public void openStudentDashboard(){
        Intent intent = new Intent(this, StudentDashboard.class);
        startActivity(intent);
    }
}
