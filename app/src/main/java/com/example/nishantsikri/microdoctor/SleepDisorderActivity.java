package com.example.nishantsikri.microdoctor;

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

//Recycler View
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;

import java.util.ArrayList;
import java.util.List;

import com.example.nishantsikri.microdoctor.Adapter.MyAdapter;
import com.example.nishantsikri.microdoctor.Models.TitleChild;
import com.example.nishantsikri.microdoctor.Models.TitleCreator;
import com.example.nishantsikri.microdoctor.Models.TitleParent;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tapadoo.alerter.Alerter;

public class SleepDisorderActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ExpandableRelativeLayout expandableLayout1, expandableLayout2, expandableLayout3, expandableLayout4;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_disorder);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Sleep Disorders");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow(); // in Activity's onCreate() for instance
            w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            w.setNavigationBarColor(Color.parseColor("#00ACC1"));
        }



        //Recycler View
//        recyclerView = (RecyclerView)findViewById(R.id.myRecyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        MyAdapter adapter = new MyAdapter(this,initData());
//        adapter.setParentClickableViewAnimationDefaultDuration();
//        adapter.setParentAndIconExpandOnClick(true);
//
//        recyclerView.setAdapter(adapter);

    }


    public void expandableButton1(View view) {
        expandableLayout1 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout1);
        expandableLayout1.toggle(); // toggle expand and collapse
    }

    public void expandableButton2(View view) {
        expandableLayout2 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout2);
        expandableLayout2.toggle(); // toggle expand and collapse
    }

    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    public void expandableButton4(View view) {
        expandableLayout4 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout4);
        expandableLayout4.toggle(); // toggle expand and collapse
    }

    //Function for Recycler View
//    private List<ParentObject> initData() {
//        String title1 = "Good Sleep Habits";
//        String title2 = "Sleep Disorders";
//        String title3 = "What Affects Sleep";
//        String title4 = "Tests & Treatments";
//        String title1_option1=getString(R.string.title1_option1);
//        String title1_option2=getString(R.string.title1_option2);
//        TitleCreator titleCreator = TitleCreator.get(this,title1,title2,title3,title4);
//        List<TitleParent> titles = titleCreator.getAll();
//        List<ParentObject> parentObject = new ArrayList<>();
//        String arr[] = new String[]{getString(R.string.title1_option1),getString(R.string.title1_option2),getString(R.string.title2_option1),getString(R.string.title2_option2),getString(R.string.title3_option1),getString(R.string.title3_option2),getString(R.string.title4_option1),getString(R.string.title4_option2)};
//        int i=0;
//            for (TitleParent title : titles) {
//                List<Object> childList = new ArrayList<>();
//                childList.add(new TitleChild(arr[i], arr[i+1]));
//                title.setChildObjectList(childList);
//                parentObject.add(title);
//                i=i+2;
//            }
//
//        return parentObject;
//
//    }
}
