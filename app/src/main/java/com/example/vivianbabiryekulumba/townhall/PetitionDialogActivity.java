package com.example.vivianbabiryekulumba.townhall;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.vivianbabiryekulumba.townhall.fragments.PetitionAddDialogFragment;

public class PetitionDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_dialog);

        PetitionAddDialogFragment petitionAddDialogFragment = new PetitionAddDialogFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.petition_add_container, petitionAddDialogFragment);
        transaction.commit();
    }
}
