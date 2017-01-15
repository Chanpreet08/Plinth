package lnmiit.madclub.plinth.rest;

import lnmiit.madclub.plinth.Model.Contact;
import lnmiit.madclub.plinth.Model.Register;
import lnmiit.madclub.plinth.Model.User;
import lnmiit.madclub.plinth.Model.Validate;
import lnmiit.madclub.plinth.response.ContactUsResponse;
import lnmiit.madclub.plinth.response.EventRegisterResponse;
import lnmiit.madclub.plinth.response.ValidateResponse;
import lnmiit.madclub.plinth.response.registerResponse;

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
    @POST("user/user_validate_mobile/facebook/")
    Call<ValidateResponse> validateFacebook(@Body Validate validate);
    @POST("user/user_validate_mobile/google/")
    Call<ValidateResponse> validateGoogle(@Body Validate validate);
}
