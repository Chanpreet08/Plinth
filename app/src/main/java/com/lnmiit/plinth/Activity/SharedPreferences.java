package com.lnmiit.plinth.Activity;

import android.content.Context;

import com.lnmiit.plinth.Model.User;

/**
 * Created by chanpreet on 30/12/16.
 */

public class SharedPreferences {

    public static final String MYPREFERENCES = "UserInfo";
    public static android.content.SharedPreferences sharedPreferences;

    public static boolean putSharedPrefeneces(Context context, User user)
    {
        sharedPreferences = context.getSharedPreferences(MYPREFERENCES,Context.MODE_PRIVATE);
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username",user.getUsername());
        editor.putString("emailid",user.getEmailId());
        editor.putString("phone",user.getPhone());
        editor.commit();
        return true;
    }

    public static User getSharedInfo( Context context){
        User user = new User();
        sharedPreferences = context.getSharedPreferences(MYPREFERENCES,Context.MODE_PRIVATE);
        user.setUsername(sharedPreferences.getString("username",null));
        user.setEmailId(sharedPreferences.getString("emailid",null));
        user.setPhone(sharedPreferences.getString("phone",null));
        return user;
    }
}
