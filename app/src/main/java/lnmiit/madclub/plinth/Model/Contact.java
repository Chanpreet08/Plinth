package lnmiit.madclub.plinth.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 8/1/17.
 */

public class Contact {

    @SerializedName("name")
    private String contactName;
    @SerializedName("email")
    private String contactEmail;
    @SerializedName("query")
    private String contactQuery;

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactQuery() {
        return contactQuery;
    }

    public void setContactQuery(String contactQuery) {
        this.contactQuery = contactQuery;
    }
}
