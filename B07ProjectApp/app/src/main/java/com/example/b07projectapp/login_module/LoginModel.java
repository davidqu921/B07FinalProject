package com.example.b07projectapp.login_module;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginModel {
    private FirebaseDatabase database;

    public LoginModel() {
        database = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }

    public void loginUser(String username, String password, ValueEventListener listener) {
        DatabaseReference ref = database.getReference("students");

        ref.child(username).addListenerForSingleValueEvent(listener);
    }
}