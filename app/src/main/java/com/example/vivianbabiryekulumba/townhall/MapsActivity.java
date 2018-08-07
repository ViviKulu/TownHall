package com.example.vivianbabiryekulumba.townhall;

import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;
    private SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.ACCESS_COARSE_LOCATION}, 1020);
        } else {
            mMap.setMyLocationEnabled(true);
            mFusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            //Start point
                            if (location != null) {
                                // Logic to handle location object
                                double lat = location.getLatitude();
                                double lng = location.getLongitude();
                                mMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)));
//                                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 15.0f));
                                getEndpoints();
                            }
                        }
                    });
        }
    }

    private void getEndpoints() {
        Geocoder coder = new Geocoder(getApplicationContext());
        List<Address> address;
        List<Address> address2;
        List<Address> address3;
        List<Address> address4;
        List<Address> address5;
        List<Address> address6;
        List<Address> address7;
        List<Address> address8;
        List<Address> address9;
        List<Address> address10;
        List<Address> address11;
        List<Address> address12;
        LatLng p1;
        LatLng p2;
        LatLng p3;
        LatLng p4;
        LatLng p5;
        LatLng p6;
        LatLng p7;
        LatLng p8;
        LatLng p9;
        LatLng p10;
        LatLng p11;
        LatLng p12;

        try {
            // May throw an IOException
            address = coder.getFromLocationName("Bronx Community Board 1, 3024 Third Avenue, Bronx, NY 10455", 5);
            if (address != null) {
                Address location = address.get(0);
                p1 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p1));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address2 = coder.getFromLocationName("Bronx Community Board 2, 1029 E. 163rd Street, Suite 202, Bronx, NY 10459", 5);
            if (address2 != null) {
                Address location = address2.get(0);
                p2 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p2));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address3 = coder.getFromLocationName("Bronx Community Board 3, 1426 Boston Road, Bronx, NY 10456", 5);
            if (address3 != null) {
                Address location = address3.get(0);
                p3 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p3));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address4 = coder.getFromLocationName("Bronx Community Board 4, 1650 Selwyn Avenue, #11A, Bronx, NY 10457", 5);
            if (address4 != null) {
                Address location = address4.get(0);
                p4 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p4));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address5 = coder.getFromLocationName("Bronx Community Board 5, BCC Campus, McCracken Hall, Room 12/13, W. 181st Street at Dr. Martin Luther King, Jr. Blvd. Bronx, NY 10453", 5);
            if (address5 != null) {
                Address location = address5.get(0);
                p5 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p5));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address6 = coder.getFromLocationName("Bronx Community Board 6 1932 Arthur Avenue, Rm. 709, Bronx, NY 10457", 5);
            if (address6 != null) {
                Address location = address6.get(0);
                p6 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p6));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address7 = coder.getFromLocationName("Bronx Community Board 7, 229-A East 204th Street, Bronx, NY 10458", 5);
            if (address7 != null) {
                Address location = address7.get(0);
                p7 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p7));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address8 = coder.getFromLocationName("Bronx Community Board 8, 5676 Riverdale Avenue, Bronx, NY 10471", 5);
            if (address8 != null) {
                Address location = address8.get(0);
                p8 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p8));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address9 = coder.getFromLocationName("Bronx Community Board 9, 1967 Turnbull Avenue, Rm. 7, Bronx, NY 10473", 5);
            if (address9 != null) {
                Address location = address9.get(0);
                p9 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p9));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address10 = coder.getFromLocationName("Bronx Community Board 10, 3165 East Tremont Avenue, Bronx, NY 10461", 5);
            if (address10 != null) {
                Address location = address10.get(0);
                p10 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p10));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address11 = coder.getFromLocationName("Bronx Community Board 11, 1741 Colden Avenue, Bronx, NY 10462", 5);
            if (address11 != null) {
                Address location = address11.get(0);
                p11 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p11));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            // May throw an IOException
            address12 = coder.getFromLocationName("Bronx Community Board 12, 4101 White Plains Road, Bronx, NY 10466", 5);
            if (address12 != null) {
                Address location = address12.get(0);
                p12 = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(p12));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
