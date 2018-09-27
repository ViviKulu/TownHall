package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {FavCard.class}, version = 1, exportSchema = false)
public abstract class FavCardDatabase extends RoomDatabase {
    public abstract FavCardDao favCardDao();
}
