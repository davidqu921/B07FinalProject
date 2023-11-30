package com.example.b07projectapp;

public class Comment {
    String user;
    int rating;
    String comment;



    public Comment(String username, int rating, String review ) {
        this.user = username;
        this.comment =review;
        this.rating =rating;
    }

    public String getUser() {
        return user;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
