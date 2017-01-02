package com.lnmiit.plinth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnmiit.plinth.Activity.AstronomyActivity;
import com.lnmiit.plinth.Activity.CodingActivity;
import com.lnmiit.plinth.Activity.LiteratureActivity;
import com.lnmiit.plinth.Activity.ManagementActivity;
import com.lnmiit.plinth.Activity.QuizzingActivity;
import com.lnmiit.plinth.Activity.RoboticsActivity;
import com.lnmiit.plinth.Model.Data;
import com.lnmiit.plinth.R;

import java.util.ArrayList;

/**
 * Created by chanpreet on 13/12/16.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Data> list = new ArrayList<>();

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
        final int pos = position;

        holder.image.setImageResource(list.get(position).getImages());
        holder.title.setText(list.get(position).getTitles());
        holder.description.setText(list.get(position).getDescription());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardIntent;
                switch(pos)
                {
                    case 0:
                        cardIntent = new Intent(context,AstronomyActivity.class);
                        context.startActivity(cardIntent);
                        break;
                    case 1:
                        cardIntent = new Intent(context,CodingActivity.class);
                        context.startActivity(cardIntent);
                        break;
                    case 2:
                        cardIntent = new Intent(context,RoboticsActivity.class);
                        context.startActivity(cardIntent);
                        break;
                    case 3:
                        cardIntent = new Intent(context,QuizzingActivity.class);
                        context.startActivity(cardIntent);
                        break;
                    case 4:
                        cardIntent = new Intent(context,LiteratureActivity.class);
                        context.startActivity(cardIntent);
                        break;
                    case 5:
                        cardIntent = new Intent(context,ManagementActivity.class);
                        context.startActivity(cardIntent);
                        break;
                    default:
                        break;
                }

            }
        });
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
