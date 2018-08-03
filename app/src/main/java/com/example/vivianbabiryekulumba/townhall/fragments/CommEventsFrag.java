package com.example.vivianbabiryekulumba.townhall.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vivianbabiryekulumba.townhall.NewEventActivity;
import com.example.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommEventsFrag extends Fragment {

    Button submit_event;

    public CommEventsFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_comm_events, container, false);
        submit_event = rootView.findViewById(R.id.submit_event);
        submit_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewEventActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
