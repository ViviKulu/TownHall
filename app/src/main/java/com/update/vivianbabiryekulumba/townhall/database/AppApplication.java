package com.update.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Room;

public class AppApplication extends android.app.Application {

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
