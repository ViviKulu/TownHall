package com.example.vivianbabiryekulumba.townhall.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.vivianbabiryekulumba.townhall.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MapViewHolder> {

    private NamedLocation[] namedLocations;
    Context context;

    public MapAdapter(NamedLocation[] namedLocations, Context context) {
        super();
        this.namedLocations = namedLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public MapAdapter.MapViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lite_mode_demo_row, parent, false);
        return new MapViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapAdapter.MapViewHolder holder, int position) {
        if(holder == null){
            return;
        }
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return namedLocations.length;
    }

    public class MapViewHolder extends RecyclerView.ViewHolder implements OnMapReadyCallback{

        MapView mapView;
        TextView title;
        GoogleMap map;
        View layout;

        public MapViewHolder(View itemView) {
            super(itemView);
            layout = itemView;
            mapView = layout.findViewById(R.id.lite_mode_list_row_map);
            title = layout.findViewById(R.id.lite_mode_list_row_text);

            if(mapView != null){
                mapView.onCreate(null);
                mapView.getMapAsync(this);
            }
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            MapsInitializer.initialize(context.getApplicationContext());
            map = googleMap;
            setMapLocation();
        }

        private void setMapLocation() {
            if(map == null) return;

            NamedLocation namedLocation = (NamedLocation) mapView.getTag();
            if(namedLocation == null) return;

            map.moveCamera(CameraUpdateFactory.newLatLngZoom(namedLocation.location, 13f));
            map.addMarker(new MarkerOptions().position(namedLocation.location));
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }


        public void onBind(int position) {
            NamedLocation item = namedLocations[position];
            layout.setTag(this);
            mapView.setTag(item);
            setMapLocation();
            title.setText(item.name);
        }
    }

    public static RecyclerView.RecyclerListener liteModeRecyclerListener = new RecyclerView.RecyclerListener() {

        @Override
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            MapAdapter.MapViewHolder mapViewHolder = (MapAdapter.MapViewHolder) holder;
            if(mapViewHolder != null && mapViewHolder.map != null){
                mapViewHolder.map.clear();
                mapViewHolder.map.setMapType(GoogleMap.MAP_TYPE_NONE);
            }
        }
    };

    public static class NamedLocation {

        public final String name;
        public final LatLng location;

        public NamedLocation(String name, LatLng location) {
            this.name = name;
            this.location = location;
        }

        public static final NamedLocation[] LIST_OF_LOCATIONS = new NamedLocation[]{
                new NamedLocation("Bronx", new LatLng(40.837048, -73.865433)),
                new NamedLocation("Brooklyn", new LatLng(40.650002, -73.949997)),
                new NamedLocation("Manhattan", new LatLng(40.730610, -73.935242)),
                new NamedLocation("Queens", new LatLng(40.742054, -73.769417)),
                new NamedLocation("Staten Island", new LatLng(40.579021, -74.151535)),
        };
    }
}
