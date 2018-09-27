package com.example.vivianbabiryekulumba.townhall.database;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

public class FavCardObserver implements Observer<FavCard[]> {

    private final FavCardListPresenter favCardPresenter;

    public FavCardObserver(FavCardListPresenter favCardPresenter) {
        this.favCardPresenter = favCardPresenter;
    }

    @Override
    public void onChanged(@Nullable FavCard[] favCards) {
        favCardPresenter.onFavCardChanged(favCards);
    }
}
