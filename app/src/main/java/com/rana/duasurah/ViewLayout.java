package com.rana.duasurah;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Objects;

public class ViewLayout extends AppCompatActivity {

    private static final String TAG = "ViewLayout";
    Toolbar toolbar;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout);
        Log.d(TAG, "onCreate: started.");

        toolbar = findViewById(R.id.activityToolBar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.Banner_ads_unit_id));

        MobileAds.initialize(this, initializationStatus -> {
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        text();
        title();
    }

    private void text(){
        if (getIntent().hasExtra("textItem")){
            String textName = getIntent().getStringExtra("textItem");
            setText(textName);
        }
    }

    private void setText(String textItem){
        TextView textView = findViewById(R.id.activityPageText);
        textView.setText(textItem);
    }

    private void title(){
        if (getIntent().hasExtra("toolbar")){
            String toolBarChange = getIntent().getStringExtra("toolbar");
            setTitle(toolBarChange);
        }
    }

    private void setTitle(String toolBarItem){
        Toolbar mToolBar = findViewById(R.id.activityToolBar);
        mToolBar.setTitle(toolBarItem);
    }


}
