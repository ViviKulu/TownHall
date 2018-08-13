package com.example.vivianbabiryekulumba.townhall.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Event {
    public String event_title;
    public String event_content;

    public Event() {
        //Default constructor is required for calls to DataSnapshot.
    }

    public Event(String event_title, String event_content) {
        this.event_title = event_title;
        this.event_content = event_content;
    }

    public String getEvent_title() {
        return event_title;
    }

    public void setEvent_title(String event_title) {
        this.event_title = event_title;
    }

    public String getEvent_content() {
        return event_content;
    }

    public void setEvent_content(String event_content) {
        this.event_content = event_content;
    }
}
