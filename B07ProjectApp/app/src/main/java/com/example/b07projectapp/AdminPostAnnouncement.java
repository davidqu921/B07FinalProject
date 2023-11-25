package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.b07projectapp.login_module.Login;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AdminPostAnnouncement extends AppCompatActivity {
    FirebaseDatabase db;
    String time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_post_announcement);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");


        // get the current day and time and format string time
        Calendar c = Calendar.getInstance();
        java.util.Date date = c.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM, HH:mm", Locale.getDefault());
        time = dateFormat.format(date);
    }

    public void onClickAddAnnouncement(View view){
        DatabaseReference ref = db.getReference();
        EditText  edTitle = (EditText) findViewById(R.id.edAdminAnnounceTitle);
        EditText  edContent = (EditText) findViewById(R.id.edAnnounceContentAdmin);

        String title = edTitle.getText().toString();
        String content = edContent.getText().toString();
        String name = LoggedInAdmin.getInstance().getName();

        if(name.isEmpty()){
            name = "Failed to load name";
        }

        if(title.isEmpty() || content.isEmpty()){
            Toast.makeText(getApplicationContext(), "Unsuccessful. Please fill out all fields", Toast.LENGTH_LONG).show();
        }
        else {
            edTitle.setText("");
            edContent.setText("");

            String announcementKey = ref.child("announcements").push().getKey();
            ref.child("announcements").child(announcementKey).child("title").setValue(title);
            ref.child("announcements").child(announcementKey).child("content").setValue(content);
            ref.child("announcements").child(announcementKey).child("name").setValue(name);
            ref.child("announcements").child(announcementKey).child("time").setValue(time);

            Toast.makeText(getApplicationContext(), "Announcement posted !", Toast.LENGTH_LONG).show();
            // redirect to main dashboard
            Intent intent = new Intent(getApplicationContext(), AdminViewAnnouncement.class);
            startActivity(intent);
        }
    }

    public void onClickView(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminViewAnnouncement.class);
        startActivity(intent);
    }
}