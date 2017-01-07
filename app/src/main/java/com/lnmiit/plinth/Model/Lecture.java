package com.lnmiit.plinth.Model;

/**
 * Created by chanpreet on 5/1/17.
 */

public class Lecture {
    private String talkTitle;
    private String talkDescripton;
    private String imageLink;
    private String facebookLink;
    private String wikipediaLink;
    private String twitterLink;

    public Lecture(String talkTitle, String talkDescripton, String imageLink, String facebookLink, String wikipediaLink, String twitterLink)
    {
        this.talkTitle = talkTitle;
        this.talkDescripton = talkDescripton;
        this.imageLink = imageLink;
        this.facebookLink = facebookLink;
        this.wikipediaLink = wikipediaLink;
        this.twitterLink = twitterLink;
    }
    public String getTalkTitle() {
        return talkTitle;
    }

    public void setTalkTitle(String talkTitle) {
        this.talkTitle = talkTitle;
    }

    public String getTalkDescripton() {
        return talkDescripton;
    }

    public void setTalkDescripton(String talkDescripton) {
        this.talkDescripton = talkDescripton;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getFacebookLink() {
        return facebookLink;
    }

    public void setFacebookLink(String facebookLink) {
        this.facebookLink = facebookLink;
    }

    public String getWikipediaLink() {
        return wikipediaLink;
    }

    public void setWikipediaLink(String wikipediaLink) {
        this.wikipediaLink = wikipediaLink;
    }

    public String getTwitterLink() {
        return twitterLink;
    }

    public void setTwitterLink(String twitterLink) {
        this.twitterLink = twitterLink;
    }
}
