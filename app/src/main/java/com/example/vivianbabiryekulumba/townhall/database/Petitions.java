package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Petitions {

    @PrimaryKey
    private int petition_id;

    @ColumnInfo(name = "petition_content")
    private String petition_content;

    public String getPetition_content() {
        return petition_content;
    }

    public void setPetition_content(String petition_content) {
        this.petition_content = petition_content;
    }

    public int getPetition_id() {
        return petition_id;
    }

    public void setPetition_id(int petition_id) {
        this.petition_id = petition_id;
    }
}
