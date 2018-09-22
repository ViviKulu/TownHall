package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface PetitionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAllPetitions(List<Petitions> petitions_post);

    @Insert
    Long insertPetition(Petitions petition);

    @Query("SELECT * FROM Petitions")
    LiveData<List<Petitions>> findAllPetitions();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void savePetition(Petitions petitions_post);

    @Update
    void updatePetition(Petitions petitions_post);

    @Delete
    void deletePetition(Petitions petitions_post);

}
