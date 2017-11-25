package com.example.nishantsikri.microdoctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DiseaseActivity extends AppCompatActivity {

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    TextView diseaseText;
    String diseaseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        diseaseText = (TextView) findViewById(R.id.diseaseText);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiseaseActivity.this,SymptomActivity.class);
                finish();
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            diseaseName = bundle.getString("key");
            Log.e("tag","Received: "+diseaseName);
            getSupportActionBar().setTitle(diseaseName);
        }

        // Write a message to the database
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("diseaseDescription");
        readDataListener();
    }
    private void readDataListener(){
        mFirebaseDatabase.child(diseaseName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String description = dataSnapshot.getValue(String.class);

                // Check for null
                if (description == null) {
                    Log.e("Data", "Symptom data is null!");
                    return;
                }

                Log.e("Symptom Data", "User data is changed!"+description);

                // Display newly updated name and email
                diseaseText.setText(Html.fromHtml(description+"\n"+dataSnapshot.getKey()));
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
