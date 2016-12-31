package com.lnmiit.plinth.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.lnmiit.plinth.Adapter.Layer2Adapter;
import com.lnmiit.plinth.Model.Data;
import com.lnmiit.plinth.R;

import java.util.ArrayList;

public class LiteratureActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Data> list = new ArrayList<>();
    private String title[];
    private String description[];
    private int images[]={R.drawable.ic_astro_hunt,R.drawable.ic_rostrum};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_literature);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.literature_recyceler);
        title = getResources().getStringArray(R.array.literature);
        description = getResources().getStringArray(R.array.literature_description);
        adapter = new Layer2Adapter(this,list);
        linearLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        loadMainDetails();
    }

    private void loadMainDetails() {
        for (int i = 0; i < title.length; i++) {
            list.add(new Data(title[i],description[i],images[i]));
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