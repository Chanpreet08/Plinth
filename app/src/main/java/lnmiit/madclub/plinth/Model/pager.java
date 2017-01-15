package lnmiit.madclub.plinth.Model;

/**
 * Created by chanpreet on 1/1/17.
 */

public class pager {

    private String heading;
    private String des;

    public pager(String heading, String des)
    {
        this.heading = heading;
        this.des = des;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
