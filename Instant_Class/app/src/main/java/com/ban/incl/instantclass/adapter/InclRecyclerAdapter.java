package com.ban.incl.instantclass.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.list.PersonData;

import java.util.ArrayList;

/**
 * Created by sc.ban on 2015.06.28
 */
public class InclRecyclerAdapter extends RecyclerView.Adapter<InclRecyclerAdapter.MyViewHolder> {

    private ArrayList<PersonData> peopleDataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewEmail;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewEmail = (TextView) itemView.findViewById(R.id.textViewEmail);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public InclRecyclerAdapter(ArrayList<PersonData> people) {
        this.peopleDataSet = people;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards_layout, parent, false);

//        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewEmail = holder.textViewEmail;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(peopleDataSet.get(listPosition).getName());
        textViewEmail.setText(peopleDataSet.get(listPosition).getEmail());
        imageView.setImageResource(peopleDataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return peopleDataSet.size();
    }

}