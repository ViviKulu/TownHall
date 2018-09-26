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

public class ServiceFacilitiesAdapter extends RecyclerView.Adapter<ServiceFacilitiesAdapter.ServiceFacilitiesViewHolder> {

    private List<ServiceFacilities> serviceFacilitiesList;
    private static final String TAG = "ServiceFacAdapter";
    Context context;

    public ServiceFacilitiesAdapter(List<ServiceFacilities> serviceFacilitiesList, Context context) {
        this.serviceFacilitiesList = serviceFacilitiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public ServiceFacilitiesAdapter.ServiceFacilitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_facilities_item_view, parent, false);
        context = parent.getContext();
        Log.d(TAG, "onCreateViewHolder: " + context);
        return new ServiceFacilitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServiceFacilitiesAdapter.ServiceFacilitiesViewHolder holder, int position) {
        final ServiceFacilities serviceFacilities = serviceFacilitiesList.get(position);

        holder.facname.setText(serviceFacilities.getFacname());
        holder.overagency.setText(serviceFacilities.getOveragency());
        holder.address.setText(serviceFacilities.getAddress());
        holder.opname.setText(serviceFacilities.getOpname());
        holder.boro.setText(serviceFacilities.getBoro());
        holder.city.setText(serviceFacilities.getCity());
        holder.commboard.setText(serviceFacilities.getCommboard());
        holder.factype.setText(serviceFacilities.getFactype());

//        holder.address.setOnClickListener(new View.OnClickListener() {
//
//            Uri uri1 = Uri.parse(serviceFacilities.getLatitude());
//            Uri uri2 = Uri.parse(serviceFacilities.getLongitude());
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.putExtra("latitude", uri1);
//                intent.putExtra("longitude", uri2);
//                context.startActivity(intent);
//                Log.d(TAG, "onClick: " + uri1 + uri2 + intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return serviceFacilitiesList.size();
    }

    public class ServiceFacilitiesViewHolder extends RecyclerView.ViewHolder {

        TextView facname;
        TextView overagency;
        TextView opname;
        TextView factype;
        TextView boro;
        TextView city;
        TextView commboard;
        TextView address;

        public ServiceFacilitiesViewHolder(View itemView) {
            super(itemView);
            facname = itemView.findViewById(R.id.facname_tv);
            overagency = itemView.findViewById(R.id.overagency_tv);
            opname = itemView.findViewById(R.id.opname_tv);
            factype = itemView.findViewById(R.id.factype_tv);
            boro = itemView.findViewById(R.id.fac_boro_tv);
            city = itemView.findViewById(R.id.fac_city_tv);
            commboard = itemView.findViewById(R.id.fac_comm_board_tv);
            address = itemView.findViewById(R.id.fac_address_tv);
        }
    }
}
