package com.update.vivianbabiryekulumba.townhall.main_fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.update.vivianbabiryekulumba.townhall.MapsActivity;
import com.update.vivianbabiryekulumba.townhall.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    GoogleMap mGoogleMap;
    private MapView mapView;
    private Double commBoardLag;
    private Double commBoardLong;
    private String address;
    FrameLayout frameLayout;

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        mapView = rootView.findViewById(R.id.map);
        getCoordinates();
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (commBoardLag != null && commBoardLong != null) {
            googleMap.addMarker(new MarkerOptions()
                    .position(new LatLng(commBoardLag, commBoardLong))
                    .title(address)
                    .snippet("Community Board Address"));

            CameraPosition restaurant = CameraPosition.builder()
                    .target(new LatLng(commBoardLag, commBoardLong))
                    .zoom(16)
                    .bearing(0)
                    .tilt(45)
                    .build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(restaurant));
        } else {
            if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                    (getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            googleMap.setMyLocationEnabled(true);
            CameraPosition myLocation = CameraPosition.builder()
                    .target(new LatLng(MapsActivity.getCurrentLatitude(), MapsActivity.getCurrentLongitude()))
                    .zoom(16)
                    .bearing(0)
                    .tilt(45)
                    .build();
            googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(myLocation));
        }

        }

    public void getCoordinates() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            commBoardLong = bundle.getDouble("long");
            commBoardLag = bundle.getDouble("lag");
            address = bundle.getString("address");
            Log.d("geoLocate ", address + " " + commBoardLag + ", " + commBoardLong);
        }
    }
}
