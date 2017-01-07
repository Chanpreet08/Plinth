package com.lnmiit.plinth.rest;

import com.lnmiit.plinth.Model.User;
import com.lnmiit.plinth.response.registerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by chanpreet on 4/1/17.
 */

public interface ApiInterface {

    @POST("user/user_register_complete_mobile/")
    Call<registerResponse> sendCredentials(@Body User user);
}
