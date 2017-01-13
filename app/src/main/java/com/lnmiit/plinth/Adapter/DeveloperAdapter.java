package com.lnmiit.plinth.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.lnmiit.plinth.Model.Contact;
import com.lnmiit.plinth.R;

import java.util.ArrayList;

/**
 * Created by chanpreet on 12/1/17.
 */

public class DeveloperAdapter extends RecyclerView.Adapter<DeveloperAdapter.ViewHolder> {

    private Context context;
    private String titles[]={"Chanpreet Singh","Deepa Daga"};
    private String description[]={"Android App Developer and Freelancer","Android App Developer and Freelancer"};
    private String facebooks[]={"http://bit.ly/2jn6Mi9","http://bit.ly/2jn9pRh"};
    private String githubs[]={"https://github.com/Chanpreet08","https://github.com/deepadaga"};
    private String mail[]={"chanpreet.chhabra@gmail.com","deepadaga1995@gmail.com"};
    private String phones[]={"+91-9602976558","+91-9649341430"};
    private String images[]={"http://bit.ly/2jbbFhe","http://bit.ly/2jHTP65"};
    public DeveloperAdapter( Context context)
    {
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_layout_developer,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.title.setText(titles[position]);
        holder.des.setText(description[position]);
        holder.facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(facebooks[position]);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
        holder.github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(githubs[position]);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                context.startActivity(intent);
            }
        });
        holder.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mailIntent = new Intent(Intent.ACTION_SENDTO);
                mailIntent.setData(Uri.parse("mailto:"));
                mailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{ mail[position]});
                context.startActivity(Intent.createChooser(mailIntent, "Send Mail via"));
            }
        });
        holder.phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL);
                phoneIntent.setData(Uri.parse("tel:" + phones[position]));
                context.startActivity(phoneIntent);
            }
        });
        Glide.with(context).load(images[position]).asBitmap().centerCrop().into(new BitmapImageViewTarget(holder.image){
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(context.getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                holder.image.setImageDrawable(circularBitmapDrawable);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView des;
        private Button facebook;
        private Button github;
        private Button email;
        private Button phone;
        private ImageView image;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.developer_title);
            des = (TextView) itemView.findViewById(R.id.developer_description);
            facebook = (Button) itemView.findViewById(R.id.developer_facebook_link);
            github = (Button) itemView.findViewById(R.id.developer_github);
            email = (Button) itemView.findViewById(R.id.developer_mail);
            phone = (Button) itemView.findViewById(R.id.developer_phone);
            image = (ImageView) itemView.findViewById(R.id.developer_image);
        }
    }
}
