package com.example.vivianbabiryekulumba.townhall.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import com.example.vivianbabiryekulumba.townhall.MapActivity;
import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.models.ZipCode;
import com.example.vivianbabiryekulumba.townhall.network_service.NetworkService;
import com.example.vivianbabiryekulumba.townhall.recycler.CommBoardAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.vivianbabiryekulumba.townhall.R.string.location_for_comm_board;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrag extends Fragment {

    private static final String TAG = "MainActivity.class";
    private RecyclerView recyclerView;
    private Retrofit retrofit;
    private List<ZipCode> zipCodeList;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    EditText enterZipText;

    public HomeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerview);
        getRetrofit();
//        sendData();
        return rootView;
    }

    private void getRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final NetworkService networkService = retrofit.create(NetworkService.class);

        final Call<List<ZipCode>> commBoardCall = networkService.getCommBoardData();
        commBoardCall.enqueue(new Callback<List<ZipCode>>() {
            @Override
            public void onResponse(@NonNull Call<List<ZipCode>> call, @NonNull Response<List<ZipCode>> response) {
                if (response.isSuccessful()) {
                    zipCodeList = response.body();
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                    CommBoardAdapter adapter = new CommBoardAdapter(zipCodeList);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    Log.d(TAG, "onResponse: success");
                    Log.d(TAG, "onResponse: " + zipCodeList);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ZipCode>> call, @NonNull Throwable t) {
                t.printStackTrace();
                Log.d(TAG, "onFailure: not successful");
            }
        });
    }

//    private void sendData() {
//        Intent i = new Intent(getActivity().getBaseContext(),
//                MapActivity.class);
//        i.putExtra("ZIP_CODE", "zip_code");
//        enterZipText.setText(new StringBuilder().append(getString(R.string.location_for_comm_board)).append(enterZipText).append(getString(R.string.comm_board_is_here)).toString());
//        getActivity().startActivity(i);
//    }

}
