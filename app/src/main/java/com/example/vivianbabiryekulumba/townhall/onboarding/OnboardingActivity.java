package com.example.vivianbabiryekulumba.townhall.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.retrofit.BkRetroFitHelper;
import com.example.vivianbabiryekulumba.townhall.retrofit.BxRetroFitHelper;
import com.example.vivianbabiryekulumba.townhall.retrofit.MxRetroFitHelper;
import com.example.vivianbabiryekulumba.townhall.retrofit.QuRetroFitHelper;
import com.example.vivianbabiryekulumba.townhall.retrofit.StatRetroFitHelper;

public class OnboardingActivity extends AppCompatActivity {

    //    EditText boroughEt;
    Button bronxBtn;
    Button brooklynBtn;
    Button manhattanBtn;
    Button queensBtn;
    Button statenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

//        boroughEt = findViewById(R.id.borough_et);
        bronxBtn = findViewById(R.id.bronxBtn);
        brooklynBtn = findViewById(R.id.brooklynBtn);
        manhattanBtn = findViewById(R.id.manhattanBtn);
        queensBtn = findViewById(R.id.queensBtn);
        statenBtn = findViewById(R.id.statenBtn);

        bronxBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingActivity.this, BxRetroFitHelper.class);
                startActivity(intent);
            }
        });

        brooklynBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingActivity.this, BkRetroFitHelper.class);
                startActivity(intent);
            }
        });

        manhattanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingActivity.this, MxRetroFitHelper.class);
                startActivity(intent);
            }
        });

        queensBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingActivity.this, QuRetroFitHelper.class);
                startActivity(intent);
            }
        });

        statenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OnboardingActivity.this, StatRetroFitHelper.class);
                startActivity(intent);
            }
        });

    }
}
