package com.example.b07projectapp;

public class Announcement {
    String name;
    String title;
    String time;

    String content;

    public Announcement(String name, String title, String time, String content) {
        this.name = name;
        this.title = title;
        this.time = time;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }
    public String getContent() {
        return content;
    }
}
