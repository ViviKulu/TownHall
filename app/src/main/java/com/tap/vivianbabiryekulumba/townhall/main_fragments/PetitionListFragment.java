package com.tap.vivianbabiryekulumba.townhall.main_fragments;


import android.arch.lifecycle.LiveData;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tap.vivianbabiryekulumba.townhall.PetitionListActivity;
import com.tap.vivianbabiryekulumba.townhall.R;
import com.tap.vivianbabiryekulumba.townhall.controllers.PetitionListAdapter;
import com.tap.vivianbabiryekulumba.townhall.database.AppApplication;
import com.tap.vivianbabiryekulumba.townhall.database.Petition;
import com.tap.vivianbabiryekulumba.townhall.database.PetitionDao;
import com.tap.vivianbabiryekulumba.townhall.database.PetitionDatabase;
import com.tap.vivianbabiryekulumba.townhall.database.PetitionListPresenter;
import com.tap.vivianbabiryekulumba.townhall.database.PetitionObserver;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetitionListFragment extends Fragment implements PetitionListPresenter.PetitionListPresentation{

    private static final String TAG = "PetitionList.class";
    public PetitionListPresenter petitionListPresenter;
    private RecyclerView petitionRecyclerView;
    FloatingActionButton submit;
    FloatingActionButton edit;
    FloatingActionButton delete;

    String[] boroughs = new String[]{
            "Bronx",
            "Brooklyn",
            "Manhattan",
            "Queens",
            "Staten Island"
    };

    final List<String> boroughsList = Arrays.asList(boroughs);

    public PetitionListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_petition_list, container, false);

        petitionRecyclerView = view.findViewById(R.id.petition_list_recyclerview);
        submit = view.findViewById(R.id.submit_revised_button);
        edit = view.findViewById(R.id.edit_button);
        delete = view.findViewById(R.id.delete_button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext().getApplicationContext());
                builder.setTitle("Submitting revised petitions is coming soon!");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make @UPDATE request
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Make @DELETE request
            }
        });


        PetitionDatabase db = ((AppApplication) getActivity().getApplication()).getPetitionDatabase();
        PetitionDao petitionDao = db.petitionDao();

        petitionListPresenter = new PetitionListPresenter(petitionDao);

        petitionRecyclerView.setAdapter(new PetitionListAdapter(petitionListPresenter));

        LiveData<Petition[]> petition = petitionDao.getAllPetitions();
        petition.observe(this, new PetitionObserver(petitionListPresenter));

        return view;
    }

    public void buildAlertDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getContext().getApplicationContext());
        builder.setTitle("Select your borough");

        for (int i = 0; i < boroughsList.size(); i++) {
            builder.setItems(boroughs, (dialog, which) -> {
                String currentItem = boroughsList.get(which);
                FragmentManager fragmentManager = getChildFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                CommBoardsFrag commBoardsFrag = new CommBoardsFrag();
                Bundle bundle = new Bundle();
                bundle.putString("borough", currentItem);
                commBoardsFrag.setArguments(bundle);
                fragmentTransaction.add(commBoardsFrag, "CommBrdActivity.class");
                fragmentTransaction.addToBackStack(currentItem);
                fragmentTransaction.commit();
                Log.d(TAG, "onClick: " + currentItem + bundle);
            });
        }

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onStart() {
        super.onStart();
        petitionListPresenter.attach(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        petitionListPresenter.detach();
    }

    @Override public void notifyDataSetChanged() {
        Log.d("PetitionListActivity", "notifyDataSetChanged()");
        petitionRecyclerView.getAdapter().notifyDataSetChanged();
    }

}
