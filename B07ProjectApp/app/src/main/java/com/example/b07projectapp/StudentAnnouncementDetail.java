package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StudentAnnouncementDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_announcement_detail);

        TextView edtitle = (TextView) findViewById(R.id.StdTitleAnnounce);
        TextView edposter = (TextView) findViewById(R.id.StdPoster);
        TextView edtime = (TextView) findViewById(R.id.StdTimePost);
        TextView edcontent = (TextView) findViewById(R.id.StdContent);
        String title = "";
        String name = "";
        String time = "";
        String content = "";
        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra("title");
            name = intent.getStringExtra("name");
            time = intent.getStringExtra("time");
            content = intent.getStringExtra("content");
        }

        edtitle.setText("Title: " + title);
        edposter.setText("Posted By: " + name);
        edtime.setText("Time posted: " + time);
        edcontent.setText(content);
    }
    public void onClickStudentAnnounceDetailGoBack(View view) {
        onBackPressed();
    }
}