package com.lnmiit.plinth.Fragment;


import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.lnmiit.plinth.Activity.LoginActivity;
import com.lnmiit.plinth.Activity.SharedPreferences;
import com.lnmiit.plinth.Model.User;
import com.lnmiit.plinth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private Button logout;
    private TextView email;
    private TextView name;
    private TextView phone;
    private TextView city;
    private TextView college;
    private String gender="";
    private String temp="";
    private ImageView gen;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        logout= (Button) v.findViewById(R.id.profile_logout);
        email =(TextView) v.findViewById(R.id.profile_email);
        name = (TextView) v.findViewById(R.id.profile_name);
        phone = (TextView) v.findViewById(R.id.profile_phone);
        city = (TextView) v.findViewById(R.id.profile_city);
        college = (TextView) v.findViewById(R.id.profile_college);
        gen = (ImageView) v.findViewById(R.id.profile_gender);
        User user =new User();
        user =SharedPreferences.getSharedInfo(getActivity().getApplicationContext());
        temp = user.getUsername();
        if(temp==null || temp.equals(""))
        {
            name.setText("Not A Registered User");
            name.setTextColor(Color.RED);
            gen.setImageResource(R.drawable.male);
            logout.setText("Register");
        }
        else {
            email.setText(user.getEmailId());
            name.setText(user.getUsername());
            phone.setText(user.getPhone());
            city.setText(user.getCity());
            college.setText(user.getCollege());
            gender = user.getGender();
            if(gender.equals("female"))
            {
                gen.setImageResource(R.drawable.ic_female);
            }
            else {
                gen.setImageResource(R.drawable.male);
            }
        }


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u = new User();
                u.setEmailId("");
                u.setUsername("");
                u.setPhone("");
                u.setCity("");
                u.setCollege("");
                SharedPreferences.putSharedPrefeneces(getActivity().getApplicationContext(), u);
                Intent i = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        return v;
    }

}
