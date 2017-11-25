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

public class LeukemiaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpandableRelativeLayout leukemiaexpandableLayout1, leukemiaexpandableLayout2, leukemiaexpandableLayout3;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leukemia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Symptoms of PTSD");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.setNavigationBarColor(Color.parseColor("#00ACC1"));
        }

    }
    public void leukemiaexpandableButton1(View view) {
        leukemiaexpandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.leukemiaexpandableLayout1);
        leukemiaexpandableLayout1.toggle(); // toggle expand and collapse
    }

    public void leukemiaexpandableButton2(View view) {
        leukemiaexpandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.leukemiaexpandableLayout2);
        leukemiaexpandableLayout2.toggle(); // toggle expand and collapse
    }

    public void leukemiaexpandableButton3(View view) {
        leukemiaexpandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.leukemiaexpandableLayout3);
        leukemiaexpandableLayout3.toggle(); // toggle expand and collapse
    }
}
