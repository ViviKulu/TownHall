package com.example.vivianbabiryekulumba.townhall.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.models.ZipCode;

import java.util.List;

public class CommBoardAdapter extends RecyclerView.Adapter<CommBoardAdapter.CommBoardViewHolder> {

    private List<ZipCode> zipCodeList;
    private static final String TAG = "CommBoardAdapter";

    public CommBoardAdapter(List<ZipCode> zipCodeList) {
        this.zipCodeList = zipCodeList;
    }

    @NonNull
    @Override
    public CommBoardAdapter.CommBoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comm_board_itemview_front_card, parent, false);
        return new CommBoardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommBoardAdapter.CommBoardViewHolder holder, int position) {
        holder.onBind(zipCodeList.get(position));
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
            district_manager = itemView.findViewById(R.id.district_manager_tv);
            board_meeting = itemView.findViewById(R.id.board_meeting_tv);
            cabinet_meeting = itemView.findViewById(R.id.cabinet_meeting_tv);
            precinct = itemView.findViewById(R.id.precinct_tv);
            precinct_phone = itemView.findViewById(R.id.precinct_phone_tv);
        }

        public void onBind(ZipCode zipCode) {
            comm_Of_tv.setText(zipCode.getCommunityBoard());
            zip_code_tv.setText(String.format("Zip code: %s", zipCode.getZipCode()));
            address.setText(String.format("Address: %s", zipCode.getCbInfo().getAddress()));
            phone.setText(String.format("Phone number: %s", zipCode.getCbInfo().getPhone()));
            fax.setText(String.format("Fax number : %s", zipCode.getCbInfo().getFax()));
            email.setText(String.format("Email: %s", zipCode.getCbInfo().getEmail()));
            website.setText(String.format("Website: %s", zipCode.getCbInfo().getWebsite()));
            chair.setText(String.format("Chair: %s", zipCode.getCbInfo().getChair()));
            district_manager.setText(String.format("District Manager: %s", zipCode.getCbInfo().getDistrictManager()));
            board_meeting.setText(String.format("Board meeting: %s", zipCode.getCbInfo().getBoardMeeting()));
            cabinet_meeting.setText(String.format("Cabinet meeting: %s", zipCode.getCbInfo().getCabinetMeeting()));
            precinct.setText(String.format("Precinct: %s", zipCode.getCbInfo().getPrecinct()));
            precinct_phone.setText(String.format("Precinct phone: %s", zipCode.getCbInfo().getPrecinctPhone()));
        }
    }
}
