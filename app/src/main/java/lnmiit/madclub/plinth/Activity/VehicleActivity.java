package lnmiit.madclub.plinth.Activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import lnmiit.madclub.plinth.Adapter.Layer3Adapter;
import lnmiit.madclub.plinth.Model.pager;
import lnmiit.madclub.plinth.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class VehicleActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Layer3Adapter adapter;
    private String[] heading;
    private String[] des;
    private ArrayList<pager> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Vehicle Design and Dynamics");
        viewPager = (ViewPager) findViewById(R.id.pager_vehicle);
        CircleIndicator circleIndicator = (CircleIndicator) findViewById(R.id.indicator_vehicle);
        heading = getResources().getStringArray(R.array.vehicle_heading);
        des = getResources().getStringArray(R.array.vehicle_des);
        adapter = new Layer3Adapter(this,list,"vehicle");
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
