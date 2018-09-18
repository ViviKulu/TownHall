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
public class VolunteerFrag extends Fragment {

    private String title;


    public static VolunteerFrag newInstance(String pageTitle) {
        // Required empty public constructor
        VolunteerFrag volunteerFrag = new VolunteerFrag();
        Bundle args = new Bundle();
        args.putString("pageTitle", pageTitle);
        volunteerFrag.setArguments(args);
        return volunteerFrag;
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
        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);
        TextView tvLabel = view.findViewById(R.id.volTvLabel);
        tvLabel.setText(title);
        return view;
    }

}
