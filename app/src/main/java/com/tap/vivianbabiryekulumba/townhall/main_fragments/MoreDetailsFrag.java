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
    TextView quote;

    public static MoreDetailsFrag newInstance() {
        MoreDetailsFrag moreDetailsFrag = new MoreDetailsFrag();
        return moreDetailsFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.more_details_frag, container, false);
        quote = view.findViewById(R.id.inspiration_quote_tv);


        return view;
    }
}
