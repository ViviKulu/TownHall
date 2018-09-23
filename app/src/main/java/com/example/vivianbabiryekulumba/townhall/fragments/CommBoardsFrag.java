package com.example.vivianbabiryekulumba.townhall.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.retrofit.BkRetroFragment;
import com.example.vivianbabiryekulumba.townhall.retrofit.BxRetroFragment;
import com.example.vivianbabiryekulumba.townhall.retrofit.MxRetroFragment;
import com.example.vivianbabiryekulumba.townhall.retrofit.QuRetroFragment;
import com.example.vivianbabiryekulumba.townhall.retrofit.StatRetroFragment;

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

    public static CommBoardsFrag newInstance() {
        // Required empty public constructor
        CommBoardsFrag commBoardsFrag = new CommBoardsFrag();
        return commBoardsFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comm_board, container, false);

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String myBorough = bundle.getString("borough");
            Log.d(TAG, "onCreateView: ");

            if (myBorough != null) {
                switch (myBorough) {
                    case "Bronx":
                        bxRetroFragment = new BxRetroFragment();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.main_container, bxRetroFragment);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        Bundle bxBundle = new Bundle();
                        bxBundle.putString("bxFrag", bxRetroFragment.toString());
                        Log.d(TAG, "onCreateView: success" + myBorough);
                        break;
                    case "Brooklyn":
                        bkRetroFragment = new BkRetroFragment();
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.main_container, bkRetroFragment);
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();
                        Log.d(TAG, "onCreateView: success" + myBorough);
                        break;
                    case "Manhattan":
                        mxRetroFragment = new MxRetroFragment();
                        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                        fragmentTransaction3.replace(R.id.main_container, mxRetroFragment);
                        fragmentTransaction3.addToBackStack(null);
                        fragmentTransaction3.commit();
                        Log.d(TAG, "onCreateView: success"+ myBorough);
                        break;
                    case "Queens":
                        quRetroFragment = new QuRetroFragment();
                        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
                        fragmentTransaction4.replace(R.id.main_container, quRetroFragment);
                        fragmentTransaction4.addToBackStack(null);
                        fragmentTransaction4.commit();
                        Log.d(TAG, "onCreateView: success" + myBorough);
                        break;
                    case "Staten Island":
                        statRetroFragment = new StatRetroFragment();
                        FragmentTransaction fragmentTransaction5 = fragmentManager.beginTransaction();
                        fragmentTransaction5.replace(R.id.main_container, statRetroFragment);
                        fragmentTransaction5.addToBackStack(null);
                        fragmentTransaction5.commit();
                        Log.d(TAG, "onCreateView: success" + myBorough);
                        break;
                }
            }
        }
        return view;
    }
}
