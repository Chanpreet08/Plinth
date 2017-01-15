package lnmiit.madclub.plinth.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by chanpreet on 9/1/17.
 */

public class Register {

    @SerializedName("eventName")
    private String eventName;
    @SerializedName("clubName")
    private String clubName;
    @SerializedName("userDetails")
    private ArrayList<User> userDetails;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public ArrayList<User> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(ArrayList<User> userDetails) {
        this.userDetails = userDetails;
    }
}
