package com.example.vivianbabiryekulumba.townhall.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodDistServFrag extends Fragment {

    private String title;

    public static FoodDistServFrag newInstance() {
        // Required empty public constructor
        FoodDistServFrag foodDistServFrag = new FoodDistServFrag();
        return foodDistServFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_dist, container, false);
        return view;
    }

}
