package lnmiit.madclub.plinth.Activity;

import android.content.Context;

import lnmiit.madclub.plinth.Model.User;

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
        editor.putString("gender",user.getGender());
        editor.putString("college",user.getCollege());
        editor.putString("city",user.getCity());
        editor.putString("accommodation",user.getAccommodation());
        editor.putInt("year",user.getYear());
        editor.commit();
        return true;
    }

    public static User getSharedInfo( Context context){
        User user = new User();
        sharedPreferences = context.getSharedPreferences(MYPREFERENCES,Context.MODE_PRIVATE);
        user.setUsername(sharedPreferences.getString("username",null));
        user.setEmailId(sharedPreferences.getString("emailid",null));
        user.setPhone(sharedPreferences.getString("phone",null));
        user.setGender(sharedPreferences.getString("gender",null));
        user.setCollege(sharedPreferences.getString("college",null));
        user.setCity(sharedPreferences.getString("city",null));
        user.setAccommodation(sharedPreferences.getString("accommodation",null));
        user.setYear(sharedPreferences.getInt("year",0));
        return user;
    }
}
