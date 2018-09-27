package com.example.vivianbabiryekulumba.townhall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.vivianbabiryekulumba.townhall.controllers.MapAdapter;

import static com.example.vivianbabiryekulumba.townhall.controllers.MapAdapter.NamedLocation.LIST_OF_LOCATIONS;
import static com.example.vivianbabiryekulumba.townhall.controllers.MapAdapter.liteModeRecyclerListener;

public class LiteModeActivity extends AppCompatActivity {

    RecyclerView liteModeRecyclerView;
    LinearLayoutManager liteModeLayoutManager;
    GridLayoutManager liteModeGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_mode);

        liteModeLayoutManager = new LinearLayoutManager(this);
        liteModeGridLayoutManager = new GridLayoutManager(this, 2);

        liteModeRecyclerView = findViewById(R.id.lite_mode_recycler);

        liteModeRecyclerView.setHasFixedSize(true);
        liteModeRecyclerView.setLayoutManager(liteModeLayoutManager);
        liteModeRecyclerView.setAdapter(new MapAdapter(LIST_OF_LOCATIONS, getApplicationContext()));
        liteModeRecyclerView.setRecyclerListener(liteModeRecyclerListener);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.layout_linear:
                liteModeRecyclerView.setLayoutManager(liteModeLayoutManager);
                break;
            case R.id.layout_grid:
                liteModeRecyclerView.setLayoutManager(liteModeGridLayoutManager);
                break;
        }
        return true;
    }
}
