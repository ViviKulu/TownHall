package com.example.vivianbabiryekulumba.townhall;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.vivianbabiryekulumba.townhall.database.PetitionListPresenter;

public class PetitionAddActivity extends AppCompatActivity {

    private static final String TAG = "PetitionAdd";
    PetitionListPresenter petitionListPresenter;
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

        submitPetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPetitionDetail(editTextTitle.getText().toString(), editTextContent.getText().toString());
                Log.d(TAG, "onClick: " + editTextTitle.getText().toString() + editTextContent.getText().toString());
            }
        });
    }

    public void addPetitionDetail(String petition_title, String petition_content) {
        petitionListPresenter.addPetition(petition_title, petition_content);
        Log.d(TAG, "addPetitionDetail: " + petition_title + petition_content);
    }
}
