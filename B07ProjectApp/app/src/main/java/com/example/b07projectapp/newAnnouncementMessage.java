package com.example.b07projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
// This file is used to implement popup notifications for new announcements. However, we have not
// fully implemented the full functionality and have not added this feature to other activities in
// order to avoid software crashes and other bugs.
// Below is the code we have written for this feature.
public class newAnnouncementMessage extends AppCompatActivity {

    TextView pstTime, pstTitle, pstName, pstInfo;
    Button btnClose;

    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_announcement_message);

        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
        DatabaseReference ref = db.getReference();
        ref.child("notification").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snap : snapshot.getChildren()) {
                    String name = snap.child("name").getValue(String.class);
                    String title = snap.child("title").getValue(String.class);
                    String time = snap.child("time").getValue(String.class);
                    String content = snap.child("content").getValue(String.class);
                    Announcement announcement = new Announcement(name, title, time, content);

                    showAnnouncementDialog(announcement);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void showAnnouncementDialog(Announcement announcement) {
        View dialogView = LayoutInflater.from(this).inflate(R.layout.activity_new_announcement_message, null);

        pstTime = dialogView.findViewById(R.id.PstTime);
        pstTitle = dialogView.findViewById(R.id.PstTitle);
        pstName = dialogView.findViewById(R.id.PstName);
        pstInfo = dialogView.findViewById(R.id.PstAnnounInfo);
        btnClose = dialogView.findViewById(R.id.BtnClose);

        pstTitle.setText(announcement.getTitle());
        pstInfo.setText(announcement.getContent());
        pstName.setText(announcement.getName());
        pstTime.setText(announcement.getTime());

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(dialogView);

        final AlertDialog dialog = builder.create();
        dialog.show();

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}

// Here are other ways we've tried to implement this feature。
/*
public class StudentDashboard extends AppCompatActivity {

    TextView pstTime, pstTitle, pstName, pstInfo;
    Button btnClose;

    private FirebaseDatabase db;
    FirebaseUser user;
    String userName;
    Boolean isFound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_dashboard);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
        DatabaseReference ref = db.getReference();

        user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            if (user.getDisplayName() != null) {
                userName = user.getDisplayName();

                UserExists(userName).addOnSuccessListener(exists -> {
                    if (!exists) {
                        ref.child("notifications").child(userName).setValue(true);
                    }
                    ref.child("announcements").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snap : snapshot.getChildren()) {
                                String key = snap.getKey();

                                if (!KeyExists(key)) {
                                    String name = snap.child("name").getValue(String.class);
                                    String title = snap.child("title").getValue(String.class);
                                    String time = snap.child("time").getValue(String.class);
                                    String content = snap.child("content").getValue(String.class);
                                    Announcement announcement = new Announcement(name, title, time, content);
                                    showAnnouncementDialog(announcement);
                                    ref.child("notifications").child(userName).child(key).setValue(true);
                                }
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });
                });
            } else {
                Log.e("StudentDashboard", "User is not authenticated.");
            }
        } else {
            Log.e("StudentDashboard", "User is not authenticated.");
        }
    }


    public Task<Boolean> UserExists(String userName) {
        DatabaseReference ref = db.getReference("notifications");
        TaskCompletionSource<Boolean> taskCompletionSource = new TaskCompletionSource<>();

        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean checkName = false;
                for (DataSnapshot snap : snapshot.getChildren()) {
                    String key = snap.getKey();
                    if (key.equals(userName)) {
                        checkName = true;
                        break;
                    }
                }
                taskCompletionSource.setResult(checkName);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                taskCompletionSource.setException(error.toException());
            }
        });

        return taskCompletionSource.getTask();
    }


    public boolean KeyExists(String key) {
        DatabaseReference ref = db.getReference("notifications").child(userName);
        ref.child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                isFound = snapshot.exists();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }

        });
        return isFound;
    }
 */