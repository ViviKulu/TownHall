package com.tap.vivianbabiryekulumba.townhall.controllers;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.tap.vivianbabiryekulumba.townhall.main_fragments.CommBoardsFrag;
import com.tap.vivianbabiryekulumba.townhall.main_fragments.MoreDetailsFrag;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private static final String TAG = "ViewPagerAdapter";
    private static int NUM_ITEMS = 2;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return CommBoardsFrag.newInstance();
            case 1:
                return MoreDetailsFrag.newInstance();
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
                return "More Details";
            default:
                return "Community Boards";
        }
    }




    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

}
