package com.example.vivianbabiryekulumba.townhall;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.vivianbabiryekulumba.townhall.models.ZipCode;
import com.example.vivianbabiryekulumba.townhall.network_service.NetworkService;
import com.example.vivianbabiryekulumba.townhall.recycler.CommBoardAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity.class";
    RecyclerView recyclerView;
    Retrofit retrofit;
    List<ZipCode> zipCodeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);

        getRetrofit();
    }

    public void getRetrofit() {

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
                    CommBoardAdapter adapter = new CommBoardAdapter(zipCodeList);
                    adapter.notifyDataSetChanged();
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(linearLayoutManager);
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

}
