package com.example.vivianbabiryekulumba.townhall.views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.models.Petition;

public class PetitionViewHolder extends RecyclerView.ViewHolder {

    private TextView petition_title;
    private TextView petition_content;

    public PetitionViewHolder(View itemView) {
        super(itemView);
        petition_title = itemView.findViewById(R.id.petition_title_tv);
        petition_content = itemView.findViewById(R.id.petition_content_tv);
    }

    public void setPetition(Petition petition) {
        petition_title.setText(petition.getPetition_title());
        petition_content.setText(petition.getPetition_content());
    }
}
