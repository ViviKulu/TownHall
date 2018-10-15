package com.tap.vivianbabiryekulumba.townhall.main_fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tap.vivianbabiryekulumba.townhall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LiveStreamMeetingFrag extends Fragment{

    private static final String TAG = "LiveStream";

    public static LiveStreamMeetingFrag newInstance() {
        // Required empty public constructor
        LiveStreamMeetingFrag liveStreamMeetingFrag = new LiveStreamMeetingFrag();
        return liveStreamMeetingFrag;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_streaming_live, container, false);
        return view;
    }
}
