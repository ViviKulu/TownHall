package com.example.vivianbabiryekulumba.townhall.controllers;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.VolunteerAddActivity;
import com.example.vivianbabiryekulumba.townhall.database.FavCardListPresenter;
import com.example.vivianbabiryekulumba.townhall.models.VolunteerDetails;

import java.util.List;

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.VolunteerViewHolder>{

    private static final String TAG = "VolunteerAdapter";
    private List<VolunteerDetails> volunteerDetailsList;
    FavCardListPresenter favCardListPresenter;
    Context context;

    public VolunteerAdapter(List<VolunteerDetails> volunteerDetailsList, Context context) {
        this.volunteerDetailsList = volunteerDetailsList;
        this.context = context;
    }

    @NonNull
    @Override
    public VolunteerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.volunteer_frag_item_view, parent, false);
        context = parent.getContext();
        return new VolunteerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolunteerViewHolder holder, int position) {
        final VolunteerDetails volunteerDetails = volunteerDetailsList.get(position);
        holder.title.setText(volunteerDetails.getTitle());
        holder.summary.setText(volunteerDetails.getSummary());
        holder.localityAddress.setText(volunteerDetails.getLocalityAddress());
        holder.localityCity.setText(volunteerDetails.getLocalityCity());
        holder.favorite_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.favorite_heart.setImageResource(R.drawable.favorite_heart);
                Bundle bundle = new Bundle();
                bundle.putString("fav_title", volunteerDetails.getTitle());
                bundle.putString("fav_summary", volunteerDetails.getSummary());
                bundle.putString("fav_local_address", volunteerDetails.getLocalityAddress());
                bundle.putString("fav_local_city", volunteerDetails.getLocalityCity());
                Intent intent = new Intent(context, VolunteerAddActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
                Log.d(TAG, "onClick: bundled!" + bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return volunteerDetailsList.size();
    }


    public class VolunteerViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView summary;
        TextView localityAddress;
        TextView localityCity;
        ImageView favorite_heart;

        public VolunteerViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_tv);
            summary = itemView.findViewById(R.id.summary_tv);
            localityAddress = itemView.findViewById(R.id.locality_address_tv);
            localityCity = itemView.findViewById(R.id.locality_city_tv);
            favorite_heart = itemView.findViewById(R.id.favorite_iv);
        }

    }
}
