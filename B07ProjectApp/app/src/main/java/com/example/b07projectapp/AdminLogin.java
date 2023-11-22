package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminLogin extends AppCompatActivity {
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }

    public void onClickAdminLogIn(View view) {
        DatabaseReference ref = db.getReference();
        final EditText textPersonalName = findViewById(R.id.adminUsername);
        final EditText password = findViewById(R.id.adminPassword);
        final Button Admin_loginBtn = findViewById(R.id.adminLoginBtn);
        // final TextView registerBtn = findViewById(R.id.registerBtn);
        Admin_loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usernameTxt = textPersonalName.getText().toString();
                final String passwordTxt = password.getText().toString();

                if (usernameTxt.isEmpty() || passwordTxt.isEmpty()) {
                    Toast.makeText(AdminLogin.this, "Please enter your username or password", Toast.LENGTH_SHORT).show();
                } else {
                    ref.child("admin").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange( DataSnapshot snapshot) {
                            // check if mobile is exist in database
                            if (snapshot.hasChild(usernameTxt)) {
                                //username is exist in database
                                //now get password of user from database and match it with user entered password

                                final String getPassword = String.valueOf(snapshot.child(usernameTxt).child("password").getValue());

                                if (getPassword.equals(passwordTxt)) {
                                    Toast.makeText(AdminLogin.this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
                                    //Open main activity on success
                                    startActivity(new Intent(AdminLogin.this, AdminDashboard.class));
                                    finish();
                                } else {
                                    Toast.makeText(AdminLogin.this, "Wrong Password" + getPassword, Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(AdminLogin.this, "Wrong Password or Username", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled( DatabaseError error) {

                        }
                    });
                }
            }
        });
    }

}
