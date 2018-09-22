package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Petitions{

    @PrimaryKey(autoGenerate = true)
    private int petition_id;

    String petition_title;
    String petition_content;

    public Petitions() {

    }

    public Petitions(String petition_title, String petition_content){
        this.petition_title = petition_title;
        this.petition_content = petition_content;
    }

    public int getPetition_id() {
        return petition_id;
    }

    public void setPetition_id(int petition_id) {
        this.petition_id = petition_id;
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
