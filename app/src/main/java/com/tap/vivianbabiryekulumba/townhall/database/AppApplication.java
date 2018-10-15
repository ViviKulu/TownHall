package com.tap.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Room;
import android.support.multidex.MultiDexApplication;

public class AppApplication extends MultiDexApplication {

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
