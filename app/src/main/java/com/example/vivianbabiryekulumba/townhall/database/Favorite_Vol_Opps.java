package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Favorite_Vol_Opps {

    @PrimaryKey
    private int favorite_vol_opp_id;

    @ColumnInfo(name = "fav_vol_opp")
    private String fav_vol_opp;

    public int getFavorite_vol_opp_id() {
        return favorite_vol_opp_id;
    }

    public void setFavorite_vol_opp_id(int favorite_vol_opp_id) {
        this.favorite_vol_opp_id = favorite_vol_opp_id;
    }

    public String getFav_vol_opp() {
        return fav_vol_opp;
    }

    public void setFav_vol_opp(String fav_vol_opp) {
        this.fav_vol_opp = fav_vol_opp;
    }
}