package com.example.b07projectapp.login_module;

public interface LoginView {
    void showSuccessMessage(String userName, String userId);

    void showErrorMessage(String message);

    String getUsername();

    String getPassword();
}