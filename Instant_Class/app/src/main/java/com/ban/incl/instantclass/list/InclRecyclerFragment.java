package com.ban.incl.instantclass.list;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ban.incl.instantclass.R;
import com.ban.incl.instantclass.adapter.InclRecyclerAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InclRecyclerFragment extends Fragment {

    private static ArrayList<PersonData> people;

    public InclRecyclerFragment() {
        // Required empty public constructor
    }

    public static InclRecyclerFragment newInstance() {
        InclRecyclerFragment fragment = new InclRecyclerFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_incl_list, container, false);

        RecyclerView mTimeRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mTimeRecyclerView.setHasFixedSize(true);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());

        RecyclerView.LayoutManager mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

        mTimeRecyclerView.setLayoutManager(mLayoutManager);

        people = new ArrayList<PersonData>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            people.add(new PersonData(
                    MyData.nameArray[i],
                    MyData.emailArray[i],
                    MyData.drawableArray[i],
                    MyData.id_[i]
            ));
        }

        InclRecyclerAdapter adapter = new InclRecyclerAdapter(people);
        mTimeRecyclerView.setAdapter(adapter);

        return view;
    }

}
