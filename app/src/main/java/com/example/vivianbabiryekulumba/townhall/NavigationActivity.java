package com.example.vivianbabiryekulumba.townhall;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.vivianbabiryekulumba.townhall.fragments.HomeFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.PostEventFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.PostPetitionFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.ViewCommEvents;
import com.example.vivianbabiryekulumba.townhall.viewpager.ViewPagerAdapter;

public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    MenuItem prevMenuItem;
    HomeFrag homeFrag;
    PostEventFrag postEventFrag;
    PostPetitionFrag postPetitionFrag;
    ViewCommEvents viewCommEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home_frag:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.post_petitions:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.post_events:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.community_events:
                                viewPager.setCurrentItem(3);
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

       /*  //Disable ViewPager Swipe
       viewPager.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                return true;
            }
        });
        */

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        homeFrag = new HomeFrag();
        postEventFrag = new PostEventFrag();
        postPetitionFrag = new PostPetitionFrag();
        viewCommEvents = new ViewCommEvents();
        adapter.addFragment(homeFrag);
        adapter.addFragment(postEventFrag);
        adapter.addFragment(postPetitionFrag);
        adapter.addFragment(viewCommEvents);
        viewPager.setAdapter(adapter);
    }

    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.swing_up_left);
        v.startAnimation(animation);
    }
}
