package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnnouncementDetailAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement_detail_admin);


        TextView edtitle = (TextView) findViewById(R.id.tvTitleAnnounce);
        TextView edposter = (TextView) findViewById(R.id.tvPoster);
        TextView edtime = (TextView) findViewById(R.id.edTimePost);
        TextView edcontent = (TextView) findViewById(R.id.tvContent);
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

    public void onClickAdminAnnounceDetailGoBack(View view) {
        onBackPressed();
    }
}