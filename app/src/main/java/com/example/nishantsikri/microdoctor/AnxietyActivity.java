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

public class AnxietyActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpandableRelativeLayout anxietyexpandableLayout1, anxietyexpandableLayout2, anxietyexpandableLayout3, anxietyexpandableLayout4;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anxiety);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sleep Disorders");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.setNavigationBarColor(Color.parseColor("#00ACC1"));
        }

    }
    public void anxietyexpandableButton1(View view) {
        anxietyexpandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.anxietyexpandableLayout1);
        anxietyexpandableLayout1.toggle(); // toggle expand and collapse
    }

    public void anxietyexpandableButton2(View view) {
        anxietyexpandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.anxietyexpandableLayout2);
        anxietyexpandableLayout2.toggle(); // toggle expand and collapse
    }

    public void anxietyexpandableButton3(View view) {
        anxietyexpandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.anxietyexpandableLayout3);
        anxietyexpandableLayout3.toggle(); // toggle expand and collapse
    }
}
