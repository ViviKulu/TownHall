package com.tap.vivianbabiryekulumba.townhall.controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tap.vivianbabiryekulumba.townhall.R;
import com.tap.vivianbabiryekulumba.townhall.models.CommBoard;
import java.util.List;

public class MoreDetailsAdapter extends RecyclerView.Adapter<MoreDetailsAdapter.MoreDetailsViewHolder> {

    private List<CommBoard> moreDetailsList;
    private static final String TAG = "MoreDetailsFragAdapter";
    Context moreDetailsContext;

    public MoreDetailsAdapter(List<CommBoard> moreDetailsList, Context context) {
        this.moreDetailsList = moreDetailsList;
        this.moreDetailsContext = context;
    }

    @NonNull
    @Override
    public MoreDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.more_details_item_view, parent, false);
        Log.d(TAG, "onCreateViewHolder: " + moreDetailsContext);
        return new MoreDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoreDetailsViewHolder holder, int position) {
        final CommBoard moreDetails = moreDetailsList.get(position);
        holder.community_board.setText(moreDetails.getCommunityBoard() + " of " + moreDetails.getLocation());
        holder.chair.setText("Chair of the board is: " + moreDetails.getCbInfo().getChair());
        holder.district_manager.setText("District manager of the board is: " + moreDetails.getCbInfo().getDistrictManager());
        holder.board_meeting.setText("Board meetings meet every: " + moreDetails.getCbInfo().getBoardMeeting());
        holder.cabinet_meeting.setText("Cabinet meetings meet every: " + moreDetails.getCbInfo().getCabinetMeeting());
    }

    @Override
    public int getItemCount() {
        return moreDetailsList.size();
    }


    public static class MoreDetailsViewHolder extends RecyclerView.ViewHolder{

        TextView community_board;
        TextView chair;
        TextView district_manager;
        TextView board_meeting;
        TextView cabinet_meeting;

        public MoreDetailsViewHolder(View itemView) {
            super(itemView);

            community_board = itemView.findViewById(R.id.more_details_comm_board_tv);
            chair = itemView.findViewById(R.id.more_details_chair_tv);
            district_manager = itemView.findViewById(R.id.more_details_district_manager_tv);
            board_meeting = itemView.findViewById(R.id.more_details_board_meeting_tv);
            cabinet_meeting = itemView.findViewById(R.id.more_details_cabinet_meeting_tv);
        }

    }
}
