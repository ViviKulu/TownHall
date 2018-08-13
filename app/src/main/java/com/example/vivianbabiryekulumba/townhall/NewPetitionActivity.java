package com.example.vivianbabiryekulumba.townhall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vivianbabiryekulumba.townhall.models.Petition;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewPetitionActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    EditText newPetitionTitle;
    EditText newPetitionContent;
    Button submitPetition;
    Button main_menu;
    private static final String TAG = "NewPetActivity.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_petition);
        newPetitionTitle = findViewById(R.id.newPetitionTitle);
        newPetitionContent = findViewById(R.id.newPetitionContent);
        submitPetition = findViewById(R.id.submitPetition);
        main_menu = findViewById(R.id.petition_main_menu);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        submitPetition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeNewPetition(newPetitionTitle.getText().toString(), newPetitionContent.getText().toString());
                Toast.makeText(getApplicationContext(), "Submitted!", Toast.LENGTH_SHORT).show();
            }
        });

        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewPetitionActivity.this, NavigationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void writeNewPetition(String petition_title, String petition_content) {
        Petition petition = new Petition(petition_title, petition_content);
        databaseReference.child("petition").child(petition_title).setValue(petition);
        Log.d(TAG, "writeNewPetition: " + petition);
    }
}
