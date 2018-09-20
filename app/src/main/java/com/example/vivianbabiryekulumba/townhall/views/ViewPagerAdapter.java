package com.example.vivianbabiryekulumba.townhall.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.vivianbabiryekulumba.townhall.fragments.CommBoardsFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.FoodDistServFrag;
import com.example.vivianbabiryekulumba.townhall.fragments.VolunteerFrag;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "ViewPagerAdapter";
    private static int NUM_ITEMS = 3;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return CommBoardsFrag.newInstance();
            case 1:
                return FoodDistServFrag.newInstance();
            case 2:
                return VolunteerFrag.newInstance();
            default:
                return CommBoardsFrag.newInstance();
        }
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Community Boards";
            case 1:
                return "Food Distribution Service";
            case 2:
                return "Volunteer Service";
            default:
                return "Community Boards";
        }
    }


    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

}
