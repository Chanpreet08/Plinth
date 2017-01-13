package com.lnmiit.plinth.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 12/1/17.
 */

public class Validate {
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("email")
    private String validateEmail;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getValidateEmail() {
        return validateEmail;
    }

    public void setValidateEmail(String validateEmail) {
        this.validateEmail = validateEmail;
    }
}
