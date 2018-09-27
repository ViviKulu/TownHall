package com.example.vivianbabiryekulumba.townhall;

import android.arch.lifecycle.LiveData;
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

import com.example.vivianbabiryekulumba.townhall.controllers.PetitionListAdapter;
import com.example.vivianbabiryekulumba.townhall.database.Petition;
import com.example.vivianbabiryekulumba.townhall.database.PetitionDao;
import com.example.vivianbabiryekulumba.townhall.database.PetitionDatabase;
import com.example.vivianbabiryekulumba.townhall.database.PetitionListPresenter;
import com.example.vivianbabiryekulumba.townhall.database.PetitionObserver;
import com.example.vivianbabiryekulumba.townhall.database.AppApplication;
import com.example.vivianbabiryekulumba.townhall.main_fragments.CommBoardsFrag;

import java.util.Arrays;
import java.util.List;

public class PetitionListActivity extends AppCompatActivity
        implements PetitionListPresenter.PetitionListPresentation, NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "PetitionList.class";
    NavigationView navigationView;
    private DrawerLayout mDrawerLayout;
    public PetitionListPresenter petitionListPresenter;
    private RecyclerView petitionRecyclerView;

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
        setContentView(R.layout.activity_petition);
        //Navigation Drawer
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        petitionRecyclerView = findViewById(R.id.petition_list_recyclerview);

        PetitionDatabase db = ((AppApplication) getApplication()).getPetitionDatabase();
        PetitionDao petitionDao = db.petitionDao();

        petitionListPresenter = new PetitionListPresenter(petitionDao);

        petitionRecyclerView.setAdapter(new PetitionListAdapter(petitionListPresenter));

        LiveData<Petition[]> petition = petitionDao.getAllPetitions();
        petition.observe(this, new PetitionObserver(petitionListPresenter));

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setHomeAsUpIndicator(R.drawable.list_white);
        setNavigationViewListener();

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(@NonNull View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(@NonNull View drawerView) {
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
            Intent intent = new Intent(PetitionListActivity.this, MainActivity.class);
            startActivity(intent);
            buildAlertDialog();
        } else if (id == R.id.nav_petitions) {
            Intent intent = new Intent(getApplicationContext(), PetitionListActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_opportunities) {
            Intent intent2 = new Intent(getApplicationContext(), VolunteerListActivity.class);
            startActivity(intent2);
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buildAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(PetitionListActivity.this);
        builder.setTitle("Select your borough");

        for (int i = 0; i < boroughsList.size(); i++) {
            builder.setItems(boroughs, (dialog, which) -> {
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
            });
        }

        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @Override protected void onStart() {
        super.onStart();
        petitionListPresenter.attach(this);
    }

    @Override protected void onStop() {
        super.onStop();
        petitionListPresenter.detach();
    }

    @Override public void notifyDataSetChanged() {
        Log.d("PetitionListActivity", "notifyDataSetChanged()");
        petitionRecyclerView.getAdapter().notifyDataSetChanged();
    }
}
