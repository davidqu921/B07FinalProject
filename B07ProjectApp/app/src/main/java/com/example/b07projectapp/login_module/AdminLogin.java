package com.example.b07projectapp.login_module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b07projectapp.AdminDashboard;
import com.example.b07projectapp.R;

public class AdminLogin extends AppCompatActivity implements LoginView {
    private AdminLoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        presenter = new AdminLoginPresenter(this, new AdminLoginModel());

        final EditText textPersonalName = findViewById(R.id.adminUsername);
        final EditText password = findViewById(R.id.adminPassword);
        final Button loginBtn = findViewById(R.id.adminLoginBtn);
        final TextView registerBtn = findViewById(R.id.adminRegisterBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loginUser();
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.openSignUpActivity();
            }
        });
    }

    @Override
    public void showSuccessMessage(String userName, String userId) {
        Toast.makeText(this, "Successfully Logged in", Toast.LENGTH_SHORT).show();
        // Open main activity on success
        Intent i = new Intent(this, AdminDashboard.class);
        i.putExtra("username", userId);

        startActivity(i);
        finish();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return ((EditText) findViewById(R.id.adminUsername)).getText().toString();
    }

    @Override
    public String getPassword() {
        return ((EditText) findViewById(R.id.adminPassword)).getText().toString();
    }
}