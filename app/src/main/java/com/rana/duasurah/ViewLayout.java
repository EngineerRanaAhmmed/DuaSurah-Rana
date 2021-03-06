package com.rana.duasurah;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class ViewLayout extends AppCompatActivity {

    private static final String TAG = "ViewLayout";
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_layout);
        Log.d(TAG, "onCreate: started.");

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
