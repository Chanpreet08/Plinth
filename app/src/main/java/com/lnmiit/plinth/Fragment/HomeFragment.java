package com.lnmiit.plinth.Fragment;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
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
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Competitions");
        tabLayout = (TabLayout)v.findViewById(R.id.home_tab);
        viewPager = (ViewPager)v.findViewById(R.id.home_pager);

        HomeAdapter homeAdapter =new HomeAdapter(getChildFragmentManager());
        homeAdapter.addFragment(new CompetitionFragment(),"");
        homeAdapter.addFragment(new WorkshopFragment(),"");
        homeAdapter.addFragment(new LectureFragment(),"");
        homeAdapter.addFragment(new ProfileFragment(),"");
        viewPager.setAdapter(homeAdapter);
        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_cup);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_pottery_man);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_conference);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_person_white_24px);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tabLayout.getSelectedTabPosition()){
                    case 0:
                        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Competitions");
                        break;
                    case 1:
                        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Workshops");
                        break;
                    case 2:
                        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Talk Series");
                        break;
                    case 3:
                        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Profile");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.parseColor("#9AA2AE"), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return v;
    }
}
