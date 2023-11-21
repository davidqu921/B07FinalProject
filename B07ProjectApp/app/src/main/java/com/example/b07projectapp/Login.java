package com.example.b07projectapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }

    public void onClickStudentLogIn(View view){
        DatabaseReference ref = db.getReference();
        final EditText textPersonalName = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.loginBtn);
        final TextView registerBtn = findViewById(R.id.registerBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernameTxt = textPersonalName.getText().toString();
                final String passwordTxt = password.getText().toString();

                if(usernameTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Login.this,"Please enter your username or password", Toast.LENGTH_SHORT).show();
                }
                else{
                    ref.child("students").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // check if mobile is exist in database
                            if(snapshot.hasChild(usernameTxt)){
                                //username is exist in database
                                //now get password of user from database and match it with user entered password

                                final String getPassword = snapshot.child(usernameTxt).child("password").getValue(String.class);

                                if(getPassword.equals(passwordTxt)){
                                    Toast.makeText(Login.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    //Open main activity on success
                                    Intent intent = new Intent(getApplicationContext(), StudentDashboard.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(Login.this,"Wrong Password" + getPassword,Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(Login.this, "Wrong Password or Username", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open SignUp activity
                startActivity(new Intent(Login.this, SignUpStudent.class));
            }
        });

    }
}