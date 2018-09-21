package com.example.vivianbabiryekulumba.townhall;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.AsyncTask;
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

import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;

public class PetitionActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = "PetitionActivity.class";
    private static final String DATABASE_NAME = "petition_db";
    //Room persistence database to store petitions and retrieve petitions.
    NavigationView navigationView;
    private DrawerLayout mDrawerLayout;
    private PetitionDatabase petitionDatabase;
    private LinearLayout text_input_linear_layout;
    private TextInputLayout text_input_layout_title, text_input_layout_content;
    private TextInputEditText et_title,et_content;
    private Petitions petition;
    Button submit_button;

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

        petitionDatabase = PetitionDatabase.getInstance(PetitionActivity.this);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petition = new Petitions();
                petition.setPetition_title(et_title.getText().toString());
                petition.setPetition_content(et_content.getText().toString());

                new InsertPetitionTask(PetitionActivity.this, petition).execute();
                Toast.makeText(getApplicationContext(), "Petition submitted!", Toast.LENGTH_SHORT).show();
            }
        });

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

        petitionDatabase = Room.databaseBuilder(getApplicationContext(), PetitionDatabase.class, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build();
    }

    private void setResult(Petitions petition, int flag){
        setResult(flag, new Intent().putExtra("petition", petition.toString()));
        finish();
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

    private static class InsertPetitionTask extends AsyncTask<Void, Void, Boolean> {

        private WeakReference<PetitionActivity> activityReference;
        private Petitions petition;

        // only retain a weak reference to the activity
        InsertPetitionTask(PetitionActivity context, Petitions petition) {
            activityReference = new WeakReference<>(context);
            this.petition = petition;
        }

        // doInBackground methods runs on a worker thread
        @Override
        protected Boolean doInBackground(Void... objs) {
            activityReference.get().petitionDatabase.getPetitionDao().insertPetition(petition);
            return true;
        }

        // onPostExecute runs on main thread
        @Override
        protected void onPostExecute(Boolean bool) {
            if (bool) {
                activityReference.get().setResult(petition, 1);
            }

        }
    }


}
