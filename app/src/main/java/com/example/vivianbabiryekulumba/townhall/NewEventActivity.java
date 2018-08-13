package com.example.vivianbabiryekulumba.townhall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.vivianbabiryekulumba.townhall.models.Event;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewEventActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;
    EditText newEventTitle;
    EditText newEventContent;
    Button submitEvent;
    Button main_menu;

    private static final String TAG = "NewEveActivity.class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        newEventTitle = findViewById(R.id.newEventTitle);
        newEventContent = findViewById(R.id.newEventContent);
        submitEvent = findViewById(R.id.submitEvent);
        main_menu = findViewById(R.id.event_main_menu);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        submitEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeNewEvent(newEventTitle.getText().toString(), newEventContent.getText().toString());
                Toast.makeText(getApplicationContext(), "Submitted!", Toast.LENGTH_SHORT).show();
            }
        });

        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewEventActivity.this, NavigationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void writeNewEvent(String event_title, String event_content) {
        Event event = new Event(event_title, event_content);
        databaseReference.child("event").child(event_title).setValue(event);
        Log.d(TAG, "writeNewEvent: " + event);
    }
}
