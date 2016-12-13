package com.lnmiit.plinth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnmiit.plinth.Activity.SubActivity;
import com.lnmiit.plinth.Model.Data;
import com.lnmiit.plinth.R;

import java.util.ArrayList;

/**
 * Created by chanpreet on 13/12/16.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Data> list = new ArrayList<>();
    private int images[] ={R.drawable.ic_saturn,R.drawable.ic_coding,R.drawable.ic_robotics,R.drawable.ic_quiz,R.drawable.ic_literary,R.drawable.ic_analytics};

    public CardAdapter(Context context,ArrayList<Data> list)
    {
        this.context = context;
        this.list =list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_row_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.image.setImageResource(images[position]);
        holder.title.setText(list.get(position).getTitles());
        holder.description.setText(list.get(position).getDescription());
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

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent cardIntent = new Intent(context, SubActivity.class);
                    context.startActivity(cardIntent);
                }
            });
            image = (ImageView)itemView.findViewById(R.id.image);
            title = (TextView)itemView.findViewById(R.id.title);
            description =(TextView)itemView.findViewById(R.id.description);
        }

    }
}
