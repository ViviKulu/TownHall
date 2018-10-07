package com.example.vivianbabiryekulumba.townhall;

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
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.vivianbabiryekulumba.townhall.controllers.ViewPagerAdapter;
import com.example.vivianbabiryekulumba.townhall.main_fragments.CommBoardsFrag;
import com.example.vivianbabiryekulumba.townhall.util.ZoomOutPageTransformer;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "MainActivity.class";
    ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    PagerTabStrip pagerTabStrip;
    NavigationView navigationView;

    String[] boroughs = new String[]{
            "Bronx",
            "Brooklyn",
            "Manhattan",
            "Queens",
            "Staten Island"
    };


    final List<String> boroughsList = Arrays.asList(boroughs);

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mDrawerLayout = findViewById(R.id.drawer_layout);
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

        navigationView = findViewById(R.id.nav_view);
        pagerTabStrip = findViewById(R.id.pager_header);
        viewPager = findViewById(R.id.viewpager);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());
        viewPager.setOffscreenPageLimit(3);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        buildCommBoardAlertDialog();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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
        NavigationView navigationView = findViewById(R.id.nav_view);
        assert navigationView != null;
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.BLACK));
        navigationView.setNavigationItemSelectedListener(this);
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
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            buildCommBoardAlertDialog();
        } else if (id == R.id.nav_petitions) {
            Intent intent1 = new Intent(MainActivity.this, PetitionListActivity.class);
            startActivity(intent1);
        } else if (id == R.id.nav_user_profile) {
            Intent intent2 = new Intent(MainActivity.this, UserProfileActivity.class);
            startActivity(intent2);
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void buildCommBoardAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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
