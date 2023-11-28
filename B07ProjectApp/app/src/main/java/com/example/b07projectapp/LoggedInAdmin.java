package com.example.b07projectapp;

public final class LoggedInAdmin {
    private static LoggedInAdmin loggedInadmin;
    private String name;
    private LoggedInAdmin(){
    }
    public static LoggedInAdmin getInstance(){
        if(loggedInadmin == null){
            loggedInadmin = new LoggedInAdmin();
        }
        return loggedInadmin;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
