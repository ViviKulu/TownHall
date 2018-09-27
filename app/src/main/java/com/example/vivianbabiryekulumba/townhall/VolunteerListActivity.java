package com.example.vivianbabiryekulumba.townhall;

import android.arch.lifecycle.LiveData;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.vivianbabiryekulumba.townhall.controllers.VolunteerListAdapter;
import com.example.vivianbabiryekulumba.townhall.database.AppApplication;
import com.example.vivianbabiryekulumba.townhall.database.FavCard;
import com.example.vivianbabiryekulumba.townhall.database.FavCardDao;
import com.example.vivianbabiryekulumba.townhall.database.FavCardDatabase;
import com.example.vivianbabiryekulumba.townhall.database.FavCardListPresenter;
import com.example.vivianbabiryekulumba.townhall.database.FavCardObserver;
import com.example.vivianbabiryekulumba.townhall.main_fragments.CommBoardsFrag;
import com.example.vivianbabiryekulumba.townhall.models.VolunteerDetails;

import java.util.Arrays;
import java.util.List;

public class VolunteerListActivity extends AppCompatActivity implements FavCardListPresenter.FavCardListPresentation,NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "FavVolOppActivity.class";
    public FavCardListPresenter favCardListPresenter;
    private List<VolunteerDetails> volunteerDetailsList;
    RecyclerView favCardRecyclerview;
    NavigationView navigationView;
    private DrawerLayout mDrawerLayout;



    String[] boroughs = new String[]{
            "Bronx",
            "Brooklyn",
            "Manhattan",
            "Queens",
            "Staten Island"
    };

    final List<String> boroughsList = Arrays.asList(boroughs);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_opp);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.nav_view);
        favCardRecyclerview = findViewById(R.id.fav_vol_opp_recyclerview);

        FavCardDatabase favCardDatabase = ((AppApplication) getApplication()).getFavCardDatabase();
        FavCardDao dao = favCardDatabase.favCardDao();

        favCardListPresenter = new FavCardListPresenter(dao);

        favCardRecyclerview.setAdapter(new VolunteerListAdapter(favCardListPresenter));

        LiveData<FavCard[]> favCards = dao.getAllFavCards();
        favCards.observe(this, new FavCardObserver(favCardListPresenter));

        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setHomeAsUpIndicator(R.drawable.list_white);
        setNavigationViewListener();

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );

    }

    private void setNavigationViewListener() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        // set item as selected to persist highlight
        menuItem.setChecked(true);
        // close drawer when item is tapped
        mDrawerLayout.closeDrawers();

        // Add code here to update the UI based on the item selected
        // For example, swap UI fragments here

        Log.d(TAG, "onNavigationItemSelected: made it to onNavItemSelected");

        int id = menuItem.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(VolunteerListActivity.this, MainActivity.class);
            startActivity(intent);
            buildAlertDialog();
            Log.d(TAG, "onNavigationItemSelected: made it to home from list");
        } else if (id == R.id.nav_petitions) {
            Intent intent = new Intent(getApplicationContext(), PetitionListActivity.class);
            startActivity(intent);
            //Start database
        } else if (id == R.id.nav_opportunities) {
            Intent intent2 = new Intent(getApplicationContext(), VolunteerListActivity.class);
            startActivity(intent2);
            //Start database
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buildAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(VolunteerListActivity.this);
        builder.setTitle("Select your borough");

        for (int i = 0; i < boroughsList.size(); i++) {
            builder.setItems(boroughs, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String currentItem = boroughsList.get(which);
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    CommBoardsFrag commBoardsFrag = new CommBoardsFrag();
                    Bundle bundle = new Bundle();
                    bundle.putString("borough", currentItem);
                    commBoardsFrag.setArguments(bundle);
                    fragmentTransaction.add(commBoardsFrag, "CommBrdActivity.class");
                    fragmentTransaction.addToBackStack(currentItem);
                    fragmentTransaction.commit();
                    Log.d(TAG, "onClick: " + currentItem + bundle);
                }
            });
        }

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override protected void onStart() {
        super.onStart();
        favCardListPresenter.attach(this);
    }

    @Override protected void onStop() {
        super.onStop();
        favCardListPresenter.detach();
    }

    @Override public void notifyDataSetChanged() {
        favCardRecyclerview.getAdapter().notifyDataSetChanged();
    }
}
