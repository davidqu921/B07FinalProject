package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminSignUp extends AppCompatActivity {

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }

    public void onClickAdminSignUp(View view){
        DatabaseReference ref = db.getReference();
        EditText adminUsername = (EditText) findViewById(R.id.editTextAdminUsername);
        EditText adminName = (EditText) findViewById(R.id.editTextAdminName);
        EditText adminPassword = (EditText) findViewById(R.id.editTextAdminPassword);
        String username = adminUsername.getText().toString();
        String name = adminName.getText().toString();
        String password = adminPassword.getText().toString();
        adminUsername.setText("");
        adminName.setText("");
        adminPassword.setText("");
        DatabaseReference query = ref.child("admin").child(username);

        query.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                if(!snapshot.exists())
                {
                    ref.child("admin").child(username).child("username").setValue(username);
                    ref.child("admin").child(username).child("name").setValue(name);
                    ref.child("admin").child(username).child("password").setValue(password);

                    // show a success message then finish the activity
                    Toast.makeText(getApplicationContext(), "User register successfully", Toast.LENGTH_LONG).show();

                    // redirect to login page
//                    Intent intent = new Intent(getApplicationContext(), AdminLogin.class);
//                    startActivity(intent);

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

    public void onClickSignUpAdminGoBack(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}