package com.example.vivianbabiryekulumba.townhall.controllers;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.PetitionAddActivity;
import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.models.CommBoard;

import java.util.List;

public class CommBoardAdapter extends RecyclerView.Adapter<CommBoardAdapter.CommBoardViewHolder> {

    private List<CommBoard> zipCodeList;
    private static final String TAG = "CommBoardAdapter";

    Context context;

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
        holder.submit_petition.setText("Submit Petition");
        holder.phone.setText(String.format("Phone number: %s", commBoard.getCbInfo().getPhone()));
        holder.fax.setText(String.format("Fax number : %s", commBoard.getCbInfo().getFax()));
        holder.email.setText(String.format("Email: %s", commBoard.getCbInfo().getEmail()));
        holder.website.setText(String.format("Website: %s", commBoard.getCbInfo().getWebsite()));
        holder.chair.setText(String.format("Chair: %s", commBoard.getCbInfo().getChair()));
        holder.district_manager.setText(String.format("District Manager: %s", commBoard.getCbInfo().getDistrictManager()));
        holder.board_meeting.setText(String.format("Board meeting: %s", commBoard.getCbInfo().getBoardMeeting()));
        holder.cabinet_meeting.setText(String.format("Cabinet meeting: %s", commBoard.getCbInfo().getCabinetMeeting()));
        holder.precinct.setText(String.format("Precinct: %s", commBoard.getCbInfo().getPrecinct()));
        holder.precinct_phone.setText(String.format("Precinct phone: %s", commBoard.getCbInfo().getPrecinctPhone()));

        //Intent of address to google maps.
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

        holder.submit_petition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: made it to the comm board adapter submit button");
                Intent intent = new Intent(context, PetitionAddActivity.class);
                context.startActivity(intent);
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

        //Intent to search for chair.
        holder.chair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, commBoard.getCbInfo().getChair());
                context.startActivity(intent);
                Log.d(TAG, "onClick: " + intent + commBoard.getCbInfo().getChair());
            }
        });

        //Intent to search for district manager.
        holder.district_manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, commBoard.getCbInfo().getChair());
                context.startActivity(intent);
                Log.d(TAG, "onClick: " + intent + commBoard.getCbInfo().getDistrictManager());
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

        //Intent of precinct phone to call services.
        holder.precinct_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + commBoard.getCbInfo().getPrecinctPhone()));
                context.startActivity(intent);
                Log.d(TAG, "onClick: " + intent + commBoard.getCbInfo().getPrecinctPhone() + context);
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
        TextView submit_petition;
        TextView phone;
        TextView fax;
        TextView email;
        TextView website;
        TextView chair;
        TextView district_manager;
        TextView board_meeting;
        TextView cabinet_meeting;
        TextView precinct;
        TextView precinct_phone;
        Context context;

        public CommBoardViewHolder(View itemView) {
            super(itemView);

            comm_Of_tv = itemView.findViewById(R.id.comm_of_tv);
            zip_code_tv = itemView.findViewById(R.id.zip_code_tv);
            address = itemView.findViewById(R.id.address_tv);
            submit_petition = itemView.findViewById(R.id.submit_petition);
            phone = itemView.findViewById(R.id.phone_tv);
            fax = itemView.findViewById(R.id.fax_tv);
            email = itemView.findViewById(R.id.email_tv);
            website = itemView.findViewById(R.id.website_tv);
            chair = itemView.findViewById(R.id.chair_tv);
            context = itemView.getContext();
            district_manager = itemView.findViewById(R.id.district_manager_tv);
            board_meeting = itemView.findViewById(R.id.board_meeting_tv);
            cabinet_meeting = itemView.findViewById(R.id.cabinet_meeting_tv);
            precinct = itemView.findViewById(R.id.precinct_tv);
            precinct_phone = itemView.findViewById(R.id.precinct_phone_tv);
        }
    }
}
