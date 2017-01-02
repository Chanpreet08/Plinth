package com.lnmiit.plinth.Fragment;


import android.content.Intent;
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


    private ImageView logout;
    private TextView email;
    private TextView username;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        logout= (ImageView) v.findViewById(R.id.profile_logout);
        email =(TextView) v.findViewById(R.id.profile_email);
        username = (TextView) v.findViewById(R.id.profile_username);
        User user ;
        user =SharedPreferences.getSharedInfo(getActivity().getApplicationContext());
        email.setText(user.getEmailId());
        username.setText(user.getUsername());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User u = new User();
                u.setEmailId("");
                u.setUsername("");
                u.setPhone("");
                SharedPreferences.putSharedPrefeneces(getActivity().getApplicationContext(), u);
                Intent i = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });
        return v;
    }

}
