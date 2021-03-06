package com.rana.duasurah;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHOlder> {

    private final String[] data , ok;
    public MyAdapter(String[] data, String[] ok){
        this.data=data;
        this.ok=ok;
    }



    @NonNull
    @Override
    public MyViewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row,parent,false);


        return new MyViewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHOlder holder, int position) {
        final String myData = data[position];
        final String mData = ok[position];
        holder.button.setText(myData);
        holder.button.setOnClickListener(v -> {
            Context context = v.getContext();


//            Toast.makeText(context, "Click " + position + " " +myData, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, ViewLayout.class);
            intent.putExtra("textItem", mData);
            intent.putExtra("toolbar", myData);
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public static class MyViewHOlder extends RecyclerView.ViewHolder{

        Button button;


        public MyViewHOlder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.txt);

        }
    }

}

