package lnmiit.madclub.plinth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import lnmiit.madclub.plinth.Activity.ArmageddonActivity;
import lnmiit.madclub.plinth.Activity.AstroHuntActivity;
import lnmiit.madclub.plinth.Activity.DistarctionIupcActivity;
import lnmiit.madclub.plinth.Activity.FixthebugActivity;
import lnmiit.madclub.plinth.Activity.IupcActivity;
import lnmiit.madclub.plinth.Activity.LfrActivity;
import lnmiit.madclub.plinth.Activity.QuadcopterActivity;
import lnmiit.madclub.plinth.Activity.QuestActivity;
import lnmiit.madclub.plinth.Activity.RoboSoccerActivity;
import lnmiit.madclub.plinth.Activity.RoboraceActivity;
import lnmiit.madclub.plinth.Activity.RobowarActivity;
import lnmiit.madclub.plinth.Activity.RostrumActivity;
import lnmiit.madclub.plinth.Activity.SifActivity;
import lnmiit.madclub.plinth.Activity.StarTrekActivity;
import lnmiit.madclub.plinth.Activity.TransporterActivity;
import lnmiit.madclub.plinth.Activity.WrangleActivity;
import lnmiit.madclub.plinth.Model.Data;
import lnmiit.madclub.plinth.R;

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
        final String temp = list.get(position).getTitles();
        holder.title.setText(list.get(position).getTitles());
        holder.description.setText(list.get(position).getDescription());
        holder.image.setImageResource(list.get(position).getImages());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cardIntent;
                if(temp.equals("Armageddon"))
                {
                    cardIntent = new Intent(context, ArmageddonActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Astro Hunt"))
                {
                    cardIntent = new Intent(context, AstroHuntActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Star Trek"))
                {
                    cardIntent = new Intent(context, StarTrekActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Fix The Bug"))
                {
                    cardIntent = new Intent(context, FixthebugActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("IUPC"))
                {
                    cardIntent = new Intent(context,IupcActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("IUPC Distraction"))
                {
                    cardIntent = new Intent(context, DistarctionIupcActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("LFR"))
                {
                    cardIntent = new Intent(context, LfrActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Quadcopter"))
                {
                    cardIntent = new Intent(context, QuadcopterActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Transporter"))
                {
                    cardIntent = new Intent(context, TransporterActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Roborace"))
                {
                    cardIntent = new Intent(context, RoboraceActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Robowar"))
                {
                    cardIntent = new Intent(context, RobowarActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Robosoccer"))
                {
                    cardIntent = new Intent(context, RoboSoccerActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("The Quest"))
                {
                    cardIntent = new Intent(context, QuestActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Wrangle"))
                {
                    cardIntent = new Intent(context, WrangleActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("Rostrum"))
                {
                    cardIntent = new Intent(context, RostrumActivity.class);
                    context.startActivity(cardIntent);
                }
                if(temp.equals("SIF"))
                {
                    cardIntent = new Intent(context, SifActivity.class);
                    context.startActivity(cardIntent);
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
