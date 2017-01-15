package lnmiit.madclub.plinth.Model;

/**
 * Created by chanpreet on 13/12/16.
 */

public class Data {
    private int id ;
    private String title;
    private String description;
    private int image;

    public int getImages() {
        return image;
    }

    public void setImages(int image) {
        this.image = image;
    }

    public Data()
    {
        id =0;
        title ="";
        description = "";
    }

    public Data( String title, String description, int image)
    {
        this.title = title;
        this.description = description;
        this.image = image;
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
