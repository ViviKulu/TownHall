package com.example.vivianbabiryekulumba.townhall.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.database.Petitions;

import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class PetitionListAdapter extends RecyclerView.Adapter<PetitionListAdapter.PetitionListViewHolder> {

    private List<Petitions> petitionsList;
    Context context;

    public PetitionListAdapter(List<Petitions> petitionsList, Context context) {
        this.petitionsList = petitionsList;
        this.context = context;
    }

    @NonNull
    @Override
    public PetitionListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.petition_list_item_view, parent, false);
        return new PetitionListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetitionListViewHolder holder, int position) {
//        holder.onBind(petitionsList.get(position));
        holder.petition_title.setText(petitionsList.get(position).getPetition_title());
        holder.petition_content.setText(petitionsList.get(position).getPetition_content());
        Log.d(TAG, "onBindViewHolder: " + petitionsList.get(position).getPetition_title() + petitionsList.get(position).getPetition_content());
    }

    public void setPetitions(List<Petitions> petitions){
        petitionsList = petitions;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (petitionsList != null)
            return petitionsList.size();
        else return 0;
    }


    public class PetitionListViewHolder extends RecyclerView.ViewHolder {

        TextView petition_title;
        TextView petition_content;

        public PetitionListViewHolder(View itemView) {
            super(itemView);

            petition_title = itemView.findViewById(R.id.petition_list_title);
            petition_content = itemView.findViewById(R.id.petition_list_content);
        }


//        public void onBind(final Petitions petitions) {
//            petition_title.setText(petitions.getPetition_title());
//            petition_content.setText(petitions.getPetition_content());
//            Log.d(TAG, "onBind: " + petition_title + petition_content);
//        }
    }
}
