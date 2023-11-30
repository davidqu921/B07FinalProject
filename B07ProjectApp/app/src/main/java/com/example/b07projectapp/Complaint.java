package com.example.b07projectapp;

public class Complaint {
    String topic;
    String content;
    String name;
    String time;

    public Complaint(String topic, String content, String name, String time) {
        this.topic = topic;
        this.content = content;
        this.name = name;
        this.time = time;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }
    public String getTime() {
        return time;
    }
}
