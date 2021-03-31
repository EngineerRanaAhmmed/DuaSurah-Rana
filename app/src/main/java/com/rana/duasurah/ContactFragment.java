package com.rana.duasurah;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;

import androidx.fragment.app.Fragment;

public class ContactFragment extends Fragment {
    Animation animation;
    ScrollView scrollView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in);
        scrollView = view.findViewById(R.id.contactLayout);
        scrollView.setAnimation(animation);

        return view;
    }
}