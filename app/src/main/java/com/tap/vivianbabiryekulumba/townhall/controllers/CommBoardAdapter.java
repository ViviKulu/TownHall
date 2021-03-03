package com.tap.vivianbabiryekulumba.townhall.controllers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.tap.vivianbabiryekulumba.townhall.MainActivity;
import com.tap.vivianbabiryekulumba.townhall.R;
import com.tap.vivianbabiryekulumba.townhall.main_fragments.MoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.models.CommBoard;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tap.vivianbabiryekulumba.townhall.network_calls.BkMoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.network_calls.BxMoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.network_calls.MxMoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.network_calls.QuMoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.network_calls.StatsMoreDetailsFrag;

import java.util.List;

public class CommBoardAdapter extends RecyclerView.Adapter<CommBoardAdapter.CommBoardViewHolder> {

    private List<CommBoard> commBoardList;
    private static final String TAG = "CommBoardAdapter";
    private Context context;
    BxMoreDetailsFrag bxMoreDetailsFrag;
    BkMoreDetailsFrag bkMoreDetailsFrag;
    MxMoreDetailsFrag mxMoreDetailsFrag;
    QuMoreDetailsFrag quMoreDetailsFrag;
    StatsMoreDetailsFrag statsMoreDetailsFrag;

    public CommBoardAdapter(List<CommBoard> zipCodeList, Context context) {
        this.commBoardList = zipCodeList;
        this.context = context;
    }

    @NonNull
    @Override
    public CommBoardAdapter.CommBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comm_board_itemview_front_card, parent, false);
        context = parent.getContext();
        Log.d(TAG, "onCreateViewHolder: " + context);
        return new CommBoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CommBoardAdapter.CommBoardViewHolder holder, int position) {
        final CommBoard commBoard = commBoardList.get(position);

        holder.comm_Of_tv.setText(commBoard.getCommunityBoard() + " of " + commBoard.getLocation());
        holder.zip_code_tv.setText("zip codes include: " + commBoard.getZipCodes());
        holder.phone.setText("phone: " + commBoard.getCbInfo().getPhone());
        holder.fax.setText("fax: " + commBoard.getCbInfo().getFax());
        holder.email.setText("email: " + commBoard.getCbInfo().getEmail());
        holder.address.setText("get directions");
        holder.more_details.setText("more details");
        holder.website.setText("website: " + commBoard.getCbInfo().getWebsite());

        holder.bindView(position);

        //Intent of email to email services.
        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + commBoard.getCbInfo().getEmail())); // only email apps should handle this
                context.startActivity(intent);
                Log.d(TAG, "onClick: " + intent + commBoard.getCbInfo().getEmail() + context);
            }
        });

        //Intent of phone number to call services.
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + commBoard.getCbInfo().getPhone()));
                context.startActivity(intent);
                Log.d(TAG, "onClick: " + intent + commBoard.getCbInfo().getPhone() + context);
            }
        });

        holder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        double latitude = Double.parseDouble(commBoard.getCbInfo().getLatitude());
                        double longitude = Double.parseDouble(commBoard.getCbInfo().getLongitude());

                        String url = "https://www.google.com/maps/dir/?api=1&destination=" + latitude + "," + longitude + "&travelmode=transit";

                        Uri gmmIntentUri = Uri.parse(url);
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        context.startActivity(mapIntent);
                        Log.d(TAG, "onClick: maps" + gmmIntentUri);
                    }
                }).start();
            }
        });

        //Intent of Website to external source of actual website.
        holder.website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri website = Uri.parse(commBoard.getCbInfo().getWebsite());
                Intent intent = new Intent(Intent.ACTION_VIEW, website);
                context.startActivity(intent);
                Log.d(TAG, "onClick: " + intent + commBoard.getCbInfo().getWebsite() + context);
            }
        });

        Log.d(TAG, "onBindViewHolder: " + commBoardList.size());

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + commBoardList.size());
        return commBoardList.size();
    }

    public class CommBoardViewHolder extends RecyclerView.ViewHolder implements OnMapReadyCallback {

        TextView comm_Of_tv;
        TextView zip_code_tv;
        ImageView submit_petition;
        TextView phone;
        TextView fax;
        TextView email;
        TextView address;
        TextView more_details;
        TextView website;
        MapView mapView;
        TextView tapMap;
        GoogleMap map;
        Context context;

        public CommBoardViewHolder(View itemView) {
            super(itemView);

            comm_Of_tv = itemView.findViewById(R.id.comm_of_tv);
            zip_code_tv = itemView.findViewById(R.id.zip_code_tv);
            submit_petition = itemView.findViewById(R.id.submit_petition_button);
            more_details = itemView.findViewById(R.id.more_details_tv);
            phone = itemView.findViewById(R.id.phone_tv);
            fax = itemView.findViewById(R.id.fax_tv);
            email = itemView.findViewById(R.id.email_tv);
            address = itemView.findViewById(R.id.address_tv);
            website = itemView.findViewById(R.id.website_tv);
            tapMap = itemView.findViewById(R.id.tap_screen_tv);
            mapView = itemView.findViewById(R.id.mapView);
            if (mapView != null) {
                // Initialise the MapView
                mapView.onCreate(null);
                // Set the map ready callback to receive the GoogleMap object
                mapView.getMapAsync(this);
            }
            context = itemView.getContext();
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            MapsInitializer.initialize(context.getApplicationContext());
            map = googleMap;
            setMapLocation();
        }

        private void setMapLocation() {
            if (map == null) return;

            CommBoard data = (CommBoard) mapView.getTag();
            if (data == null) return;

            double latitude = Double.parseDouble(data.getCbInfo().getLatitude());
            double longitude = Double.parseDouble(data.getCbInfo().getLongitude());

            LatLng location = new LatLng(latitude, longitude);

            // Add a marker for this item and set the camera
            map.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 13f));
            map.addMarker(new MarkerOptions().position(location));

            Log.d(TAG, "setMapLocation: " + location);

            // Set the map type back to normal.
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }

        public void bindView(int position) {
            CommBoard commBoardData = commBoardList.get(position);
            mapView.setTag(commBoardData);
            setMapLocation();
        }
    }

    private RecyclerView.RecyclerListener mRecycleListener = new RecyclerView.RecyclerListener() {

        @Override
        public void onViewRecycled(RecyclerView.ViewHolder holder) {
            CommBoardAdapter.CommBoardViewHolder mapHolder = (CommBoardAdapter.CommBoardViewHolder) holder;
            if (mapHolder != null && mapHolder.map != null) {
                // Clear the map and free up resources by changing the map type to none.
                // Also reset the map when it gets reattached to layout, so the previous map would
                // not be displayed.
                mapHolder.map.clear();
                mapHolder.map.setMapType(GoogleMap.MAP_TYPE_NONE);
            }
        }
    };

}
