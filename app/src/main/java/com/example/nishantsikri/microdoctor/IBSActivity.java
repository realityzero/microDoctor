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

public class IBSActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpandableRelativeLayout ibsexpandableLayout1, ibsexpandableLayout2, ibsexpandableLayout3;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Irritable Bowel Syndrome");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.setNavigationBarColor(Color.parseColor("#00ACC1"));
        }



    }
    public void ibsexpandableButton1(View view) {
        ibsexpandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.ibsexpandableLayout1);
        ibsexpandableLayout1.toggle(); // toggle expand and collapse
    }

    public void ibsexpandableButton2(View view) {
        ibsexpandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.ibsexpandableLayout2);
        ibsexpandableLayout2.toggle(); // toggle expand and collapse
    }

    public void ibsexpandableButton3(View view) {
        ibsexpandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.ibsexpandableLayout3);
        ibsexpandableLayout3.toggle(); // toggle expand and collapse
    }

}
