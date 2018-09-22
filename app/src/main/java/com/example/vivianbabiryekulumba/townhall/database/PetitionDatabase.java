package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

@Database(entities = {Petitions.class}, version = 1, exportSchema = false)
public abstract class PetitionDatabase extends RoomDatabase{

    private static final String TAG = "PetitionDatabase";

    public abstract PetitionDao petitionDao();

    public static volatile PetitionDatabase INSTANCE;

    static PetitionDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (PetitionDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PetitionDatabase.class, "petition_db")
                            .fallbackToDestructiveMigration()
                            .addCallback(petitionRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    private static RoomDatabase.Callback petitionRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(PetitionDatabase.INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private PetitionDao petitionDao;

        PopulateDbAsync(PetitionDatabase db) {
            petitionDao = db.petitionDao();
            Log.d(TAG, "PopulateDbAsync: "  + petitionDao);
        }

        @Override
        protected Void doInBackground(final Void... params) {
            petitionDao.deleteAll();
            Petitions petitions = new Petitions("sample petition title 1", "sample petition content 1");
            petitionDao.insert(petitions);
            petitions = new Petitions("sample petition title 2", "sample petition content 2");
            petitionDao.insert(petitions);
            return null;
        }
    }

}
