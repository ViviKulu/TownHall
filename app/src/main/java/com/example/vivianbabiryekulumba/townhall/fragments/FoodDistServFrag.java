package com.example.vivianbabiryekulumba.townhall.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoodDistServFrag extends Fragment {

    private String title;

    public static FoodDistServFrag newInstance(String pageTitle) {
        // Required empty public constructor
        FoodDistServFrag foodDistServFrag = new FoodDistServFrag();
        Bundle args = new Bundle();
        args.putString("pageTitle", pageTitle);
        foodDistServFrag.setArguments(args);
        return foodDistServFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title = getArguments().getString("pageTitle");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food_dist, container, false);
        TextView tvLabel = view.findViewById(R.id.FdTvLabel);
        tvLabel.setText(title);
        return view;
    }

}
