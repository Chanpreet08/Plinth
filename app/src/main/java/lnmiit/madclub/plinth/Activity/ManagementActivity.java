package lnmiit.madclub.plinth.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import lnmiit.madclub.plinth.Adapter.Layer2Adapter;
import lnmiit.madclub.plinth.Model.Data;
import lnmiit.madclub.plinth.R;

import java.util.ArrayList;

public class ManagementActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private ArrayList<Data> list = new ArrayList<>();
    private String title[];
    private String description[];
    private int images[]={R.drawable.sif};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Management");
        recyclerView = (RecyclerView) findViewById(R.id.management_recycler);
        title = getResources().getStringArray(R.array.management);
        description = getResources().getStringArray(R.array.management_description);
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
