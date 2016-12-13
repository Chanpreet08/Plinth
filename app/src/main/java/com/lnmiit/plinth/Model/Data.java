package com.lnmiit.plinth.Model;

/**
 * Created by chanpreet on 13/12/16.
 */

public class Data {
    private int id ;
    private String title;
    private String description;

    public Data()
    {
        id =0;
        title ="";
        description = "";
    }

    public Data( String title, String description)
    {
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitles() {
        return title;
    }

    public void setTitles(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
