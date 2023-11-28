package com.example.b07projectapp;

import static android.widget.Toast.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.b07projectapp.login_module.AdminLogin;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.Date;

public class AdminAddEvent extends AppCompatActivity {
    FirebaseDatabase base = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_event);
    }

    public void onClickAdd(View view){
        String user = getIntent().getStringExtra("username");
        if (user == null) {
            makeText(AdminAddEvent.this, "Log In as an Admin First!", LENGTH_SHORT).show();
            startActivity(new Intent(AdminAddEvent.this, AdminLogin.class));
        }
        else {

            DatabaseReference ref = base.getReference();
            EditText Title = (EditText) findViewById(R.id.editTextText);
            EditText desc = (EditText) findViewById(R.id.editTextStudentComplaint2);
            String descStr = desc.getText().toString();
            String TitleStr = Title.getText().toString();
            //desc.setText("");
            //Title.setText("");
            EditText location = (EditText) findViewById(R.id.editTextText2);
            String locationStr = location.getText().toString();
            //location.setText("");
            EditText date = (EditText) findViewById(R.id.editTextDate);
            String dateStr = date.getText().toString();
            //date.setText("");
            EditText people = (EditText) findViewById(R.id.editTextNumber2);
            String peoplestr = people.getText().toString();
            //people.setText("");
            boolean ct[] = {true};
            ref.child("event").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    boolean call = false;

                    for (DataSnapshot ds: snapshot.getChildren()){
                        if (ds.getKey().equals(TitleStr)) {
                            call = true;
                            break;
                        }
                    }
                    if(ct[0]) {
                        if (!call) {
                            if (TitleStr.isEmpty() || descStr.isEmpty() || dateStr.isEmpty() || locationStr.isEmpty() || peoplestr.isEmpty()) {
                                makeText(AdminAddEvent.this, "Fill In All Empty Fields", LENGTH_SHORT).show();

                            } else {
                                ref.child("event").child(TitleStr).child("title").setValue(TitleStr);
                                ref.child("event").child(TitleStr).child("description").setValue(descStr);
                                ref.child("event").child(TitleStr).child("date").setValue(dateStr);
                                ref.child("event").child(TitleStr).child("location").setValue(locationStr);
                                ref.child("event").child(TitleStr).child("limit").setValue(Integer.valueOf(peoplestr));
                                ref.child("event").child(TitleStr).child("poster").setValue(user);
                                makeText(AdminAddEvent.this, "Event Created!", LENGTH_SHORT).show();
                            }
                        } else {
                            makeText(AdminAddEvent.this, "Event Already Exists", LENGTH_SHORT).show();
                        }
                        ct[0] = false;
                    }
                    //finish();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }
}