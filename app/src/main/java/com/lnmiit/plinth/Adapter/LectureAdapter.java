package com.lnmiit.plinth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lnmiit.plinth.Model.Lecture;
import com.lnmiit.plinth.R;

import java.util.ArrayList;

/**
 * Created by chanpreet on 4/1/17.
 */

public class LectureAdapter extends RecyclerView.Adapter<LectureAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Lecture> list = new ArrayList<>();

    public LectureAdapter( Context context,ArrayList<Lecture> list)
    {
        this.context = context;
        this.list = list;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout_speakers,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.title.setText(list.get(position).getTalkTitle());
        holder.description.setText(list.get(position).getTalkDescripton());
        Glide.with(context).load(list.get(position).getImageLink()).asBitmap().centerCrop().into( new BitmapImageViewTarget(holder.image){
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.image.setImageDrawable(circularBitmapDrawable);
            }
        });
        if(list.get(position).getFacebookLink().equals(""))
        {
            holder.facebook.setVisibility(View.INVISIBLE);
        }
        if(list.get(position).getWikipediaLink().equals(""))
        {
            holder.wikipedia.setVisibility(View.INVISIBLE);
        }
        if(list.get(position).getTwitterLink().equals(""))
        {
            holder.twitter.setVisibility(View.INVISIBLE);
        }
        holder.facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(list.get(position).getFacebookLink());
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
        holder.wikipedia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(list.get(position).getWikipediaLink());
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
        holder.twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(list.get(position).getTwitterLink());
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
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
        private Button facebook;
        private Button wikipedia;
        private Button twitter;

        public ViewHolder(View itemView) {
            super(itemView);
            image= (ImageView) itemView.findViewById(R.id.lecture_image);
            title = (TextView) itemView.findViewById(R.id.lecture_title);
            description = (TextView) itemView.findViewById(R.id.lecture_description);
            facebook = (Button) itemView.findViewById(R.id.facebook_link);
            wikipedia = (Button) itemView.findViewById(R.id.wikipedia_link);
            twitter = (Button) itemView.findViewById(R.id.twitter_link);
        }
    }
}
