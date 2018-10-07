package com.example.vivianbabiryekulumba.townhall.main_fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterToVoteFrag extends Fragment {

    FloatingActionButton register_online;
    FloatingActionButton register_by_mail;
    TextView title;
    TextView content;

    public static RegisterToVoteFrag newInstance() {
        // Required empty public constructor
        RegisterToVoteFrag registerToVoteFrag = new RegisterToVoteFrag();
        return registerToVoteFrag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register_to_vote, container, false);

        register_online = view.findViewById(R.id.register_online_button);
        register_by_mail = view.findViewById(R.id.register_by_mail_button);
        title = view.findViewById(R.id.revision_commission_letter_title);
        content = view.findViewById(R.id.revision_commission_letter_content);

        register_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //replace fragment with RegisterOnlineFrag;
            }
        });

        register_by_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //replace fragment with RegisterByMailFrag;
            }
        });

        return view;
    }

}
