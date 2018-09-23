package com.example.vivianbabiryekulumba.townhall.database;

import android.app.Application;
import android.arch.persistence.room.Room;

public class PetitionRepository extends Application{

    private PetitionDatabase petitionDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        petitionDatabase = Room.databaseBuilder(this, PetitionDatabase.class, "petition_db")
                .build();
    }

    public PetitionDatabase getPetitionDatabase() {
        return petitionDatabase;
    }
}
