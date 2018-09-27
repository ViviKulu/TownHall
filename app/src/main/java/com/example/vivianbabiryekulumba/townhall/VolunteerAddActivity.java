package com.example.vivianbabiryekulumba.townhall;

import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.vivianbabiryekulumba.townhall.database.AppApplication;
import com.example.vivianbabiryekulumba.townhall.database.FavCard;
import com.example.vivianbabiryekulumba.townhall.database.FavCardDao;
import com.example.vivianbabiryekulumba.townhall.database.FavCardDatabase;
import com.example.vivianbabiryekulumba.townhall.database.FavCardListPresenter;
import com.example.vivianbabiryekulumba.townhall.database.FavCardObserver;

public class VolunteerAddActivity extends AppCompatActivity {

    private static final String TAG = "VolunteerAddActivity";
    FavCardListPresenter favCardListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_add);

        Bundle bundle = getIntent().getExtras();

        String fav_title = bundle.getString("fav_title");
        String fav_summary = bundle.getString("fav_summary");
        String fav_local_address = bundle.getString("fav_local_address");
        String fav_local_city = bundle.getString("fav_local_city");

        FavCardDatabase db = ((AppApplication) getApplication()).getFavCardDatabase();
        FavCardDao favCardDao = db.favCardDao();

        favCardListPresenter = new FavCardListPresenter(favCardDao);

        LiveData<FavCard[]> favCards = favCardDao.getAllFavCards();
        favCards.observe(this, new FavCardObserver(favCardListPresenter));

        favCardListPresenter.addFavCard(fav_title, fav_summary, fav_local_address, fav_local_city);
        Log.d(TAG, "onCreate: added to db");

        Intent intent = new Intent(this, VolunteerListActivity.class);
        startActivity(intent);
    }
}
