package com.update.vivianbabiryekulumba.townhall.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.update.vivianbabiryekulumba.townhall.R;
import com.update.vivianbabiryekulumba.townhall.database.PetitionListPresenter;

public class PetitionListAdapter extends RecyclerView.Adapter<PetitionListAdapter.PetitionListViewHolder> {

    private static final String TAG = "PetitionListAdapter";

    private final PetitionListPresenter petitionListPresenter;

    public PetitionListAdapter(PetitionListPresenter petitionListPresenter) {
        this.petitionListPresenter = petitionListPresenter;
    }

    @Override public PetitionListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.petition_activity_item_view, parent, false);
        return new PetitionListViewHolder(view);
    }

    @Override public void onBindViewHolder(PetitionListViewHolder holder, int position) {
        petitionListPresenter.bindView(holder, position);
    }

    @Override public int getItemCount() {
        return petitionListPresenter.getItemCount();
    }

    public static class PetitionListViewHolder extends RecyclerView.ViewHolder
            implements PetitionListPresenter.PetitionListItem {
        private TextView petition_title;
        private TextView petition_content;

        public PetitionListViewHolder(View itemView) {
            super(itemView);
            petition_title = itemView.findViewById(R.id.petition_title_tv);
            petition_content = itemView.findViewById(R.id.petition_content_tv);
        }

        @Override public void setPetitionTitle(String petitionTitle) {
            petition_title.setText(petitionTitle);
        }

        @Override
        public void setPetitionContent(String petitionContent){
            petition_content.setText(petitionContent);
        }
    }

}
