package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface PetitionDao {
    @Query("SELECT * FROM petitions")
    List<Petitions> getAllPetitions();

    @Query("SELECT * FROM petitions WHERE petition_id IN (:petitionIds)")
    List<Petitions> loadAllByIds(int[] petitionIds);

    @Insert
    void insertAll(Petitions... petitions);

    @Insert(onConflict = REPLACE)
    void insertPetition(Petitions petition);

    @Delete
    void delete(Petitions petition);

    @Delete
    void delete(Petitions... petitions);
}
