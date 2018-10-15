package com.tap.vivianbabiryekulumba.townhall;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.tap.vivianbabiryekulumba.townhall.controllers.YouTubeRecyclerViewAdapter;
import com.tap.vivianbabiryekulumba.townhall.main_fragments.CommBoardsFrag;
import java.util.Arrays;
import java.util.List;

public class YouTubeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private static final String TAG = "YouTubeActivity";
    RecyclerView recyclerView;

    private String[] videoIds = {"Ch_eEgg-xYo", "zXCStpIS4vA", "MzBolNDRM1s", "2kwDK4Q-Oyg","6C3sh2tA7U0", "brxxGwGoWlU", "oZD8EedDCzw",
    "5aW1Vxub3e0", "F62dfybPj-4", "ADsKEciik-Q", "pvKCPCTKjQ8", "-vhSmVaY8f0", "rpiNUqRNOdg", "GHQ7he5FYqw", "AEfIFK-ceEk", "fBV_EBiYWhs", "QIcZ7JYvVZ0", "6bdW2DK-Kbg",
    "aze10OtSvrs", "sWg_eTkyxy4", "M0Sl7wzuYAk", "JyjBqSbnEBg", "ArTtc6rJu_s", "mwAp6QC3sDs", "5OR9kCQUjC4", "KYjdXiV8q0k", "LkkFvU3Rloc", "TJVbR8RqVCw", "ljo7PMgsmaM",
    "Gj_umrx3ACs", "Fpo1AKXWMvQ", "Rlu1LVn2APg", "7whpdVH18_k", "tH0ovxXbkS4", "Vg7hrbUrxMI", "2yx-gPuU1p0", "gsckxXlxJWo", "HkFpBkCNYls", "Nak6wX7o-zc", "JIjN2Th07gg",
    "V0yEHh_30zw", "HtDn2a3CEVI", "MIJynu8C0lw", "UvXYw2BXNJQ", "1d86RxnDvpM", "v44jRO5YJlU", "ML44opXEM3Q", "5B7rx7rwwBE", "hCg5kNuYvwg", "SeDPBe67YRQ", "861_SbkPdiI",
    "zYgebc-f8Ys", "uiWZCel0iJ8", "PI5g-aNORqM", "jMEOzSabP_8", "nDVHbZjqt6E", "cCG3TmcUu68", "3IvV01-mfq4", "FZ-nXqvn8DE", "4OHP1VfndWA", "4OHP1VfndWA", "4WXCWXQH8qA",
    "1Vd_FRGTn8w", "bfG0cc_BTJY", "8U2KK0exsLE", "RcIYM4dCFkU", "5UcRQgWinhA", "qddEoCU0e1Q", "j6DZo4HFLY4", "FHVjjOZlNXM", "wd-q_n7arLw", "Z3EXiN4hdaU", "7ePdaTZK1eM",
    "Z3zQoNh0Lvc", "pqG4Kfh1RtM", "J-zRoEA8qR8", "EDvUBligRjM", "_MaeAUlA-qQ", "yFN0WuKOrT0", "pRgUSUu_2HI"};

    NavigationView navigationView;

    String[] boroughs = new String[]{
            "Bronx",
            "Brooklyn",
            "Manhattan",
            "Queens",
            "Staten Island"
    };

    String[] features = new String[]{
            "Submit revised petitions to Community Boards.",
            "Interact with local network.",
            "Volunteer within your community.",
            "Post community events.",
            "Campaign for a seat on your local community board!",
            "and many more..."
    };

    final List<String> boroughsList = Arrays.asList(boroughs);
    final List<String> featuresList = Arrays.asList(features);

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube);
        recyclerView = findViewById(R.id.comm_board_youtube_recycler);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setDisplayShowTitleEnabled(false);
        actionbar.setHomeAsUpIndicator(R.drawable.list_white);
        setNavigationViewListener();

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter recyclerViewAdapter = new YouTubeRecyclerViewAdapter(videoIds, this.getLifecycle());
        recyclerView.setAdapter(recyclerViewAdapter);

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

    private void setNavigationViewListener() {
        navigationView = findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull android.view.MenuItem item) {
        item.setChecked(true);
        mDrawerLayout.closeDrawers();

        Log.d(TAG, "onNavigationItemSelected: made it to onNavItemSelected");

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            buildCommBoardAlertDialog();
        } else if (id == R.id.nav_petitions) {
            Intent intent1 = new Intent(YouTubeActivity.this, PetitionListActivity.class);
            startActivity(intent1);
        } else if (id == R.id.nav_user_profile) {
//            Intent intent2 = new Intent(MainActivity.this, UserProfileActivity.class);
//            startActivity(intent2);

            final AlertDialog.Builder builder = new AlertDialog.Builder(YouTubeActivity.this);
            builder.setTitle("Feature coming soon!");

            for (int i = 0; i < featuresList.size(); i++) {
                builder.setItems(features, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        builder.setCancelable(true);
                    }
                });
            }
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buildCommBoardAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(YouTubeActivity.this);
        builder.setTitle("Explore your borough's Community Board!");

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
                    fragmentTransaction.add(commBoardsFrag, "CommBrdFrag");
                    fragmentTransaction.addToBackStack(currentItem);
                    fragmentTransaction.commit();
                    Log.d(TAG, "onClick: " + currentItem + bundle);
                }
            });
        }
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
