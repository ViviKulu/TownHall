package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "fav_table")
public class FavCard {

    @PrimaryKey(autoGenerate = true)
    private int fav_id;

    @ColumnInfo(name = "fav_title")
    public String fav_title;

    @ColumnInfo(name = "fav_summary")
    public String fav_summary;

    @ColumnInfo(name = "fav_locality_address")
    public String fav_locality_address;

    @ColumnInfo(name = "fav_locality_city")
    public String fav_locality_city;

    public FavCard(String fav_title, String fav_summary, String fav_locality_address, String fav_locality_city) {
        this.fav_title = fav_title;
        this.fav_summary = fav_summary;
        this.fav_locality_address = fav_locality_address;
        this.fav_locality_city = fav_locality_city;
    }

    public int getFav_id() {
        return fav_id;
    }

    public void setFav_id(int fav_id) {
        this.fav_id = fav_id;
    }

    public String getFav_title() {
        return fav_title;
    }

    public void setFav_title(String fav_title) {
        this.fav_title = fav_title;
    }

    public String getFav_summary() {
        return fav_summary;
    }

    public void setFav_summary(String fav_summary) {
        this.fav_summary = fav_summary;
    }

    public String getFav_locality_address() {
        return fav_locality_address;
    }

    public void setFav_locality_address(String fav_locality_address) {
        this.fav_locality_address = fav_locality_address;
    }

    public String getFav_locality_city() {
        return fav_locality_city;
    }

    public void setFav_locality_city(String fav_locality_city) {
        this.fav_locality_city = fav_locality_city;
    }
}
