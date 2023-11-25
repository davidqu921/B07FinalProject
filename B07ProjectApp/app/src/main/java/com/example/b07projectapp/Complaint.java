package com.example.b07projectapp;

public class Complaint {
    String topic;
    String content;
    String name;

    public Complaint(String topic, String content, String name) {
        this.topic = topic;
        this.content = content;
        this.name = name;
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
}
