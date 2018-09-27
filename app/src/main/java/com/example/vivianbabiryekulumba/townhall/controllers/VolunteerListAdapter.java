package com.example.vivianbabiryekulumba.townhall.controllers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.database.FavCardListPresenter;

public class VolunteerListAdapter extends RecyclerView.Adapter<VolunteerListAdapter.VolunteerListViewHolder>{

    private static final String TAG = "VolunteerListAdapter";

    private FavCardListPresenter favCardListPresenter;

    public VolunteerListAdapter(FavCardListPresenter favCardListPresenter) {
        this.favCardListPresenter = favCardListPresenter;
    }

    @Override public VolunteerListAdapter.VolunteerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.vol_list_item_view, parent, false);
        return new VolunteerListViewHolder(view);
    }

    @Override public void onBindViewHolder(VolunteerListViewHolder holder, int position) {
        favCardListPresenter.bindView(holder, position);
    }

    @Override public int getItemCount() {
        return favCardListPresenter.getItemCount();
    }

    public static class VolunteerListViewHolder extends RecyclerView.ViewHolder
            implements FavCardListPresenter.FavCardListItem{

        TextView favorite_title;
        TextView favorite_summary;
        TextView favorite_local_address;
        TextView favorite_local_city;
        ImageView favorite_card;

        public VolunteerListViewHolder(View itemView) {
            super(itemView);
            favorite_title = itemView.findViewById(R.id.fav_title_tv);
            favorite_summary = itemView.findViewById(R.id.fav_summary_tv);
            favorite_local_address = itemView.findViewById(R.id.fav_locality_address_tv);
            favorite_local_city = itemView.findViewById(R.id.fav_locality_city_tv);
            favorite_card = itemView.findViewById(R.id.fav_favorite_iv);
        }


        @Override
        public void setFavCardTitle(String fav_title) {
            favorite_title.setText(fav_title);
        }

        @Override
        public void setFavCardSummary(String fav_summary) {
            favorite_summary.setText(fav_summary);
        }

        @Override
        public void setFavCardLocalAddress(String fav_locality_address) {
            favorite_local_address.setText(fav_locality_address);
        }

        @Override
        public void setFavCardLocalCity(String fav_locality_city) {
            favorite_local_city.setText(fav_locality_city);
        }
    }
}
