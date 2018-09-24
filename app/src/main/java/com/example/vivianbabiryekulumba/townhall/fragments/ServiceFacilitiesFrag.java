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
import com.example.vivianbabiryekulumba.townhall.controllers.ServiceFacilitiesAdapter;
import com.example.vivianbabiryekulumba.townhall.models.ServiceFacilities;
import com.example.vivianbabiryekulumba.townhall.network_service.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceFacilitiesFrag extends Fragment {

    private static final String TAG = "ServiceFacFrag";
    private RecyclerView recyclerView;
    private List<ServiceFacilities> serviceFacilitiesList;
    Context context;

    public static ServiceFacilitiesFrag newInstance() {
        ServiceFacilitiesFrag serviceFacilitiesFrag = new ServiceFacilitiesFrag();
        return  serviceFacilitiesFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.services_fac_frag, container, false);
        recyclerView = view.findViewById(R.id.recyclerviewServFac);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.cityofnewyork.us/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final NetworkService networkService = retrofit.create(NetworkService.class);

        final Call<List<ServiceFacilities>> serviceFragCall = networkService.getServiceFacilities();

        serviceFragCall.enqueue(new Callback<List<ServiceFacilities>>() {
            @Override
            public void onResponse(Call<List<ServiceFacilities>> call, Response<List<ServiceFacilities>> response) {
                serviceFacilitiesList = response.body();
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                ServiceFacilitiesAdapter adapter = new ServiceFacilitiesAdapter(serviceFacilitiesList, context);
                recyclerView.setAdapter(adapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                Log.d(TAG, "onResponse: success");
                Log.d(TAG, "onResponse: " + serviceFacilitiesList);
            }

            @Override
            public void onFailure(Call<List<ServiceFacilities>> call, Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "onFailure: not successful");
            }
        });

        return view;
    }

}
