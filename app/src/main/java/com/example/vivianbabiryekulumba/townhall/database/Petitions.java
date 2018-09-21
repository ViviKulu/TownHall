package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Petitions {

    @PrimaryKey
    private int petition_id;

    @ColumnInfo(name = "petition_title")
    private String petition_title;

    @ColumnInfo(name = "petition_content")
    private String petition_content;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Petitions)) return false;

        Petitions petition = (Petitions) o;

        if (petition_id != petition.petition_id) return false;
        return petition_title != null ? petition_title.equals(petition.petition_title) : petition.petition_title == null;
    }

    @Override
    public int hashCode() {
        int result = petition_id;
        result = 31 * result + (petition_title != null ? petition_title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Petition{" +
                "petition_id=" + petition_id +
                ", petition_content='" + petition_content + '\'' +
                ", petition_title='" + petition_title + '\'' +
                '}';
    }
}
