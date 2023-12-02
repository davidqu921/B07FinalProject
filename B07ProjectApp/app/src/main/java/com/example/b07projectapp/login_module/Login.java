package com.example.b07projectapp.login_module;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.b07projectapp.R;
import com.example.b07projectapp.StudentDashboard;

public class Login extends AppCompatActivity implements LoginView {
    private LoginPresenter presenter;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginPresenter(this, new LoginModel());

        final EditText textPersonalName = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.loginBtn);
        final TextView registerBtn = findViewById(R.id.registerBtn);

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

        Intent i = new Intent(this, StudentDashboard.class);
        i.putExtra("student", userName);
        i.putExtra("studentUsername", userId);
        startActivity(i);
        finish();
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getUsername() {
        return ((EditText) findViewById(R.id.username)).getText().toString();
    }

    @Override
    public String getPassword() {
        return ((EditText) findViewById(R.id.password)).getText().toString();
    }
}