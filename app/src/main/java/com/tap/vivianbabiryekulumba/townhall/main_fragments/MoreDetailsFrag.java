package com.tap.vivianbabiryekulumba.townhall.main_fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tap.vivianbabiryekulumba.townhall.R;
import com.tap.vivianbabiryekulumba.townhall.YouTubeActivity;
import com.tap.vivianbabiryekulumba.townhall.network_calls.BkMoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.network_calls.BxMoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.network_calls.MxMoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.network_calls.QuMoreDetailsFrag;
import com.tap.vivianbabiryekulumba.townhall.network_calls.StatsMoreDetailsFrag;

public class MoreDetailsFrag extends Fragment{

    private static final String TAG = "MoreDetailsFrag";
    BxMoreDetailsFrag bxMoreDetailsFrag;
    BkMoreDetailsFrag bkMoreDetailsFrag;
    MxMoreDetailsFrag mxMoreDetailsFrag;
    QuMoreDetailsFrag quMoreDetailsFrag;
    StatsMoreDetailsFrag statsMoreDetailsFrag;
    FloatingActionButton streamedMeetings;
    TextView quote;

    public static MoreDetailsFrag newInstance() {
        MoreDetailsFrag moreDetailsFrag = new MoreDetailsFrag();
        return moreDetailsFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.more_details_frag, container, false);
        streamedMeetings = view.findViewById(R.id.streamed_meetings_button);
        quote = view.findViewById(R.id.inspiration_quote_tv);

        streamedMeetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent youTubeActivity = new Intent(getContext(), YouTubeActivity.class);
                getContext().startActivity(youTubeActivity);
            }
        });

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String myLocation = bundle.getString("borough");
            Log.d(TAG, "onCreateView: " + myLocation);
            if (myLocation != null) {
                switch (myLocation) {
                    case "Bronx":
                        bxMoreDetailsFrag = new BxMoreDetailsFrag();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.more_details_container, bxMoreDetailsFrag);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                        break;
                    case "Brooklyn":
                        bkMoreDetailsFrag = new BkMoreDetailsFrag();
                        FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.more_details_container, bkMoreDetailsFrag);
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();
                        Bundle bkBundle = new Bundle();
                        bkBundle.putString("bkFrag", bkMoreDetailsFrag.toString());
                        Log.d(TAG, "onCreateView: success" + myLocation);
                        break;
                    case "Manhattan":
                        mxMoreDetailsFrag = new MxMoreDetailsFrag();
                        FragmentTransaction fragmentTransaction3 = fragmentManager.beginTransaction();
                        fragmentTransaction3.replace(R.id.more_details_container, mxMoreDetailsFrag);
                        fragmentTransaction3.addToBackStack(null);
                        fragmentTransaction3.commit();
                        Bundle mxBundle = new Bundle();
                        mxBundle.putString("mxFrag", mxMoreDetailsFrag.toString());
                        Log.d(TAG, "onCreateView: success" + myLocation);
                        break;
                    case "Queens":
                        quMoreDetailsFrag = new QuMoreDetailsFrag();
                        FragmentTransaction fragmentTransaction4 = fragmentManager.beginTransaction();
                        fragmentTransaction4.replace(R.id.more_details_container, quMoreDetailsFrag);
                        fragmentTransaction4.addToBackStack(null);
                        fragmentTransaction4.commit();
                        Bundle quBundle = new Bundle();
                        quBundle.putString("quFrag", quMoreDetailsFrag.toString());
                        Log.d(TAG, "onCreateView: success" + myLocation);
                        break;
                    case "Staten Island":
                        statsMoreDetailsFrag = new StatsMoreDetailsFrag();
                        FragmentTransaction fragmentTransaction5 = fragmentManager.beginTransaction();
                        fragmentTransaction5.replace(R.id.more_details_container, statsMoreDetailsFrag);
                        fragmentTransaction5.addToBackStack(null);
                        fragmentTransaction5.commit();
                        Bundle statBundle = new Bundle();
                        statBundle.putString("statFrag", statsMoreDetailsFrag.toString());
                        Log.d(TAG, "onCreateView: success" + myLocation);
                        break;
                }
            }
        }
        return view;
    }
}
