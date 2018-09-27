package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.room.Room;

public class AppApplication extends android.app.Application {

    private PetitionDatabase petitionDatabase;
    private static FavCardDatabase favCardDatabase;

    @Override
    public void onCreate() {
        super.onCreate();

        petitionDatabase = Room.databaseBuilder(this, PetitionDatabase.class, "petition_db")
                .build();

        favCardDatabase = Room.databaseBuilder(this, FavCardDatabase.class, "fav_card_db")
                .build();
    }

    public PetitionDatabase getPetitionDatabase() {
        return petitionDatabase;
    }

    public FavCardDatabase getFavCardDatabase() {
        return favCardDatabase;
    }
}
