package com.example.b07projectapp.login_module;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminLoginModel {
    private FirebaseDatabase database;

    public AdminLoginModel() {
        database = FirebaseDatabase.getInstance("https://cscb07finalproject-b7b73-default-rtdb.firebaseio.com/");
    }

    public void loginUser(String username, String password, ValueEventListener listener) {
        DatabaseReference ref = database.getReference("admin");

        ref.child(username).addListenerForSingleValueEvent(listener);
    }
}
