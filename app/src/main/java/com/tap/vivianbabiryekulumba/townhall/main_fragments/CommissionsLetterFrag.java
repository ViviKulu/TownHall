package com.tap.vivianbabiryekulumba.townhall.main_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tap.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommissionsLetterFrag extends Fragment {

    TextView title;
    TextView content;

    public CommissionsLetterFrag newInstance() {
        // Required empty public constructor
        CommissionsLetterFrag commissionsLetterFrag = new CommissionsLetterFrag();
        return commissionsLetterFrag;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_commissions_letter, container, false);
        title = view.findViewById(R.id.revision_commission_letter_title);
        content = view.findViewById(R.id.revision_commission_letter_content);
        return view;
    }

}
