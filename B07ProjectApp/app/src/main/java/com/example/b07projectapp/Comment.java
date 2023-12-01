package com.example.b07projectapp;

public class Comment {
    String user;
    float rating;
    String comment;



    public Comment(String username, float rating, String review ) {
        this.user = username;
        this.comment =review;
        this.rating =rating;
    }

    public String getUser() {
        return user;
    }

    public float getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
