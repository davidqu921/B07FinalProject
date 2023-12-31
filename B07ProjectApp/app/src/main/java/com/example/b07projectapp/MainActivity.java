package com.example.b07projectapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.b07projectapp.login_module.AdminLogin;
import com.example.b07projectapp.login_module.Login;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickStudentSignUp(View view) {
        Intent intent = new Intent(getApplicationContext(), SignUpStudent.class);
        startActivity(intent);
    }

//    public void onClickStudentDashBoard(View view) {
//        Intent intent = new Intent(getApplicationContext(), StudentDashboard.class);
//        startActivity(intent);
//    }
//
//    public void onClickAdminDashBoard(View view) {
//        Intent intent = new Intent(getApplicationContext(), AdminDashboard.class);
//        startActivity(intent);
//    }

    public void onClickStudentLogin(View view){
        Intent intent = new Intent(getApplicationContext(), Login.class);
        Log.d("myTag", "This is my message");
        startActivity(intent);
    }

    public void onClickAdminLogin(View view){
        Intent intent = new Intent(getApplicationContext(), AdminLogin.class);
        startActivity(intent);
    }
   public void onClickAdminSignUp(View view) {
        Intent intent = new Intent(getApplicationContext(), AdminSignUp.class);
        startActivity(intent);
   }

}