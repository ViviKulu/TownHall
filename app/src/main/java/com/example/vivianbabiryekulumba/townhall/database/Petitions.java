package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "petition_table")
public class Petitions{

    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "petition_title")
    private
    String petition_title;

    @ColumnInfo(name = "petition_content")
    private
    String petition_content;

    public Petitions(@NonNull String petition_title, String petition_content) {
        this.petition_title = petition_title;
        this.petition_content = petition_content;
    }

    @NonNull
    public String getPetition_title() {
        return petition_title;
    }

    public void setPetition_title(@NonNull String petition_title) {
        this.petition_title = petition_title;
    }

    public String getPetition_content() {
        return petition_content;
    }

    public void setPetition_content(String petition_content) {
        this.petition_content = petition_content;
    }
}
