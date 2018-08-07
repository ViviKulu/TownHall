package com.example.vivianbabiryekulumba.townhall;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.vivianbabiryekulumba.townhall.fragments.CommEventsFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.HomeFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.PetitionFrag;
import com.example.vivianbabiryekulumba.townhall.models.CommBoard;
import com.example.vivianbabiryekulumba.townhall.recycler.CommBoardAdapter;

import java.util.List;

public class NavigationActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    MenuItem prevMenuItem;
    HomeFrag homeFrag;
    PetitionFrag petitionFrag;
    CommEventsFrag commEventsFrag;
    CommBoardAdapter.CommBoardViewHolder commBoardViewHolder;
    private List<CommBoard> zipCodeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

//        viewPager = findViewById(R.id.viewpager);
//        bottomNavigationView = findViewById(R.id.bottom_navigation);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(
//                new BottomNavigationView.OnNavigationItemSelectedListener() {
//                    @Override
//                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                        switch (item.getItemId()) {
//                            case R.id.home_frag:
//                                viewPager.setCurrentItem(0);
//                                break;
//                            case R.id.petitions:
//                                viewPager.setCurrentItem(1);
//                                break;
//                            case R.id.community_events:
//                                viewPager.setCurrentItem(3);
//                                break;
//                        }
//                        return false;
//                    }
//                });

//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                if (prevMenuItem != null) {
//                    prevMenuItem.setChecked(false);
//                } else {
//                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
//                }
//                Log.d("page", "onPageSelected: " + position);
//                bottomNavigationView.getMenu().getItem(position).setChecked(true);
//                prevMenuItem = bottomNavigationView.getMenu().getItem(position);
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//       /*  //Disable ViewPager Swipe
//       viewPager.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override
//            public boolean onTouch(View v, MotionEvent event)
//            {
//                return true;
//            }
//        });
//        */
//
//        setupViewPager(viewPager);
//    }
//
//    private void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        homeFrag = new HomeFrag();
//        petitionFrag = new PetitionFrag();
//        commEventsFrag = new CommEventsFrag();
//        adapter.addFragment(homeFrag);
//        adapter.addFragment(petitionFrag);
//        adapter.addFragment(commEventsFrag);
//        viewPager.setAdapter(adapter);
//    }
    }

}
