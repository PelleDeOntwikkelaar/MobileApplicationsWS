package LegiestReyniers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorites")
public class Favorit {

    @Id
    private int id;

    private int user_id;
    private String station_uri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getStation_uri() {
        return station_uri;
    }

    public void setStation_uri(String station_uri) {
        this.station_uri = station_uri;
    }
}
