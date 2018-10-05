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
import com.example.vivianbabiryekulumba.townhall.models.ServiceFacilities;

import java.util.List;

public class MoreDetailsAdapter extends RecyclerView.Adapter<MoreDetailsAdapter.ServiceFacilitiesViewHolder> {

    private List<ServiceFacilities> serviceFacilitiesList;
    private static final String TAG = "ServiceFacAdapter";
    static Context context;

    public MoreDetailsAdapter(List<ServiceFacilities> serviceFacilitiesList, Context context) {
        this.serviceFacilitiesList = serviceFacilitiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MoreDetailsAdapter.ServiceFacilitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_details_item_view, parent, false);
        context = parent.getContext();
        Log.d(TAG, "onCreateViewHolder: " + context);
        return new ServiceFacilitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreDetailsAdapter.ServiceFacilitiesViewHolder holder, int position) {
        final ServiceFacilities serviceFacilities = serviceFacilitiesList.get(position);

        holder.facname.setText("Facility:\n" + serviceFacilities.getFacname());
        holder.overagency.setText("Over Agency:\n" + serviceFacilities.getOveragency());
        holder.address.setText("Address:\n" + serviceFacilities.getAddress());
        holder.city.setText("City:\n" + serviceFacilities.getCity());
        holder.factype.setText(serviceFacilities.getFactype());
    }

    @Override
    public int getItemCount() {
        return serviceFacilitiesList.size();
    }


    public static class ServiceFacilitiesViewHolder extends RecyclerView.ViewHolder{

        TextView facname;
        TextView overagency;
        TextView factype;
        TextView city;
        TextView address;

        public ServiceFacilitiesViewHolder(View itemView) {
            super(itemView);

            facname = itemView.findViewById(R.id.facname_tv);
            overagency = itemView.findViewById(R.id.overagency_tv);
            factype = itemView.findViewById(R.id.factype_tv);
            city = itemView.findViewById(R.id.fac_city_tv);
            address = itemView.findViewById(R.id.fac_address_tv);
        }

    }
}
