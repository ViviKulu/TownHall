package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Petitions.class}, version = 1, exportSchema = false)
public abstract class PetitionDatabase extends RoomDatabase{

    public abstract PetitionDao petitionDao();

    private static volatile PetitionDatabase INSTANCE;

    static PetitionDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (PetitionDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PetitionDatabase.class, "petition_db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
