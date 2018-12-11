package LegiestReyniers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favorites")
public class Favorit {

    @Id
    private int id;

    private int userId;
    private String station_uri;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStation_uri() {
        return station_uri;
    }

    public void setStation_uri(String station_uri) {
        this.station_uri = station_uri;
    }
}
