package com.example.vivianbabiryekulumba.townhall.models;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Petition {
    public String petition_title;
    public String petition_content;

    public Petition() {
        //Default constructor is required for calls to DataSnapshot.
    }

    public Petition(String petition_title, String petition_content) {
        this.petition_title = petition_title;
        this.petition_content = petition_content;
    }

    public String getPetition_title() {
        return petition_title;
    }

    public void setPetition_title(String petition_title) {
        this.petition_title = petition_title;
    }

    public String getPetition_content() {
        return petition_content;
    }

    public void setPetition_content(String petition_content) {
        this.petition_content = petition_content;
    }

}
