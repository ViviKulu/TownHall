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
import com.example.vivianbabiryekulumba.townhall.models.CommBoard;

import java.util.List;

public class MoreDetailsAdapter extends RecyclerView.Adapter<MoreDetailsAdapter.ServiceFacilitiesViewHolder> {

    private List<CommBoard> moreDetailsList;
    private static final String TAG = "MoreDetailsFragAdapter";
    Context context;

    public MoreDetailsAdapter(List<CommBoard> serviceFacilitiesList, Context context) {
        this.moreDetailsList = serviceFacilitiesList;
        this.context = context;
    }

    @NonNull
    @Override
    public MoreDetailsAdapter.ServiceFacilitiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_details_item_view, parent, false);
        Log.d(TAG, "onCreateViewHolder: " + context);
        return new ServiceFacilitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreDetailsAdapter.ServiceFacilitiesViewHolder holder, int position) {
        final CommBoard moreDetails = moreDetailsList.get(position);

        holder.chair.setText("Chair of the board is: " + moreDetails.getCbInfo().getChair());
        holder.district_manager.setText("District manager of the board is: " + moreDetails.getCbInfo().getDistrictManager());
        holder.board_meeting.setText("Board meetings meet every: " + moreDetails.getCbInfo().getBoardMeeting());
        holder.cabinet_meeting.setText("Cabinet meetings meet every: " + moreDetails.getCbInfo().getCabinetMeeting());
    }

    @Override
    public int getItemCount() {
        return moreDetailsList.size();
    }


    public static class ServiceFacilitiesViewHolder extends RecyclerView.ViewHolder{

        TextView chair;
        TextView district_manager;
        TextView board_meeting;
        TextView cabinet_meeting;

        public ServiceFacilitiesViewHolder(View itemView) {
            super(itemView);

            chair = itemView.findViewById(R.id.more_details_chair_tv);
            district_manager = itemView.findViewById(R.id.more_details_district_manager_tv);
            board_meeting = itemView.findViewById(R.id.more_details_board_meeting_tv);
            cabinet_meeting = itemView.findViewById(R.id.more_details_cabinet_meeting_tv);
        }

    }
}
