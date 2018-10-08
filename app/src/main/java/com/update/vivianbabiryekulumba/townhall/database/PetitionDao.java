package com.update.vivianbabiryekulumba.townhall.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@Dao
public interface PetitionDao {

    @Insert()
    Long addPetition(Petition petition);

    @Query("DELETE FROM petition_table")
    void deleteAll();

    @Query("SELECT * from petition_table ORDER BY petition_title ASC")
    LiveData<Petition[]> getAllPetitions();

}
