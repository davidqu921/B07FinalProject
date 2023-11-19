package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class LoginFragment extends AppCompatActivity {

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }

    public void onClick

    // this is a comment
    //another comment
    // I hope this works!!
    // Also Works!
    // Test
    // here is another comment
}