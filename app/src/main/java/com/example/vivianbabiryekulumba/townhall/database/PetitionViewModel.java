package com.example.vivianbabiryekulumba.townhall.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class PetitionViewModel extends AndroidViewModel {

    private PetitionRepository petitionRepository;
    private LiveData<List<Petitions>> petitionsList;

    public PetitionViewModel(@NonNull Application application) {
        super(application);
        petitionRepository = new PetitionRepository(application);
        petitionsList = petitionRepository.getAllPetitions();
    }

    public LiveData<List<Petitions>> getAllPetitions(){
        return petitionsList;
    }

    public void insert(Petitions petitions){
        petitionRepository.insert(petitions);
    }

}
