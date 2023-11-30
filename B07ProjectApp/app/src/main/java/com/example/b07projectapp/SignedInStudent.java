package com.example.b07projectapp;

public class SignedInStudent {
    private static SignedInStudent signedInStudent;
    private String username;
    private SignedInStudent(){
    }
    public static SignedInStudent getInstance(){
        if(signedInStudent == null){
            signedInStudent = new SignedInStudent();
        }
        return signedInStudent;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
}
