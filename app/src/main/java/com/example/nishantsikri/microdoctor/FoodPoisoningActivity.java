package com.example.nishantsikri.microdoctor;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.nishantsikri.microdoctor.Adapter.MyAdapter;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class FoodPoisoningActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpandableRelativeLayout foodexpandableLayout1, foodexpandableLayout2, foodexpandableLayout3, foodexpandableLayout4;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_poisoning);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Food Poisoning");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.setNavigationBarColor(Color.parseColor("#00ACC1"));
        }


    }
    public void foodexpandableButton1(View view) {
        foodexpandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.foodexpandableLayout1);
        foodexpandableLayout1.toggle(); // toggle expand and collapse
    }

    public void foodexpandableButton2(View view) {
        foodexpandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.foodexpandableLayout2);
        foodexpandableLayout2.toggle(); // toggle expand and collapse
    }

    public void foodexpandableButton3(View view) {
        foodexpandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.foodexpandableLayout3);
        foodexpandableLayout3.toggle(); // toggle expand and collapse
    }

    public void foodexpandableButton4(View view) {
        foodexpandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.foodexpandableLayout4);
        foodexpandableLayout4.toggle(); // toggle expand and collapse
    }
}
