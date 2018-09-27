package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface FavCardDao {

    @Insert()
    Long addFavCard(FavCard favCard);

    @Query("DELETE FROM fav_table")
    void deleteAll();

    @Query("SELECT * from fav_table ORDER BY fav_locality_city ASC")
    LiveData<FavCard[]> getAllFavCards();
}
