package com.example.vivianbabiryekulumba.townhall.main_fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.vivianbabiryekulumba.townhall.R;
/**
 * A simple {@link Fragment} subclass.
 */
public class MoreDetailsFrag extends Fragment {

    private static final String TAG = "MoreDetailsFrag";
    RecyclerView recyclerView;

    public static MoreDetailsFrag newInstance() {
        MoreDetailsFrag moreDetailsFrag = new MoreDetailsFrag();
        return moreDetailsFrag;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.more_details_frag, container, false);

        //Set the recyclerview with the adapter and the layout manager.

        return view;
    }
}
