package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PostsRequireOutsideCMS extends AppCompatActivity {
    Button btn13, btn14, btn19;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require_outside_cms);
        btn13 = findViewById(R.id.button13);
        btn14 = findViewById(R.id.button14);
        btn19 = (Button) findViewById(R.id.button19);
        btn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentDashboard();
            }
        });

        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireOutsideCMS.this, "Congratulations, You've met the requirements!", Toast.LENGTH_SHORT).show();
            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireOutsideCMS.this, "Sorry, You've not met the requirements.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openStudentDashboard(){
        Intent intent = new Intent(this, StudentDashboard.class);
        startActivity(intent);
    }
}