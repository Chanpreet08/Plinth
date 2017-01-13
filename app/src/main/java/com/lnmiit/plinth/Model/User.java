package com.lnmiit.plinth.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by chanpreet on 30/12/16.
 */

public class User {

    @SerializedName("name")
    private String username="";
    @SerializedName("email")
    private String emailId="";
    @SerializedName("phoneNumber")
    private String phone;
    @SerializedName("college")
    private String college;
    @SerializedName("year")
    private int year;
    @SerializedName("city")
    private String city;
    @SerializedName("accommodation")
    private String accommodation;
    @SerializedName("valid")
    private String valid;
    @SerializedName("gender")
    private String gender;
    @SerializedName("events")
    private String events;
    @SerializedName("paidEvents")
    private String paidEvents;
    @SerializedName("access_token")
    private String token;
    @SerializedName("id")
    private String loginId;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getPaidEvents() {
        return paidEvents;
    }

    public void setPaidEvents(String paidEvents) {
        this.paidEvents = paidEvents;
    }


    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
