package com.lnmiit.plinth.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 4/1/17.
 */

public class registerResponse {
    @SerializedName("msg")
    String msg;

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }
}
