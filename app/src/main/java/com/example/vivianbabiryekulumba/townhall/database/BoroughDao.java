package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface BoroughDao {

    @Query("SELECT * FROM borough")
    List<Borough> getAll();

    @Query("SELECT * FROM borough WHERE borough_id IN (:boroughIds)")
    List<Borough> loadAllByIds(int[] boroughIds);

    @Query("SELECT * FROM borough WHERE borough_name LIKE :borough_name LIMIT 1")
    Borough findByName(String borough_name);

    @Insert
    void insertAll(Borough... boroughs);

    @Insert(onConflict = REPLACE)
    void insertBorough(Borough borough);

    @Delete
    void delete(Borough borough);

}
