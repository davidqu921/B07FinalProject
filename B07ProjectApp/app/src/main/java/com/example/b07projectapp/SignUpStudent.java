package com.example.b07projectapp;

import com.google.firebase.database.FirebaseDatabase;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
public class SignUpStudent extends AppCompatActivity{
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_sign_up);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }

    public void onClickStudentSignUp(View view){
        DatabaseReference ref = db.getReference();
        EditText studentUsername = (EditText) findViewById(R.id.editTextStudentUsername);
        EditText studentName = (EditText) findViewById(R.id.editTextStudentName);
        EditText studentPassword = (EditText) findViewById(R.id.editTextStudentPassword);
        String username = studentUsername.getText().toString();
        String name = studentName.getText().toString();
        String password = studentPassword.getText().toString();
        studentUsername.setText("");
        studentName.setText("");
        studentPassword.setText("");
        DatabaseReference query = ref.child("students").child(username);

        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(!snapshot.exists())
                {
                    ref.child("students").child(username).child("username").setValue(username);
                    ref.child("students").child(username).child("name").setValue(name);
                    ref.child("students").child(username).child("password").setValue(password);

                    // show a success message then finish the activity
                    Toast.makeText(getApplicationContext(),"User register successfully.",Toast.LENGTH_SHORT).show();

                    // redirect to login page
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "The username already existed. Enter a new one", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    public void onClickSignUpStudentGoBack(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
