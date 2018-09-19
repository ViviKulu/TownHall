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
import com.example.vivianbabiryekulumba.townhall.models.VolunteerDetails;

import java.util.List;

public class VolunteerAdapter extends RecyclerView.Adapter<VolunteerAdapter.VolunteerViewHolder> {

    private static final String TAG = "VolunteerAdapter";
    private List<VolunteerDetails> volunteerDetailsList;
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
        Log.d(TAG, "onCreateViewHolder: " + context);
        return new VolunteerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VolunteerViewHolder holder, int position) {
        final VolunteerDetails volunteerDetails = volunteerDetailsList.get(position);
        holder.title.setText(volunteerDetails.getTitle());
        holder.summary.setText(volunteerDetails.getSummary());
        holder.localityAddress.setText(volunteerDetails.getLocalityAddress());
        holder.localityCity.setText(volunteerDetails.getLocalityCity());
        holder.displayUrl.setText(volunteerDetails.getDisplayUrl());

//        holder.localityAddress.setOnClickListener(new View.OnClickListener() {
//            Uri uri = Uri.parse(volunteerDetails.getLocalityAddress());
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.putExtra("address", uri);
//                context.startActivity(intent);
//                Log.d(TAG, "onClick: " + uri + intent);
//            }
//        });
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
        TextView displayUrl;

        public VolunteerViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title_tv);
            summary = itemView.findViewById(R.id.summary_tv);
            localityAddress = itemView.findViewById(R.id.locality_address_tv);
            localityCity = itemView.findViewById(R.id.locality_city_tv);
            displayUrl = itemView.findViewById(R.id.display_url_tv);
        }
    }
}
