package lnmiit.madclub.plinth.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lnmiit.madclub.plinth.Adapter.LectureAdapter;
import lnmiit.madclub.plinth.Model.Lecture;
import lnmiit.madclub.plinth.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LectureFragment extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private String[] title;
    private String[] des ;
    private String[] images={"http://bit.ly/2iT1hdF","http://bit.ly/2ja97QC","http://bit.ly/2hTeEJI","http://bit.ly/2iEjYzu"};
    private String[] facebook={"http://bit.ly/2i3BeiL","http://bit.ly/2iQ3i7A","http://bit.ly/2ibgrY1","http://bit.ly/2iQ52hl"};
    private String[] wikipedia={"http://bit.ly/2i3wPw9","http://bit.ly/2hRKTdS","",""};
    private String[] twitter={"","http://bit.ly/2ibfX4u","http://bit.ly/2ibjkrT",""};
    private ArrayList<Lecture> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lecture, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.lecture_recycler);
        title= getResources().getStringArray(R.array.lecture_title);
        des= getResources().getStringArray(R.array.lecture_des);
        adapter = new LectureAdapter(getContext(),list);
        linearLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadMainDetails();
        return v;
    }
    private void loadMainDetails() {
        for (int i = 0; i < title.length; i++) {
            list.add(new Lecture(title[i],des[i],images[i],facebook[i],wikipedia[i],twitter[i]));
        }
        adapter.notifyDataSetChanged();
    }
}
