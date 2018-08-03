package com.example.vivianbabiryekulumba.townhall.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vivianbabiryekulumba.townhall.NewPetitionActivity;
import com.example.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetitionFrag extends Fragment {

    Button submit_petition;

    public PetitionFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_petition, container, false);
        submit_petition = rootView.findViewById(R.id.submit_pet);
        submit_petition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewPetitionActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
