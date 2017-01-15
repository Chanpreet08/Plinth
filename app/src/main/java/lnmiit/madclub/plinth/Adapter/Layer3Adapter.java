package lnmiit.madclub.plinth.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import lnmiit.madclub.plinth.Activity.CompleteRegisterActivity;
import lnmiit.madclub.plinth.Activity.SharedPreferences;
import lnmiit.madclub.plinth.Model.Register;
import lnmiit.madclub.plinth.Model.User;
import lnmiit.madclub.plinth.Model.pager;
import lnmiit.madclub.plinth.R;
import lnmiit.madclub.plinth.rest.ApiClient;
import lnmiit.madclub.plinth.rest.ApiInterface;

import java.util.ArrayList;

/**
 * Created by chanpreet on 1/1/17.
 */

public class Layer3Adapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<pager> list = new ArrayList<>();
    private Button register;
    private Button payment;
    private String event;
    Register registerEvent;
    private ArrayList<User> userDetail = new ArrayList<>();

    public Layer3Adapter(Context context, ArrayList<pager> list,String event)
    {
        this.context = context;
        this.list = list;
        this.event = event;
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
    public Object instantiateItem(final ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.row_layout_pager,container,false);
        TextView heading = (TextView) view.findViewById(R.id.heading);
        TextView description = (TextView) view.findViewById(R.id.description);
        register = (Button) view.findViewById(R.id.pager_button);
        payment = (Button) view.findViewById(R.id.payment);
        if(position==list.size()-1)
        {
            register.setVisibility(View.VISIBLE);
            payment.setVisibility(View.VISIBLE);
        }
        else {
            register.setVisibility(View.GONE);
            payment.setVisibility(View.GONE);
        }
        final String temp = event;
        heading.setText(list.get(position).getHeading());
        description.setText(list.get(position).getDes());
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = SharedPreferences.getSharedInfo(context);
                String temp1 = user.getEmailId();
                if(temp1==null||temp1.equals(""))
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                    builder.setView(inflater.inflate(R.layout.dialog, null))

                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    Dialog f = (Dialog)dialog;
                                    EditText text = (EditText) f.findViewById(R.id.dialog_email);
                                    String mail = text.getText().toString();
                                    if(temp.equals("photography"))
                                    {
                                        String url = "https://plinth.in/workshops/photography?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("fix the bug"))
                                    {
                                        String url = "https://plinth.in/competitions/coding/fix_the_bug?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("armageddon"))
                                    {
                                        String url = "https://plinth.in/competitions/astronomy/armAgeddon?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("astrohunt"))
                                    {
                                        String url = "https://plinth.in/competitions/astronomy/astro_hunt?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("augmented"))
                                    {
                                        String url = "https://plinth.in/workshops/touch-augmented-realities?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("distraction"))
                                    {
                                        String url = "https://plinth.in/competitions/coding/iupc_distraction?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);

                                    }
                                    if(temp.equals("iupc"))
                                    {
                                        String url = "https://plinth.in/competitions/coding/iupc?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("lfr"))
                                    {
                                        String url = "https://plinth.in/competitions/robotics/lfr?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("quadcopter"))
                                    {
                                        String url = "https://plinth.in/competitions/robotics/quadcopter?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("quest"))
                                    {
                                        String url = "https://plinth.in/competitions/quizzing/quest?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("roborace"))
                                    {
                                        String url = "https://plinth.in/competitions/robotics/roborace?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }

                                    if(temp.equals("robosoccer"))
                                    {
                                        String url = "https://plinth.in/competitions/robotics/robosoccer?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("robowar"))
                                    {
                                        String url = "https://plinth.in/competitions/robotics/robowar?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("rostrum"))
                                    {
                                        String url = "https://plinth.in/competitions/literature/rostrum?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("sif"))
                                    {
                                        String url = "https://plinth.in/competitions/management/sif?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("startrek"))
                                    {
                                        String url = "https://plinth.in/competitions/astronomy/star_trek?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("transporter"))
                                    {
                                        String url = "https://plinth.in/competitions/robotics/transporter?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("vehicle"))
                                    {
                                        String url = "https://plinth.in/workshops/vehicle-dynamics?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("webomaster"))
                                    {
                                        String url = "https://plinth.in/workshops/web-o-master?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("wrangle"))
                                    {
                                        String url = "https://plinth.in/competitions/literature/wrangle?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                    if(temp.equals("printer"))
                                    {
                                        String url = "https://plinth.in/workshops/3d-printer-workshop?type=payment&user="+mail;
                                        Intent i = new Intent(Intent.ACTION_VIEW);
                                        i.setData(Uri.parse(url));
                                        context.startActivity(i);
                                    }
                                }
                            }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }});

                    AlertDialog dialog = builder.create();
                    dialog.show();
                    return;
                }


                if(temp.equals("photography"))
                {
                    String url = "https://plinth.in/workshops/photography?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("fix the bug"))
                {
                    String url = "https://plinth.in/competitions/coding/fix_the_bug?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("armageddon"))
                {
                    String url = "https://plinth.in/competitions/astronomy/armAgeddon?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("astrohunt"))
                {
                    String url = "https://plinth.in/competitions/astronomy/astro_hunt?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("augmented"))
                {
                    String url = "https://plinth.in/workshops/touch-augmented-realities?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("distraction"))
                {
                    String url = "https://plinth.in/competitions/coding/iupc_distraction?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);

                }
                if(temp.equals("iupc"))
                {
                    String url = "https://plinth.in/competitions/coding/iupc?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("lfr"))
                {
                    String url = "https://plinth.in/competitions/robotics/lfr?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("quadcopter"))
                {
                    String url = "https://plinth.in/competitions/robotics/quadcopter?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("quest"))
                {
                    String url = "https://plinth.in/competitions/quizzing/quest?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("roborace"))
                {
                    String url = "https://plinth.in/competitions/robotics/roborace?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }

                if(temp.equals("robosoccer"))
                {
                    String url = "https://plinth.in/competitions/robotics/robosoccer?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("robowar"))
                {
                    String url = "https://plinth.in/competitions/robotics/robowar?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("rostrum"))
                {
                    String url = "https://plinth.in/competitions/literature/rostrum?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("sif"))
                {
                    String url = "https://plinth.in/competitions/management/sif?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("startrek"))
                {
                    String url = "https://plinth.in/competitions/astronomy/star_trek?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("transporter"))
                {
                    String url = "https://plinth.in/competitions/robotics/transporter?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("vehicle"))
                {
                    String url = "https://plinth.in/workshops/vehicle-dynamics?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("webomaster"))
                {
                    String url = "https://plinth.in/workshops/web-o-master?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("wrangle"))
                {
                    String url = "https://plinth.in/competitions/literature/wrangle?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }
                if(temp.equals("printer"))
                {
                    String url = "https://plinth.in/workshops/3d-printer-workshop?type=payment&user="+user.getEmailId();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    context.startActivity(i);
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerEvent = new Register();
                ApiInterface apiService = ApiClient.getRetrofitClient().create(ApiInterface.class);
                User user = SharedPreferences.getSharedInfo(context);
                userDetail.add(user);
                if(temp.equals("photography"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","audi");
                    registerIntent.putExtra("clubname","workshop");
                    registerIntent.putExtra("upperlimit",1);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("fix the bug"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","fix-the-bug");
                    registerIntent.putExtra("clubname","coding");
                    registerIntent.putExtra("upperlimit",2);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("armageddon"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","armageddon");
                    registerIntent.putExtra("clubname","astronomy");
                    registerIntent.putExtra("upperlimit",5);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("astrohunt"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","astro-hunt");
                    registerIntent.putExtra("clubname","astronomy");
                    registerIntent.putExtra("upperlimit",5);
                    registerIntent.putExtra("lowerlimit",3);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("augmented"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","touch-augmented-realities");
                    registerIntent.putExtra("clubname","workshop");
                    registerIntent.putExtra("upperlimit",1);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("distraction"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","iupc-distraction");
                    registerIntent.putExtra("clubname","coding");
                    registerIntent.putExtra("upperlimit",2);
                    registerIntent.putExtra("lowerlimit",2);
                    context.startActivity(registerIntent);

                }
                if(temp.equals("iupc"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","iupc");
                    registerIntent.putExtra("clubname","coding");
                    registerIntent.putExtra("upperlimit",2);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("lfr"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","LFR");
                    registerIntent.putExtra("clubname","robotics");
                    registerIntent.putExtra("upperlimit",4);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("quadcopter"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","quadcopter");
                    registerIntent.putExtra("clubname","robotics");
                    registerIntent.putExtra("upperlimit",6);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("quest"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","quest");
                    registerIntent.putExtra("clubname","quizzing");
                    registerIntent.putExtra("upperlimit",2);
                    registerIntent.putExtra("lowerlimit",2);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("roborace"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","roborace");
                    registerIntent.putExtra("clubname","robotics");
                    registerIntent.putExtra("upperlimit",5);
                    registerIntent.putExtra("lowerlimit",3);
                    context.startActivity(registerIntent);
                }

                if(temp.equals("robosoccer"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","robosoccer");
                    registerIntent.putExtra("clubname","robotics");
                    registerIntent.putExtra("upperlimit",6);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("robowar"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","robowar");
                    registerIntent.putExtra("clubname","robotics");
                    registerIntent.putExtra("upperlimit",6);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("rostrum"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","rostrum");
                    registerIntent.putExtra("clubname","literature");
                    registerIntent.putExtra("upperlimit",2);
                    registerIntent.putExtra("lowerlimit",2);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("sif"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","sif");
                    registerIntent.putExtra("clubname","management");
                    registerIntent.putExtra("upperlimit",1);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("startrek"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","star-trek");
                    registerIntent.putExtra("clubname","astronomy");
                    registerIntent.putExtra("upperlimit",3);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("transporter"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","transporter");
                    registerIntent.putExtra("clubname","robotics");
                    registerIntent.putExtra("upperlimit",4);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("vehicle"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","vehicle-dynamics");
                    registerIntent.putExtra("clubname","workshop");
                    registerIntent.putExtra("upperlimit",1);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("webomaster"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","web-o-master");
                    registerIntent.putExtra("clubname","workshop");
                    registerIntent.putExtra("upperlimit",1);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("wrangle"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","wrangle");
                    registerIntent.putExtra("clubname","literature");
                    registerIntent.putExtra("upperlimit",1);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }
                if(temp.equals("printer"))
                {
                    Intent registerIntent = new Intent(context, CompleteRegisterActivity.class);
                    registerIntent.putExtra("event","3dPrinting");
                    registerIntent.putExtra("clubname","workshop");
                    registerIntent.putExtra("upperlimit",1);
                    registerIntent.putExtra("lowerlimit",1);
                    context.startActivity(registerIntent);
                }


            }
        });
        container.addView(view);
        return view;
     }

    private void dialog() {

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
