package com.example.vivianbabiryekulumba.townhall.recycler;

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

        holder.address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri getAddressUri = Uri.parse(commBoard.getCbInfo().getAddress());
                Log.d(TAG, "onClick: " + getAddressUri);
                Intent mapIntent = new Intent();
                mapIntent.putExtra("address", getAddressUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                context.startActivity(mapIntent);
                Log.d(TAG, "onClick: " + mapIntent + getAddressUri + context);
            }
        });

//        holder.email.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bundle
//            }
//        });
//        Log.d(TAG, "onBindViewHolder: " + zipCodeList.size());
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
