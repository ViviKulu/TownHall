package com.example.vivianbabiryekulumba.townhall.database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class PetitionListViewModel extends AndroidViewModel {

    private PetitionRepository petitionRepository;
    private LiveData<List<Petition>> petitionsList;

    public PetitionListViewModel(@NonNull Application application) {
        super(application);

        petitionRepository = new PetitionRepository(application);
        petitionsList = petitionRepository.getAllPetitions();
    }

    public LiveData<List<Petition>> getAllPetitions() { return petitionsList; }

    public void insert(Petition petition) { petitionRepository.insert(petition); }
}
