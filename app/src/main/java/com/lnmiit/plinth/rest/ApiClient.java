package com.lnmiit.plinth.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chanpreet on 4/1/17.
 */

public class ApiClient {

    public static final String  BASE_URL="http://192.168.0.3:3000/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofitClient()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
