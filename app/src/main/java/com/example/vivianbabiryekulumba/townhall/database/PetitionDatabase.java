package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Petitions.class}, version = 1, exportSchema = false)
public abstract class PetitionDatabase extends RoomDatabase{
    public abstract PetitionDao getPetitionDao();
}
