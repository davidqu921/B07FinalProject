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
    Button btn7, btn8, btn16;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_require_minor);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn16 = (Button) findViewById(R.id.button16);
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudentDashboard();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireMinor.this, "Congratulations, You've met the requirements!", Toast.LENGTH_SHORT).show();
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PostsRequireMinor.this, "Sorry, You've not met the requirements.", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public void openStudentDashboard(){
        Intent intent = new Intent(this, StudentDashboard.class);
        startActivity(intent);
    }

}