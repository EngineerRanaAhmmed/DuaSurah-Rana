package com.rana.duasurah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;


public class PrivacyPolicyFragment extends Fragment {
    Animation animation;
    ScrollView scrollView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_privacy_policy, container, false);

        animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in);
        scrollView = view.findViewById(R.id.privacyLayout);
        scrollView.setAnimation(animation);

        return view;
    }
}