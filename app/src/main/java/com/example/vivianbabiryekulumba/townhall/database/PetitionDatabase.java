package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.vivianbabiryekulumba.townhall.util.Constants;

@Database(entities = {Petitions.class}, version = 1, exportSchema = false)
public abstract class PetitionDatabase extends RoomDatabase{

    public abstract PetitionDao getPetitionDao();
    private static PetitionDatabase petitionDB;

    public static PetitionDatabase getInstance(Context context){
        if(null == petitionDB){
            petitionDB = buildDatabaseInstance(context);
        }
        return petitionDB;
    }

    private static PetitionDatabase buildDatabaseInstance(Context context){
        return Room.databaseBuilder(context, PetitionDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        petitionDB = null;
    }
}
