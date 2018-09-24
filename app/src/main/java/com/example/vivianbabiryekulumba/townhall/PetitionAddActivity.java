package com.example.vivianbabiryekulumba.townhall;

import android.arch.lifecycle.LiveData;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vivianbabiryekulumba.townhall.database.Petition;
import com.example.vivianbabiryekulumba.townhall.database.PetitionApplication;
import com.example.vivianbabiryekulumba.townhall.database.PetitionDao;
import com.example.vivianbabiryekulumba.townhall.database.PetitionDatabase;
import com.example.vivianbabiryekulumba.townhall.database.PetitionListPresenter;
import com.example.vivianbabiryekulumba.townhall.database.PetitionObserver;

public class PetitionAddActivity extends AppCompatActivity{

    private static final String TAG = "PetitionAdd";
    PetitionListPresenter petitionListPresenter;
    PetitionDao petitionDao;
    TextInputEditText editTextTitle;
    TextInputEditText editTextContent;
    Button submitPetition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_dialog);

        editTextTitle = findViewById(R.id.petition_title_edit_text);
        editTextContent = findViewById(R.id.petition_content_edit_text);
        submitPetition = findViewById(R.id.submit_petition_btn);

        PetitionDatabase db = ((PetitionApplication) getApplication()).getPetitionDatabase();
        PetitionDao petitionDao = db.petitionDao();

        petitionListPresenter = new PetitionListPresenter(petitionDao);

        LiveData<Petition[]> petitions = petitionDao.getAllPetitions();
        petitions.observe(this, new PetitionObserver(petitionListPresenter));

        submitPetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                petitionListPresenter.addPetition(editTextTitle.getText().toString(), editTextContent.getText().toString());
                Intent intent = new Intent(PetitionAddActivity.this, PetitionListActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick: " + editTextTitle + editTextContent);
            }
        });
    }

}
