package com.example.vivianbabiryekulumba.townhall.controllers;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.MainActivity;
import com.example.vivianbabiryekulumba.townhall.PetitionAddActivity;
import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.main_fragments.MoreDetailsFrag;
import com.example.vivianbabiryekulumba.townhall.models.CommBoard;
import com.example.vivianbabiryekulumba.townhall.network_calls.BkRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_calls.BxRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_calls.MxRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_calls.QuRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_calls.StatRetroFragment;

import java.util.List;

public class CommBoardAdapter extends RecyclerView.Adapter<CommBoardAdapter.CommBoardViewHolder> {

    private List<CommBoard> zipCodeList;
    private static final String TAG = "CommBoardAdapter";
    Context context;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public CommBoardAdapter(List<CommBoard> zipCodeList, Context context) {
        this.zipCodeList = zipCodeList;
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
        final CommBoard commBoard = zipCodeList.get(position);

        holder.comm_Of_tv.setText(commBoard.getCommunityBoard());
        holder.zip_code_tv.setText(String.format("Zip codes: %s", commBoard.getZipCodes()));
        holder.address.setText(String.format("Address: %s", commBoard.getCbInfo().getAddress()));
        holder.phone.setText(String.format("p: %s", commBoard.getCbInfo().getPhone()));
        holder.fax.setText(String.format("f: %s", commBoard.getCbInfo().getFax()));
        holder.email.setText(String.format("e: %s", commBoard.getCbInfo().getEmail()));
        holder.website.setText(String.format("w: %s", commBoard.getCbInfo().getWebsite()));

        holder.address.setOnClickListener(new View.OnClickListener() {

            Uri uri1 = Uri.parse(commBoard.getCbInfo().getLatitude());
            Uri uri2 = Uri.parse(commBoard.getCbInfo().getLongitude());

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.putExtra("latitude", uri1);
                intent.putExtra("longitude", uri2);
                context.startActivity(intent);
                Log.d(TAG, "onClick: " + uri1 + uri2 + intent);
            }
        });


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
        Log.d(TAG, "onBindViewHolder: " + zipCodeList.size());

        holder.submit_petition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PetitionAddActivity.class);
                context.startActivity(intent);
            }
        });

        holder.more_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoreDetailsFrag moreDetailsFrag = new MoreDetailsFrag();
                String myLocation = commBoard.getLocation();
                Bundle bundle = new Bundle();
                bundle.putString("location", myLocation);
                moreDetailsFrag.setArguments(bundle);
                Log.d(TAG, "onClick: more details " + bundle);
                ((FragmentActivity) v.getContext()).getSupportFragmentManager().beginTransaction()
                        .replace(R.id.more_details_container, moreDetailsFrag)
                        .commit();
                viewPager = ((MainActivity) v.getContext()).findViewById(R.id.viewpager);
                viewPager.post(new Runnable() {
                    @Override
                    public void run() {
                        viewPager.setCurrentItem(1, true);
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + zipCodeList.size());
        return zipCodeList.size();
    }

    public class CommBoardViewHolder extends RecyclerView.ViewHolder {

        TextView comm_Of_tv;
        TextView zip_code_tv;
        TextView address;
        Button submit_petition;
        Button more_details;
        TextView phone;
        TextView fax;
        TextView email;
        TextView website;
        ImageView website_iv;
        ImageView telephone_iv;
        ImageView fax_iv;
        ImageView email_iv;
        ImageView address_iv;
        Context context;

        public CommBoardViewHolder(View itemView) {
            super(itemView);

            comm_Of_tv = itemView.findViewById(R.id.comm_of_tv);
            zip_code_tv = itemView.findViewById(R.id.zip_code_tv);
            address = itemView.findViewById(R.id.address_tv);
            submit_petition = itemView.findViewById(R.id.submit_petition_button);
            more_details = itemView.findViewById(R.id.more_details_button);
            phone = itemView.findViewById(R.id.phone_tv);
            fax = itemView.findViewById(R.id.fax_tv);
            email = itemView.findViewById(R.id.email_tv);
            website = itemView.findViewById(R.id.website_tv);
            website_iv = itemView.findViewById(R.id.website_iv);
            telephone_iv = itemView.findViewById(R.id.telephone_iv);
            fax_iv = itemView.findViewById(R.id.fax_iv);
            email_iv = itemView.findViewById(R.id.email_iv);
            address_iv = itemView.findViewById(R.id.address_iv);
            context = itemView.getContext();
        }

    }
}
