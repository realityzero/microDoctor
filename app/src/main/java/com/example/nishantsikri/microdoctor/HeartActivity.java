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

public class HeartActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpandableRelativeLayout heartexpandableLayout1, heartexpandableLayout2, heartexpandableLayout3, heartexpandableLayout4;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Symptoms of PTSD");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.setNavigationBarColor(Color.parseColor("#00ACC1"));
        }

    }
    public void heartexpandableButton1(View view) {
        heartexpandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.heartexpandableLayout1);
        heartexpandableLayout1.toggle(); // toggle expand and collapse
    }

    public void heartexpandableButton2(View view) {
        heartexpandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.heartexpandableLayout2);
        heartexpandableLayout2.toggle(); // toggle expand and collapse
    }

    public void heartexpandableButton3(View view) {
        heartexpandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.heartexpandableLayout3);
        heartexpandableLayout3.toggle(); // toggle expand and collapse
    }
    public void heartexpandableButton4(View view) {
        heartexpandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.heartexpandableLayout4);
        heartexpandableLayout4.toggle(); // toggle expand and collapse
    }
}
