package com.example.vivianbabiryekulumba.townhall.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vivianbabiryekulumba.townhall.NavigationActivity;
import com.example.vivianbabiryekulumba.townhall.R;
import com.example.vivianbabiryekulumba.townhall.retrofit.BkRetroFragment;
import com.example.vivianbabiryekulumba.townhall.retrofit.BxRetroFragment;

public class OnBoardingActivity extends AppCompatActivity {
    private static final String TAG = "OBActivity.class";
    BxRetroFragment bxRetroFragment;
    BkRetroFragment bkRetroFragment;
    EditText boroughEt;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        boroughEt = findViewById(R.id.borough_et);
        submitBtn = findViewById(R.id.submit);
        bxRetroFragment = new BxRetroFragment();


        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("borough", boroughEt.getText().toString());
                Intent intent = new Intent(OnBoardingActivity.this, NavigationActivity.class);
                intent.putExtras(bundle);
                Log.d(TAG, "onClick: " + bundle);
                Log.d(TAG, "onClick: " + intent);
                startActivity(intent);
            }
        });
    }
}
