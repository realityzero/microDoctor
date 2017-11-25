package com.example.nishantsikri.microdoctor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tapadoo.alerter.Alerter;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FeedbackActivity extends AppCompatActivity {

    Spinner feedback_spinner;
    TextView topic;
    EditText feedback_text,emailaddress,title_text;
    Button submit_feedback;
    String spinnerDataText;
    private DatabaseReference spinnerDatabase, mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        topic = (TextView) findViewById(R.id.topic);
        feedback_spinner = (Spinner) findViewById(R.id.feedback_spinner);
        feedback_text = (EditText) findViewById(R.id.feedback_text);
        submit_feedback = (Button) findViewById(R.id.submit_feedback);
        emailaddress = (EditText) findViewById(R.id.emailaddress);
        title_text = (EditText) findViewById(R.id.title_text);

        // Write a message to the database
        mFirebaseInstance = FirebaseDatabase.getInstance();
        spinnerDatabase = mFirebaseInstance.getReference("feedbackServer");
        mFirebaseDatabase = mFirebaseInstance.getReference("feedbackUser");
        feedback_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerDataText = feedback_spinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerData();

        submit_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String feed = feedback_text.getText().toString().trim();
                String email = emailaddress.getText().toString().trim();
                String title = title_text.getText().toString().trim();

                if (feed.length() < 6) {
                    feedback_text.setError("Enter some more description");
                    return;
                }
                if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailaddress.setError("Enter a Valid Email Address.");
                    return;
                }
                if (title.length() < 6) {
                    title_text.setError("Enter some more description");
                    return;
                }
                email = EncodeString(email);
                addData(spinnerDataText,feed,title,email);
                Alerter.create(FeedbackActivity.this)
                        .setTitle("Feedback Submitted!")
                        .setIcon(R.drawable.alerter_ic_face)
                        .enableProgress(true)
                        .setProgressColorRes(R.color.material_green600)
                        .setBackgroundColorRes(R.color.colorPrimary)
                        .enableSwipeToDismiss()
                        .show();
            }
        });
    }

    private void spinnerData() {
        spinnerDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Log.e("Spinner Data", "Spinner data is changed!");

                //DataSnapshot data = dataSnapshot;
                Iterable<DataSnapshot> temp = dataSnapshot.getChildren();
                ArrayList<String> list = new ArrayList<>();
//                list.add(dataSnapshot.getValue().toString());
//                showDataInSpinner(list);
                for (DataSnapshot lists : temp){
                    Log.d("ddd","Array List: "+lists.getValue().toString());
                    list.add(lists.getValue().toString());
//                    textView.setText(lists.getValue().toString());
                }
                showDataInSpinner(list);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("Error", "Failed to read user", error.toException());
            }
        });
    }
    public void showDataInSpinner(ArrayList<String> data) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, data
        ); //Create the Adapter to set the data
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //Set the layout resource to create the drop down views.
        feedback_spinner.setAdapter(adapter); //Set the data to your spinner
    }
    public void addData(String spinnerDataText, String feed, String title, String email){
        Log.e("tag","MEssage: "+mFirebaseDatabase.push().getKey());
        String uid = mFirebaseDatabase.push().getKey();

        mFirebaseDatabase.child(spinnerDataText).child(uid).child("Title").setValue(title);
        mFirebaseDatabase.child(spinnerDataText).child(uid).child("Email").setValue(email);
        mFirebaseDatabase.child(spinnerDataText).child(uid).child("Feedback").setValue(feed);
    }
    public static String EncodeString(String string) {
        return string.replace(".", ",");
    }
}
