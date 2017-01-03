package com.lnmiit.plinth.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lnmiit.plinth.Model.pager;
import com.lnmiit.plinth.R;

import java.util.ArrayList;

/**
 * Created by chanpreet on 1/1/17.
 */

public class Layer3Adapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<pager> list = new ArrayList<>();

    public Layer3Adapter(Context context, ArrayList<pager> list)
    {
        this.context = context;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(ScrollView)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row_layout_pager,container,false);
        TextView heading = (TextView) view.findViewById(R.id.heading);
        TextView description = (TextView) view.findViewById(R.id.description);
        Button bt = (Button) view.findViewById(R.id.pager_button);
        Button payment = (Button) view.findViewById(R.id.payment);
        if(position==list.size()-1)
        {
            bt.setVisibility(View.VISIBLE);
            payment.setVisibility(View.VISIBLE);
        }
        else {
            bt.setVisibility(View.GONE);
            payment.setVisibility(View.GONE);
        }
        String temp = list.get(position).getHeading();
        heading.setText(list.get(position).getHeading());
        description.setText(list.get(position).getDes());
        container.addView(view);
        return view;
     }
    @Override
    public float getPageWidth(int position) {
        return 0.9f;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
