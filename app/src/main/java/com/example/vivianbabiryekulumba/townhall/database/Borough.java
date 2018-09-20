package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Borough {

    @PrimaryKey
    private int borough_id;

    @ColumnInfo(name = "borough_name")
    private String borough_name;

    public String getBorough_name() {
        return borough_name;
    }

    public void setBorough_name(String borough_name) {
        this.borough_name = borough_name;
    }

    public int getBorough_id() {
        return borough_id;
    }

    public void setBorough_id(int borough_id) {
        this.borough_id = borough_id;
    }
}
