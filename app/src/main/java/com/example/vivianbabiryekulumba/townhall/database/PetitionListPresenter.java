package com.example.vivianbabiryekulumba.townhall.database;

import android.util.Log;

public class PetitionListPresenter {
    private PetitionDao petitionDao;
    private Petition[] petitions = {};
    private PetitionListPresentation petitionListPresentation;

    public PetitionListPresenter(PetitionDao petitionDao) {
        this.petitionDao = petitionDao;
    }

    public void attach(PetitionListPresentation presentation) {
        this.petitionListPresentation = presentation;
    }

    public void detach() {
        petitionListPresentation = null;
    }

    public void onAddPetitionButtonClicked() {
        if (petitionListPresentation != null) {
            petitionListPresentation.showAddPetitionDialog();
        }
    }

    public void addPetition(final String title, String content) {
        Log.d("Presenter", "Adding Task: " + title + content);
        new Thread(new Runnable() {
            @Override public void run() {
                petitionDao.addPetition(new Petition(title, content));
            }
        }).start();
    }

    public void bindView(PetitionListItem listItem, int position) {
        listItem.setPetitionTitle(petitions[position].petition_title);
        listItem.setPetitionContent(petitions[position].petition_content);
    }

    public int getItemCount() {
        return petitions.length;
    }

    public void onPetitionChanged(Petition[] petitions) {
        this.petitions = petitions;

        if (petitionListPresentation != null) {
            petitionListPresentation.notifyDataSetChanged();
        }
    }

    public interface PetitionListPresentation{
        void showAddPetitionDialog();
        void notifyDataSetChanged();
    }

    public interface PetitionListItem{
        void setPetitionTitle(String title);
        void setPetitionContent(String content);
    }



}
