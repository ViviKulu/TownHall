package com.example.vivianbabiryekulumba.townhall.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class PetitionRepository {

    private PetitionDao petitionDao;
    private LiveData<List<Petitions>> petitionsList;

    PetitionRepository(Application application) {
        PetitionDatabase db = PetitionDatabase.getDatabase(application);
        petitionDao = db.petitionDao();
        petitionsList = petitionDao.getAllPetitions();
    }

    LiveData<List<Petitions>> getAllPetitions() {
        return petitionsList;
    }

    public void insert(Petitions petitions) {
        new insertAsyncTask(petitionDao).execute(petitions);
    }

    private static class insertAsyncTask extends AsyncTask<Petitions, Void, Void> {

        private PetitionDao petitionAsyncTaskDao;

        insertAsyncTask(PetitionDao petitionDao) {
            petitionAsyncTaskDao = petitionDao;
        }


        @Override
        protected Void doInBackground(final Petitions... petitions) {
            petitionAsyncTaskDao.insert(petitions[0]);
            return null;
        }
    }


}
