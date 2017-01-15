package lnmiit.madclub.plinth.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 9/1/17.
 */

public class ContactUsResponse {

    @SerializedName("response")
    private String contactResponse;

    public String getContactResponse() {
        return contactResponse;
    }

    public void setContactResponse(String contactResponse) {
        this.contactResponse = contactResponse;
    }
}
