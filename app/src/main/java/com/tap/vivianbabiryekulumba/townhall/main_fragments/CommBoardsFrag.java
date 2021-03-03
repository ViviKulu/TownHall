package com.tap.vivianbabiryekulumba.townhall.main_fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tap.vivianbabiryekulumba.townhall.MainActivity;
import com.tap.vivianbabiryekulumba.townhall.PetitionAddActivity;
import com.tap.vivianbabiryekulumba.townhall.R;
import com.tap.vivianbabiryekulumba.townhall.network_calls.BkRetroFragment;
import com.tap.vivianbabiryekulumba.townhall.network_calls.BxRetroFragment;
import com.tap.vivianbabiryekulumba.townhall.network_calls.MxRetroFragment;
import com.tap.vivianbabiryekulumba.townhall.network_calls.QuRetroFragment;
import com.tap.vivianbabiryekulumba.townhall.network_calls.StatRetroFragment;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommBoardsFrag extends Fragment{

    private static final String TAG = "CommBrdFrag";
    BxRetroFragment bxRetroFragment;
    BkRetroFragment bkRetroFragment;
    MxRetroFragment mxRetroFragment;
    QuRetroFragment quRetroFragment;
    StatRetroFragment statRetroFragment;
    FloatingActionButton submit_button;
    FloatingActionButton streamedMeetings;
    ViewPager viewPager;

    String[] boroughs = new String[]{
            "Bronx",
            "Brooklyn",
            "Manhattan",
            "Queens",
            "Staten Island"
    };


    final List<String> boroughsList = Arrays.asList(boroughs);

    public static CommBoardsFrag newInstance() {
        // Required empty public constructor
        CommBoardsFrag commBoardsFrag = new CommBoardsFrag();
        return commBoardsFrag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comm_board, container, false);

        submit_button = view.findViewById(R.id.submit_petition_button);
        streamedMeetings = view.findViewById(R.id.streamed_meetings_button);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PetitionAddActivity.class);
                startActivity(intent);
            }
        });

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        Bundle bundle = this.getArguments();
        Log.d(TAG, "onCreateView: commBoardFrag receiving bundle " + bundle);
        if(bundle != null) {
            String myBorough = bundle.getString("borough");

            if (myBorough != null) {
                switch (myBorough) {
                    case "Bronx":
                        bxRetroFragment = new BxRetroFragment();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, bxRetroFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        Log.d(TAG, "onCreateView: success " + myBorough);
                        break;
                    case "Brooklyn":
                        bkRetroFragment = new BkRetroFragment();
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.main_container, bkRetroFragment);
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();
                        Log.d(TAG, "onCreateView: success " + myBorough);
                        break;
                    case "Manhattan":
                        mxRetroFragment = new MxRetroFragment();
                        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                        fragmentTransaction3.replace(R.id.main_container, mxRetroFragment);
                        fragmentTransaction3.addToBackStack(null);
                        fragmentTransaction3.commit();
                        Log.d(TAG, "onCreateView: success " + myBorough);
                        break;
                    case "Queens":
                        quRetroFragment = new QuRetroFragment();
                        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
                        fragmentTransaction4.replace(R.id.main_container, quRetroFragment);
                        fragmentTransaction4.addToBackStack(null);
                        fragmentTransaction4.commit();
                        Log.d(TAG, "onCreateView: success " + myBorough);
                        break;
                    case "Staten Island":
                        statRetroFragment = new StatRetroFragment();
                        FragmentTransaction fragmentTransaction5 = fragmentManager.beginTransaction();
                        fragmentTransaction5.replace(R.id.main_container, statRetroFragment);
                        fragmentTransaction5.addToBackStack(null);
                        fragmentTransaction5.commit();
                        Log.d(TAG, "onCreateView: success " + myBorough);
                        break;
                }

            }
        }
        return view;
    }

    public void buildCommBoardAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Explore your borough's Community Board!");

        for (int i = 0; i < boroughsList.size(); i++) {
            builder.setItems(boroughs, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String currentItem = boroughsList.get(which);
                    FragmentManager fragmentManager = getChildFragmentManager();
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
