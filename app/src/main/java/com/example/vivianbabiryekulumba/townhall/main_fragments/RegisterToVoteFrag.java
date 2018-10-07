package com.example.vivianbabiryekulumba.townhall.main_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterToVoteFrag extends Fragment {


    public static RegisterToVoteFrag newInstance() {
        // Required empty public constructor
        RegisterToVoteFrag registerToVoteFrag = new RegisterToVoteFrag();
        return registerToVoteFrag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register_to_vote, container, false);
    }

}
