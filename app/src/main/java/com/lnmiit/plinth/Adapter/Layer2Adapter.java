package com.lnmiit.plinth.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnmiit.plinth.Model.Data;
import com.lnmiit.plinth.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chanpreet on 31/12/16.
 */

public class Layer2Adapter extends RecyclerView.Adapter<Layer2Adapter.ViewHolder> {

    private Context context;
    private ArrayList<Data> list = new ArrayList<>();

    public Layer2Adapter(Context context, ArrayList list)
    {
        this.context = context;
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_row_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(list.get(position).getTitles());
        holder.description.setText(list.get(position).getDescription());
        holder.image.setImageResource(list.get(position).getImages());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    protected class ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView image;
        private TextView title;
        private TextView description;
        private View view;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;

            image = (ImageView)itemView.findViewById(R.id.image);
            title = (TextView)itemView.findViewById(R.id.title);
            description =(TextView)itemView.findViewById(R.id.description);
        }
    }
}
