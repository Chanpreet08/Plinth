package com.lnmiit.plinth.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.lnmiit.plinth.Adapter.Layer3Adapter;
import com.lnmiit.plinth.Model.pager;
import com.lnmiit.plinth.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class TransporterActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private Layer3Adapter adapter;
    private String[] heading;
    private String[] des;
    private ArrayList<pager> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transporter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Transporter");
        viewPager = (ViewPager) findViewById(R.id.pager_transporter);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator_transporter);
        heading = getResources().getStringArray(R.array.transporter_heading);
        des = getResources().getStringArray(R.array.transporter_des);
        adapter = new Layer3Adapter(this,list);
        viewPager.setClipToPadding(false);
        viewPager.setPageMargin(35);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(adapter);
        circleIndicator.setViewPager(viewPager);
        adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        loadMainDetails();
    }

    private void loadMainDetails() {
        for (int i = 0; i < heading.length; i++) {
            list.add(new pager(heading[i],des[i]));
        }
        adapter.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home)
        {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}