package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostsRequireSpecialistMajor extends AppCompatActivity {
    private Button btn9, btn10, btn17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require_specialist_major);

        btn9 = (Button) findViewById(R.id.button9);
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInsideCMS();
            }
        });
        btn10 = (Button) findViewById(R.id.button10);
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOutSideCMS();
            }
        });
        btn17 = (Button) findViewById(R.id.button17);
        btn17.setOnClickListener(new View.OnClickListener() {
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
