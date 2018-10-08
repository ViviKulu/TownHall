package com.update.vivianbabiryekulumba.townhall.database;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

public class PetitionObserver implements Observer<Petition[]> {

    private final PetitionListPresenter petitionListPresenter;

    public PetitionObserver(PetitionListPresenter petitionListPresenter) {
        this.petitionListPresenter = petitionListPresenter;
    }

    @Override
    public void onChanged(@Nullable Petition[] petitions) {
        petitionListPresenter.onPetitionChanged(petitions);
    }
}