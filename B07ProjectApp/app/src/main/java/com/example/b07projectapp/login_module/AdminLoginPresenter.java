package com.example.b07projectapp.login_module;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.b07projectapp.AdminSignUp;
import com.example.b07projectapp.LoggedInAdmin;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class AdminLoginPresenter {
    private LoginView view;
    private AdminLoginModel model;

    public AdminLoginPresenter(LoginView view, AdminLoginModel model) {
        this.view = view;
        this.model = model;
    }

    public void loginUser() {
        final String username = view.getUsername();
        final String password = view.getPassword();

        if (username.isEmpty() || password.isEmpty()) {
            view.showErrorMessage("Please enter your username or password");
        } else {
            model.loginUser(username, password, new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()) {
                        String storedPassword = String.valueOf(snapshot.child("password").getValue());

                        //this section is added to access the data of logged in admin using singleton
                        String adminName = String.valueOf(snapshot.child("name").getValue());
                        ///

                        if (storedPassword.equals(password)) {
                            view.showSuccessMessage();

                            //this section is added to access the data of logged in admin using singleton
                            LoggedInAdmin.getInstance().setName(adminName);
                            ///

                        } else {
                            view.showErrorMessage("Wrong Password");
                        }
                    } else {
                        view.showErrorMessage("Wrong Password or Username");
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    // Handle onCancelled
                }
            });
        }
    }

    public void openSignUpActivity() {
        // open SignUp activity
        Intent intent = new Intent((Activity) view, AdminSignUp.class);
        ((Activity) view).startActivity(intent);
    }
}
