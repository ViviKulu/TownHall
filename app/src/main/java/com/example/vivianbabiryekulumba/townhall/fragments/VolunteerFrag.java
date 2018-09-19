package com.example.vivianbabiryekulumba.townhall.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.controllers.VolunteerAdapter;
import com.example.vivianbabiryekulumba.townhall.models.VolunteerDetails;
import com.example.vivianbabiryekulumba.townhall.network_service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.constraint.Constraints.TAG;

/**
 * A simple {@link Fragment} subclass.
 */
public class VolunteerFrag extends Fragment {

    RecyclerView recyclerView;
    List<VolunteerDetails> volunteerDetailsList;
    Context context;

    public static VolunteerFrag newInstance() {
        // Required empty public constructor
        VolunteerFrag volunteerFrag = new VolunteerFrag();
        return volunteerFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);
        recyclerView = view.findViewById(R.id.vol_recyclerview);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final NetworkService networkService = retrofit.create(NetworkService.class);

        final Call<List<VolunteerDetails>> volDetailsCall = networkService.getVolunteerDetailsData();
        volDetailsCall.enqueue(new Callback<List<VolunteerDetails>>() {
            @Override
            public void onResponse(Call<List<VolunteerDetails>> call, Response<List<VolunteerDetails>> response) {
                if(response.isSuccessful()){
                    volunteerDetailsList = response.body();
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                    VolunteerAdapter volunteerAdapter = new VolunteerAdapter(volunteerDetailsList, context);
                    recyclerView.setAdapter(volunteerAdapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    Log.d(TAG, "onResponse: " + volunteerDetailsList);
                    Log.d(TAG, "onResponse: volunteer success");
                }
            }

            @Override
            public void onFailure(Call<List<VolunteerDetails>> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "onFailure: volunteer failure");
            }
        });
        return view;
    }

}
