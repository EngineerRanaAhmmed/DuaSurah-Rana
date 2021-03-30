package com.rana.duasurah;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    Animation animation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        int resId = R.anim.layout_animation_up_to_down;
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(getContext(), resId);


        TextView textView = view.findViewById(R.id.marqueeText);
        textView.setSelected(true);


        String[] sms = getResources().getStringArray(R.array.button_name);
        String[] ok = getResources().getStringArray(R.array.item_text);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyAdapter(sms, ok));

        animation = AnimationUtils.loadAnimation(getContext(), R.anim.re_anim);
        recyclerView.setAnimation(animation);




        return view;

    }
}