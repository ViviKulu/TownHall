package com.example.vivianbabiryekulumba.townhall;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vivianbabiryekulumba.townhall.database.PetitionDatabase;
import com.example.vivianbabiryekulumba.townhall.database.Petitions;
import com.example.vivianbabiryekulumba.townhall.fragments.CommBoardsFrag;

import java.util.Arrays;
import java.util.List;

public class PetitionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "PetitionActivity.class";
    private static final String DATABASE_NAME = "petition_db";
    NavigationView navigationView;
    private DrawerLayout mDrawerLayout;
    PetitionDatabase petitionDatabase;
    LinearLayout text_input_linear_layout;
    TextInputLayout text_input_layout_title, text_input_layout_content;
    private TextInputEditText et_title, et_content;
    private Petitions petition;
    String title;
    String content;
    Button submit_button;

    String[] boroughs = new String[]{
            "Bronx",
            "Brooklyn",
            "Manhattan",
            "Queens",
            "Staten Island"
    };

    final List<String> boroughsList = Arrays.asList(boroughs);

    //Replace the activity with a fragment to display the add petition service.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition);

        petitionDatabase = Room.databaseBuilder(getApplicationContext(), PetitionDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();

        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);
        submit_button = findViewById(R.id.submit_button);

        text_input_layout_title = findViewById(R.id.txtInput1);
        text_input_linear_layout = findViewById(R.id.txtInput);
        text_input_layout_content = findViewById(R.id.txtInput2);
        et_title = findViewById(R.id.et_title);
        et_content = findViewById(R.id.et_content);

        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setHomeAsUpIndicator(R.drawable.list_white);
        setNavigationViewListener();

        submit_button.setOnClickListener(v -> {
            petition = new Petitions(et_title.getText().toString(), et_content.getText().toString());
            petition.setPetition_title(et_title.getText().toString());
            petition.setPetition_content(et_content.getText().toString());
            title = et_title.getText().toString();
            content = et_content.getText().toString();
            Log.d(TAG, "onCreate: " + petition);

            if(petition != null){
                Toast.makeText(getApplicationContext(), "Petition submitted!", Toast.LENGTH_SHORT).show();
            }
        });

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
            Intent intent = new Intent(PetitionActivity.this, NavigationActivity.class);
            startActivity(intent);
            buildAlertDialog();
        } else if (id == R.id.nav_petitions) {
            Intent intent = new Intent(getApplicationContext(), PetitionListActivity.class);
            startActivity(intent);
            //Start database
        } else if (id == R.id.nav_opportunities) {
            Intent intent2 = new Intent(getApplicationContext(), FavVolunteerOppListActivity.class);
            startActivity(intent2);
            //Start database
        } else if (id == R.id.nav_profile) {
            //Build alert dialog to log in to profile
            //Start database
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buildAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(PetitionActivity.this);
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

}
