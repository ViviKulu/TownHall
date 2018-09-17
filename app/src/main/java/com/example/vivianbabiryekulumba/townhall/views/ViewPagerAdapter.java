package com.example.vivianbabiryekulumba.townhall.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private static final String TAG = "ViewPagerAdapter";
    public final List<Fragment> fragmentsList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.d(TAG, "getItem: " + position);
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: " + fragmentsList.size());
        return fragmentsList.size();
    }

    public void addFragment(Fragment fragment) {
        fragmentsList.add(fragment);
        Log.d(TAG, "addFragment: " + fragment);
    }
}
