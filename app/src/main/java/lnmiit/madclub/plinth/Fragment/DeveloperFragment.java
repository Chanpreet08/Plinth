package lnmiit.madclub.plinth.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lnmiit.madclub.plinth.Adapter.DeveloperAdapter;
import lnmiit.madclub.plinth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeveloperFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_developer, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.developer_recycler);
        adapter = new DeveloperAdapter(getContext());
        linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        return v;
    }

}
