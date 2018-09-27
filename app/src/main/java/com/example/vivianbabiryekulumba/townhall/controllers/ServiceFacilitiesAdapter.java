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
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class ServiceFacilitiesAdapter extends RecyclerView.Adapter<ServiceFacilitiesAdapter.ServiceFacilitiesViewHolder> {

    private List<ServiceFacilities> serviceFacilitiesList;
//    private final HashSet<MapView> mMaps = new HashSet<>();
    private static final String TAG = "ServiceFacAdapter";
    static LatLng location;
    static Context context;

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

//        location = new LatLng(Double.parseDouble(serviceFacilities.getLatitude()), Double.parseDouble(serviceFacilities.getLongitude()));

        holder.facname.setText(serviceFacilities.getFacname());
        holder.overagency.setText(serviceFacilities.getOveragency());
        holder.address.setText(serviceFacilities.getAddress());
        holder.opname.setText(serviceFacilities.getOpname());
        holder.boro.setText(serviceFacilities.getBoro());
        holder.city.setText(serviceFacilities.getCity());
        holder.commboard.setText(serviceFacilities.getCommboard());
        holder.factype.setText(serviceFacilities.getFactype());
//        holder.initializeMapView();
//        mMaps.add(holder.mapView);
    }

    @Override
    public int getItemCount() {
        return serviceFacilitiesList.size();
    }

//    public HashSet<MapView> getMaps() {
//        return mMaps;
//    }

//    private static void setMapLocation(GoogleMap map, LatLng latLng) {
//        // Add a marker for this item and set the camera
////        LatLng latLng = new google.maps.LatLng(data.lat, data.lng);
//        map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 13f));
//        map.addMarker(new MarkerOptions().position(location));
//
//        // Set the map type back to normal.
//        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//    }

    public static class ServiceFacilitiesViewHolder extends RecyclerView.ViewHolder{

        TextView facname;
        TextView overagency;
        TextView opname;
        TextView factype;
        TextView boro;
        TextView city;
        TextView commboard;
        TextView address;
        MapView mapView;
        GoogleMap map;
        View layout;

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
//            mapView = itemView.findViewById(R.id.map);
//            layout = itemView;
//            if (mapView != null) {
//                mapView.getMapAsync(this::onMapReady);
//            }
        }

//        @Override
//        public void onMapReady(GoogleMap googleMap) {
//            MapsInitializer.initialize(context);
//            map = googleMap;
//            if (location != null) {
//                setMapLocation(map, location);
//            }
//        }

//        public void initializeMapView() {
//            if (mapView != null) {
//                // Initialise the MapView
//                mapView.onCreate(null);
//                // Set the map ready callback to receive the GoogleMap object
//                mapView.getMapAsync(this);
//            }
//        }
//
//        public static RecyclerView.RecyclerListener mRecycleListener = new RecyclerView.RecyclerListener() {
//
//            @Override
//            public void onViewRecycled(RecyclerView.ViewHolder holder) {
//                ServiceFacilitiesViewHolder serviceFacilitiesViewHolder = (ServiceFacilitiesViewHolder) holder;
//                if (serviceFacilitiesViewHolder != null && serviceFacilitiesViewHolder.map != null) {
//                    serviceFacilitiesViewHolder.map.clear();
//                    serviceFacilitiesViewHolder.map.setMapType(GoogleMap.MAP_TYPE_NONE);
//                }
//            }
//        };

    }
}
