package com.lnmiit.plinth.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lnmiit.plinth.Adapter.CardAdapter;
import com.lnmiit.plinth.Model.Data;
import com.lnmiit.plinth.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkshopFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<Data> list = new ArrayList<>();
    private LinearLayoutManager linearLayoutManager;
    private String[] title;
    private String[] description;
    private int images[]={R.drawable.ic_vehicle,R.drawable.ic_webomaster,R.drawable.augmented};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_workshop, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.workshop_recycler);
        title = getResources().getStringArray(R.array.workshop_heading);
        description = getResources().getStringArray(R.array.workshop_des);
        adapter = new CardAdapter(getContext(),list);
        linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadMainDetails();

        return v;
    }

    private void loadMainDetails() {
        for (int i = 0; i < title.length; i++) {
            list.add(new Data(title[i],description[i],images[i]));
        }
        adapter.notifyDataSetChanged();
    }
}
