package com.rana.duasurah;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ExitDialog extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_exit_dialog, container, false);

        TextView rate, no, yes;

        rate = view.findViewById(R.id.rateUsExit);
        no = view.findViewById(R.id.noExit);
        yes = view.findViewById(R.id.yesExit);

        yes.setOnClickListener(v -> {
            getActivity().finishAffinity();
        });

        no.setOnClickListener(v -> {
            dismiss();
        });

        rate.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getActivity().getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            dismiss();
        });

        return view;
    }
}