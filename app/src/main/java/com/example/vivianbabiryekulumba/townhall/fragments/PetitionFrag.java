package com.example.vivianbabiryekulumba.townhall.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.vivianbabiryekulumba.townhall.NewPetitionActivity;
import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.models.Petition;
import com.example.vivianbabiryekulumba.townhall.views.PetitionViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * A simple {@link Fragment} subclass.
 */
public class PetitionFrag extends Fragment {

    private static final String TAG = "PetitionFrag";
    RecyclerView recyclerView;
    Button submit_petition;
    FirebaseRecyclerAdapter adapter;

    public PetitionFrag() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_petition, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        submit_petition = rootView.findViewById(R.id.submit_pet);
        submit_petition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NewPetitionActivity.class);
                startActivity(intent);
            }
        });

        final Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("petition")
                .limitToLast(50);

        query.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Petition petition = dataSnapshot.getValue(Petition.class);
                Log.d(TAG, "onChildAdded: " + petition);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FirebaseRecyclerOptions<Petition> options =
                new FirebaseRecyclerOptions.Builder<Petition>()
                        .setQuery(query, Petition.class)
                        .build();

        adapter = new FirebaseRecyclerAdapter<Petition, PetitionViewHolder>(options) {

            @NonNull
            @Override
            public PetitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.petition_item_view, parent, false);
                return new PetitionViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull PetitionViewHolder holder, int position, @NonNull Petition petition) {
                holder.setPetition(petition);
                Log.d(TAG, "onBindViewHolder: " + petition);
            }
        };

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
