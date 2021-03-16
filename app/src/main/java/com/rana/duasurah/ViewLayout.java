package com.rana.duasurah;

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
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Objects;

public class ViewLayout extends AppCompatActivity {
    private AdView mAdView;

    private static final String TAG = "ViewLayout";
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout);
        Log.d(TAG, "onCreate: started.");

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(getString(R.string.Banner_ads_unit_id));

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        toolbar = findViewById(R.id.activityToolBar);
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


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
