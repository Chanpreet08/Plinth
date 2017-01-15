package lnmiit.madclub.plinth.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 12/1/17.
 */

public class ValidateResponse {
    @SerializedName("msg")
    private String validateMsg="";
    @SerializedName("gender")
    private String validateGender="";
    @SerializedName("name")
    private String validateUsername="";
    @SerializedName("email")
    private String validateEmailId="";
    @SerializedName("phoneNumber")
    private String validatePhone="";
    @SerializedName("college")
    private String validateCollege="";
    @SerializedName("year")
    private int validateYear=0;
    @SerializedName("city")
    private String validateCity="";
    @SerializedName("accommodation")
    private String validateAccommodation="";

    public String getValidateMsg() {
        return validateMsg;
    }

    public void setValidateMsg(String validateMsg) {
        this.validateMsg = validateMsg;
    }

    public String getValidateGender() {
        return validateGender;
    }

    public void setValidateGender(String validateGender) {
        this.validateGender = validateGender;
    }

    public String getValidateUsername() {
        return validateUsername;
    }

    public void setValidateUsername(String validateUsername) {
        this.validateUsername = validateUsername;
    }

    public String getValidateEmailId() {
        return validateEmailId;
    }

    public void setValidateEmailId(String validateEmailId) {
        this.validateEmailId = validateEmailId;
    }

    public String getValidatePhone() {
        return validatePhone;
    }

    public void setValidatePhone(String validatePhone) {
        this.validatePhone = validatePhone;
    }

    public String getValidateCollege() {
        return validateCollege;
    }

    public void setValidateCollege(String validateCollege) {
        this.validateCollege = validateCollege;
    }

    public int getValidateYear() {
        return validateYear;
    }

    public void setValidateYear(int validateYear) {
        this.validateYear = validateYear;
    }

    public String getValidateCity() {
        return validateCity;
    }

    public void setValidateCity(String validateCity) {
        this.validateCity = validateCity;
    }

    public String getValidateAccommodation() {
        return validateAccommodation;
    }

    public void setValidateAccommodation(String validateAccommodation) {
        this.validateAccommodation = validateAccommodation;
    }
}
