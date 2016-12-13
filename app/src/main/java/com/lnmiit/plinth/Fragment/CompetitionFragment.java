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
import com.lnmiit.plinth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompetitionFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_competition, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.competition_recycler);
        adapter = new CardAdapter(getContext());
        linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        return v;
    }

}
