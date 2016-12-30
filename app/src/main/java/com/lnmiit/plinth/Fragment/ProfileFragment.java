package com.lnmiit.plinth.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lnmiit.plinth.Activity.LoginActivity;
import com.lnmiit.plinth.Activity.SharedPreferences;
import com.lnmiit.plinth.Model.User;
import com.lnmiit.plinth.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private Button logout;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_profile, container, false);
        logout= (Button) v.findViewById(R.id.profile_logout);
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
                getActivity().finish();
            }
        });
        return v;
    }

}
