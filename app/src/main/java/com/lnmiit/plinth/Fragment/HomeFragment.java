package com.lnmiit.plinth.Fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lnmiit.plinth.Adapter.HomeAdapter;
import com.lnmiit.plinth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        tabLayout = (TabLayout)v.findViewById(R.id.home_tab);
        viewPager = (ViewPager)v.findViewById(R.id.home_pager);
        HomeAdapter homeAdapter =new HomeAdapter(getChildFragmentManager());
        homeAdapter.addFragment(new CompetitionFragment(),"Competition");
        homeAdapter.addFragment(new WorkshopFragment(),"Workshop");
        homeAdapter.addFragment(new LectureFragment(),"Lecture");
        viewPager.setAdapter(homeAdapter);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }

}
