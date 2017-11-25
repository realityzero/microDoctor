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

public class PTSDActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpandableRelativeLayout ptsdexpandableLayout1, ptsdexpandableLayout2, ptsdexpandableLayout3, ptsdexpandableLayout4;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ptsd);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Symptoms of PTSD");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.setNavigationBarColor(Color.parseColor("#00ACC1"));
        }


    }
    public void ptsdexpandableButton1(View view) {
        ptsdexpandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.ptsdexpandableLayout1);
        ptsdexpandableLayout1.toggle(); // toggle expand and collapse
    }

    public void ptsdexpandableButton2(View view) {
        ptsdexpandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.ptsdexpandableLayout2);
        ptsdexpandableLayout2.toggle(); // toggle expand and collapse
    }

    public void ptsdexpandableButton3(View view) {
        ptsdexpandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.ptsdexpandableLayout3);
        ptsdexpandableLayout3.toggle(); // toggle expand and collapse
    }
    public void ptsdexpandableButton4(View view) {
        ptsdexpandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.ptsdexpandableLayout4);
        ptsdexpandableLayout4.toggle(); // toggle expand and collapse
    }
}
