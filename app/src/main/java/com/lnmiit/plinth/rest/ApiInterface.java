package com.lnmiit.plinth.rest;

import android.content.Context;

import com.lnmiit.plinth.Model.Contact;
import com.lnmiit.plinth.Model.Register;
import com.lnmiit.plinth.Model.User;
import com.lnmiit.plinth.response.ContactUsResponse;
import com.lnmiit.plinth.response.EventRegisterResponse;
import com.lnmiit.plinth.response.registerResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by chanpreet on 4/1/17.
 */

public interface ApiInterface {

    @POST("user/user_register_complete_mobile/facebook/")
    Call<registerResponse> sendCredentialsFacebook(@Body User user);
    @POST("events/contact/")
    Call<ContactUsResponse> sendContactUs(@Body Contact contact);
    @POST("/events/workshop/register/")
    Call<EventRegisterResponse> RegisterWorkshop(@Body Register register);
    @POST("/events/register/")
    Call<EventRegisterResponse> RegisterEvent(@Body Register register);
    @POST("user/user_register_complete_mobile/google/")
    Call<registerResponse> sendCredentialsGoogle(@Body User user);
}
