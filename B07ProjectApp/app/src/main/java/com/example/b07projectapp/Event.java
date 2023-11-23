package com.example.b07projectapp;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Event {
    String title, location, date, description;
    ArrayList<Object> comment,participants;

    public Event() {
        // Default constructor
    }

    // Constructor with parameters to initialize the fields
    public Event(String title, String location, String date, String description) {
        this.title = title;
        this.location = location;
        this.date = date;
        this.description = description;

    }

    public String getEventTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Object> getComment() {
        return comment;
    }

    public ArrayList<Object> getParticipants() {
        return participants;
    }


}