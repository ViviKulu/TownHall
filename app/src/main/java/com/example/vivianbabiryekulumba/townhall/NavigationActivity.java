package com.example.vivianbabiryekulumba.townhall;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.example.vivianbabiryekulumba.townhall.fragments.CommBoardsFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.FoodDistServFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.VolunteerFrag;
import com.example.vivianbabiryekulumba.townhall.views.ViewPagerAdapter;

import java.util.Arrays;
import java.util.List;

public class NavigationActivity extends AppCompatActivity {

    private static final String TAG = "NavActivity.class";
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    MenuItem prevMenuItem;
    CommBoardsFrag commBoardsFrag;
    FoodDistServFrag foodDistServFrag;
    VolunteerFrag volunteerFrag;
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
        setContentView(R.layout.activity_navigation);

        final AlertDialog.Builder builder = new AlertDialog.Builder(NavigationActivity.this);
        builder.setTitle("Select your borough");
        builder.setItems(boroughs, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Bundle bundleBx = new Bundle();
                        bundleBx.putInt("borough", boroughsList.indexOf("Bronx"));
                        Intent intentToBX = new Intent(NavigationActivity.this, CommBoardsFrag.class);
                        intentToBX.putExtras(bundleBx);
                        startActivity(intentToBX);
                        Log.d(TAG, "onClick: " + intentToBX + bundleBx);
                        break;
                }
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.comm_boards:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.food_dist_service:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.volunteer_service:
                                viewPager.setCurrentItem(2);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: " + position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        commBoardsFrag = new CommBoardsFrag();
        foodDistServFrag = new FoodDistServFrag();
        volunteerFrag = new VolunteerFrag();
        adapter.addFragment(commBoardsFrag);
        adapter.addFragment(foodDistServFrag);
        adapter.addFragment(volunteerFrag);
        viewPager.setAdapter(adapter);
    }
}
