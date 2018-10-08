package com.tap.vivianbabiryekulumba.townhall.main_fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tap.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterToVoteFrag extends Fragment {

    FloatingActionButton commissions_letter;
    FloatingActionButton register_fab;
//    FloatingActionButton register_online;
//    FloatingActionButton register_by_mail;
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

        commissions_letter = view.findViewById(R.id.commissions_letter_button);
        register_fab = view.findViewById(R.id.register);
//        register_online = view.findViewById(R.id.register_online_button);
//        register_by_mail = view.findViewById(R.id.register_by_mail_button);
        title = view.findViewById(R.id.revision_commission_letter_title);
        content = view.findViewById(R.id.revision_commission_letter_content);

        CommissionsLetterFrag commissionsLetterFrag = new CommissionsLetterFrag();
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.registration_container, commissionsLetterFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        commissions_letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommissionsLetterFrag commissionsLetterFrag = new CommissionsLetterFrag();
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.registration_container, commissionsLetterFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        register_fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFrag registerFrag = new RegisterFrag();
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.registration_container, registerFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

//        register_online.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //replace fragment with RegisterOnlineFrag;
//                RegisterToVoteOnlineFrag registerToVoteOnlineFrag = new RegisterToVoteOnlineFrag();
//                FragmentManager fragmentManager = getChildFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.registration_container, registerToVoteOnlineFrag);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });
//
//        register_by_mail.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //replace fragment with RegisterByMailFrag;
//                RegisterToVoteByMailFrag registerToVoteByMailFrag = new RegisterToVoteByMailFrag();
//                FragmentManager fragmentManager = getChildFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.registration_container, registerToVoteByMailFrag);
//                fragmentTransaction.addToBackStack(null);
//                fragmentTransaction.commit();
//            }
//        });

        return view;
    }

}
