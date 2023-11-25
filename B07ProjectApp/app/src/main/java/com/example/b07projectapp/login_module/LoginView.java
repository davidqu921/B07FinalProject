package com.example.b07projectapp.login_module;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public interface LoginView {
    void showSuccessMessage();

    void showErrorMessage(String message);

    String getUsername();

    String getPassword();
}