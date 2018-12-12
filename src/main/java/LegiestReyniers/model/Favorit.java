package LegiestReyniers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorites")
public class Favorit {

    @Id
    private int id;

    private int userid;
    private String station_uri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getStation_uri() {
        return station_uri;
    }

    public void setStation_uri(String station_uri) {
        this.station_uri = station_uri;
    }
}
