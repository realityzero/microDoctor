package com.example.nishantsikri.microdoctor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tapadoo.alerter.Alerter;

import java.security.SecurityPermission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import moe.feng.common.stepperview.VerticalStepperItemView;

public class SymptomActivity extends AppCompatActivity {


    static boolean calledAlready = false;
    //Integer i = 3;
    private DatabaseReference mFirebaseDatabase, spinnerDatabase;
    private FirebaseDatabase mFirebaseInstance;
    Button button,add_button,sub_button;
    TextView textView,symptom1,symptom2,symptom3;
    Spinner spinner,spinner2,spinner3;
    String textSymptom1,textSymptom2,textSymptom3;
    String symptom;
    private VerticalStepperItemView mSteppers[] = new VerticalStepperItemView[3];
    private Button mNextBtn0, mNextBtn1, mPrevBtn1, button_three_result, mPrevBtn2, button_two_result, btn_change_point_color, btn_change_done_icon;

    private int mActivatedColorRes = R.color.material_deep_purple_500;
    private int mDoneIconRes = R.drawable.ic_done_white_16dp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptom);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Symptom Checker");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.setNavigationBarColor(Color.parseColor("#00ACC1"));
        }

//        button = (Button) findViewById(R.id.button8);
//        add_button = (Button) findViewById(R.id.add_button);
//        sub_button = (Button) findViewById(R.id.sub_button);
//        textView = (TextView) findViewById(R.id.textView2);

        //symptom1 = (TextView) findViewById(R.id.symptom1);
//        symptom2 = (TextView) findViewById(R.id.symptom2);
//        symptom3 = (TextView) findViewById(R.id.symptom3);
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
//        spinner4 = (Spinner) findViewById(R.id.spinner4);
//
//        spinner3.setEnabled(false);
//        spinner3.setVisibility(View.GONE);
//        symptom3.setVisibility(View.GONE);
//        spinner4.setVisibility(View.GONE);
       // add_button.setEnabled(false);
        spinner.setPrompt("Select Symptom");
        spinner2.setPrompt("Select Symptom");
        spinner3.setPrompt("Select Symptom");

        mSteppers[0] = (VerticalStepperItemView) findViewById(R.id.stepper_0);
        mSteppers[1] = (VerticalStepperItemView) findViewById(R.id.stepper_1);
        mSteppers[2] = (VerticalStepperItemView)  findViewById(R.id.stepper_2);

        VerticalStepperItemView.bindSteppers(mSteppers);

        mNextBtn0 = (Button) findViewById(R.id.button_next_0);
        mNextBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[0].nextStep();
            }
        });

        button_two_result = (Button) findViewById(R.id.button_two_result);
        button_two_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (mSteppers[0].getErrorText() != null) {
//                    mSteppers[0].setErrorText(null);
//                } else {
//                    mSteppers[0].setErrorText("Test error!");
//                }
                if(textSymptom1.equals(textSymptom2)){
                    Alerter.create(SymptomActivity.this)
                            .setTitle("Do I look like a fool? Stop putting same values. ._.")
                            .setIcon(R.drawable.alert_white)
                            .setBackgroundColorRes(R.color.red500)
                            .enableSwipeToDismiss()
                            .setProgressColorRes(R.color.material_green600)
                            .show();
                    return;
                }
                readDataListenerForTwo();
            }
        });

        mPrevBtn1 = (Button) findViewById(R.id.button_prev_1);
        mPrevBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[1].prevStep();
            }
        });

        mNextBtn1 = (Button) findViewById(R.id.button_next_1);
        mNextBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[1].nextStep();
            }
        });

        mPrevBtn2 = (Button) findViewById(R.id.button_prev_2);
        mPrevBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSteppers[2].prevStep();
            }
        });

        button_three_result = (Button) findViewById(R.id.button_three_result);
        button_three_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textSymptom1.equals(textSymptom2) || textSymptom2.equals(textSymptom3) || textSymptom3.equals(textSymptom1)){
                    Alerter.create(SymptomActivity.this)
                            .setTitle("Do I look like a fool? Stop putting same values. ._.")
                            .setIcon(R.drawable.alert_white)
                            .enableProgress(true)
                            .setProgressColorRes(R.color.material_green600)
                            .setBackgroundColorRes(R.color.red500)
                            .enableSwipeToDismiss()
                            .show();
                    return;
                }
                readDataListener();
            }
        });

//        btn_change_point_color = (Button) findViewById(R.id.btn_change_point_color);
//        btn_change_point_color.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mActivatedColorRes == R.color.material_blue_500) {
//                    mActivatedColorRes = R.color.material_deep_purple_500;
//                } else {
//                    mActivatedColorRes = R.color.material_blue_500;
//                }
//                for (VerticalStepperItemView stepper : mSteppers) {
//                    stepper.setActivatedColorResource(mActivatedColorRes);
//                }
//            }
//        });
//
//        btn_change_done_icon = (Button)  findViewById(R.id.btn_change_done_icon);
//        btn_change_done_icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (mDoneIconRes == R.drawable.ic_done_white_16dp) {
//                    mDoneIconRes = R.drawable.ic_save_white_16dp;
//                } else {
//                    mDoneIconRes = R.drawable.ic_done_white_16dp;
//                }
//                for (VerticalStepperItemView stepper : mSteppers) {
//                    stepper.setDoneIconResource(mDoneIconRes);
//                }
//            }
//        });

        if (!calledAlready)
        {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            calledAlready = true;
        }


        // Write a message to the database
        mFirebaseInstance = FirebaseDatabase.getInstance();
        // store app title to 'app_title' node
        mFirebaseInstance.getReference("app_title").setValue("microDoctor");
        mFirebaseDatabase = mFirebaseInstance.getReference("symptomList");
        spinnerDatabase = mFirebaseInstance.getReference("symptomView");
        //mFirebaseDatabase.child("Headache").child("Some Value").setValue("Head");
        //mFirebaseDatabase.setValue("Headache");


        spinnerData();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textSymptom1 = spinner.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textSymptom2 = spinner2.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textSymptom3 = spinner3.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
//        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                textSymptom3 = spinner4.getItemAtPosition(i).toString();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(i == 3)
//                    readDataListener();
//                else
//                    readDataListenerForTwo();
//            }
//        });
//        add_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                spinner3.setEnabled(true);
//                spinner3.setVisibility(View.VISIBLE);
//                symptom3.setVisibility(View.VISIBLE);
//                add_button.setEnabled(false);
//                sub_button.setEnabled(true);
//                ++i;
//                Log.e("Value i","Value of i: "+i);
//            }
//        });
//        sub_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                spinner3.setEnabled(false);
//                spinner3.setVisibility(View.GONE);
//                symptom3.setVisibility(View.GONE);
//                add_button.setEnabled(true);
//                sub_button.setEnabled(false);
//                --i;
//                Log.e("Value i","Value of i: "+i);
//            }
//        });

    }

    private void readDataListener() {
        mFirebaseDatabase.child(textSymptom1).child(textSymptom2).child(textSymptom3).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String symptom = dataSnapshot.child("disease").getValue(String.class);

                // Check for null
                if (symptom == null) {
                    Log.e("Data", "Symptom data is null!");
                    Alerter.create(SymptomActivity.this)
                            .setTitle("Oops! Couldn't find the disease.")
                            .setIcon(R.drawable.alert)
                            .show();
                    new MaterialStyledDialog.Builder(SymptomActivity.this)
                            .setTitle("Oops! Couldn't find the disease")
                            .setDescription("Please Fill Feedback to help us for further improvements and run our potato servers or you can Stay Here and try again.")
                            .setStyle(Style.HEADER_WITH_ICON)
                            .setIcon(R.drawable.alert_white)
                            .setHeaderColor(R.color.indigo)
                            .withIconAnimation(true)
                            .withDialogAnimation(true)
                            .withDivider(true)
                            .setPositiveText("Fill Feedback")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    Log.d("Positive", "Feedback");
                                                Intent intent = new Intent(getApplicationContext(),FeedbackActivity.class);
                                                finish();
                                                startActivity(intent);
                                }})
                            .setNegativeText("Stay Here!")
                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    Log.d("Negative", "Stay Here!");
                                }})
                            .show();
                    return;
                }


                Log.e("Symptom Data", "User data is changed!"+symptom);

                // Display newly updated name and email
              //  textView.setText(symptom+"\n"+dataSnapshot.getKey());
                Intent intent = new Intent(getApplicationContext(),DiseaseActivity.class);
                intent.putExtra("key", symptom);
                finish();
                startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("Error", "Failed to read user", error.toException());
            }
        });
    }
    public void readDataListenerForTwo(){
        mFirebaseDatabase.child(textSymptom1).child(textSymptom2).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String symptom = dataSnapshot.child("disease").getValue(String.class);

                // Check for null
                if (symptom == null) {
                    Log.e("Data", "Symptom data is null!");
                    Alerter.create(SymptomActivity.this)
                            .setTitle("Oops! Couldn't find the disease.")
                            .setIcon(R.drawable.alert)
                            .show();
                    new MaterialStyledDialog.Builder(SymptomActivity.this)
                            .setTitle("Oops! Couldn't find the disease")
                            .setDescription("Please Fill Feedback to help us for further improvements and run our potato servers or you can Stay Here and try again.")
                            .setStyle(Style.HEADER_WITH_ICON)
                            .setIcon(R.drawable.alert_white)
                            .setHeaderColor(R.color.indigo)
                            .withIconAnimation(true)
                            .withDialogAnimation(true)
                            .withDivider(true)
                            .setPositiveText("Fill Feedback")
                            .onPositive(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    Log.d("Positive", "Feedback");
                                                Intent intent = new Intent(getApplicationContext(),FeedbackActivity.class);
                                                finish();
                                                startActivity(intent);
                                }})
                            .setNegativeText("Stay Here!")
                            .onNegative(new MaterialDialog.SingleButtonCallback() {
                                @Override
                                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                                    Log.d("Negative", "Stay Here!");
                                }})
                            .show();
                    return;
                }

                Log.e("Symptom Data", "User data is changed!"+symptom);

                // Display newly updated name and email
               // textView.setText(symptom+"\n"+dataSnapshot.getKey());
                Intent intent = new Intent(getApplicationContext(),DiseaseActivity.class);
                intent.putExtra("key", symptom);
                finish();
                startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("Error", "Failed to read user", error.toException());
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
        spinner.setAdapter(adapter); //Set the data to your spinner
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
    }
//    public void showDataInSpinner4(ArrayList<String> data) {
//        ArrayAdapter<String> adapter4 = new ArrayAdapter<>(
//                this, android.R.layout.simple_spinner_item, data
//        ); //Create the Adapter to set the data
//        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //Set the layout resource to create the drop down views.
//        spinner4.setAdapter(adapter4); //Set the data to your spinner
//    }
}
