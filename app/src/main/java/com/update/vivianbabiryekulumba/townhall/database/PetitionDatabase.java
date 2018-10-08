package com.update.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Petition.class}, version = 1, exportSchema = false)
public abstract class PetitionDatabase extends RoomDatabase {
    public abstract PetitionDao petitionDao();
}
