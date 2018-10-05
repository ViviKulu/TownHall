package com.example.vivianbabiryekulumba.townhall.main_fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.controllers.MoreDetailsAdapter;
import com.example.vivianbabiryekulumba.townhall.models.CommBoard;
import com.example.vivianbabiryekulumba.townhall.network_calls.BkRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_calls.BxRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_calls.MxRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_calls.QuRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_calls.StatRetroFragment;
import com.example.vivianbabiryekulumba.townhall.network_service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreDetailsFrag extends Fragment {

    private static final String TAG = "MoreDetailsFrag";
    BxRetroFragment bxRetroFragment;
    BkRetroFragment bkRetroFragment;
    MxRetroFragment mxRetroFragment;
    QuRetroFragment quRetroFragment;
    StatRetroFragment statRetroFragment;

    public static MoreDetailsFrag newInstance() {
        MoreDetailsFrag moreDetailsFrag = new MoreDetailsFrag();
        return moreDetailsFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.more_details_frag, container, false);

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
                        Bundle bkBundle = new Bundle();
                        bkBundle.putString("bkFrag", bkRetroFragment.toString());
                        Log.d(TAG, "onCreateView: success" + myBorough);
                        break;
                    case "Manhattan":
                        mxRetroFragment = new MxRetroFragment();
                        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                        fragmentTransaction3.replace(R.id.main_container, mxRetroFragment);
                        fragmentTransaction3.addToBackStack(null);
                        fragmentTransaction3.commit();
                        Bundle mxBundle = new Bundle();
                        mxBundle.putString("mxFrag", mxRetroFragment.toString());
                        Log.d(TAG, "onCreateView: success" + myBorough);
                        break;
                    case "Queens":
                        quRetroFragment = new QuRetroFragment();
                        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
                        fragmentTransaction4.replace(R.id.main_container, quRetroFragment);
                        fragmentTransaction4.addToBackStack(null);
                        fragmentTransaction4.commit();
                        Bundle quBundle = new Bundle();
                        quBundle.putString("quFrag", quRetroFragment.toString());
                        Log.d(TAG, "onCreateView: success" + myBorough);
                        break;
                    case "Staten Island":
                        statRetroFragment = new StatRetroFragment();
                        FragmentTransaction fragmentTransaction5 = fragmentManager.beginTransaction();
                        fragmentTransaction5.replace(R.id.main_container, statRetroFragment);
                        fragmentTransaction5.addToBackStack(null);
                        fragmentTransaction5.commit();
                        Bundle statBundle = new Bundle();
                        statBundle.putString("statFrag", statRetroFragment.toString());
                        Log.d(TAG, "onCreateView: success" + myBorough);
                        break;
                }
            }
        }

        return view;
    }

}
