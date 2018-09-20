package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Petitions.class, Borough.class, Favorite_Vol_Opps.class, UserProfile.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{
    public abstract PetitionDao petitionDao();
    public abstract BoroughDao boroughDao();
    public abstract FavoriteVolOppDao favoriteVolOppDao();
    public abstract UserProfileDao userProfileDao();
}
