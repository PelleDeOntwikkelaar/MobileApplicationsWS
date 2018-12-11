package LegiestReyniers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delay_day_record")
public class DelayDayRecord {

    @Id
    private int id;

    private String station_uri;
    private int timestamp;
    private int total_delay;
    private int average_delay;
    private int min_delay;
    private int max_delay;
    private int n_over30min;
    private int n_ontime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStation_uri() {
        return station_uri;
    }

    public void setStation_uri(String station_uri) {
        this.station_uri = station_uri;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getTotal_delay() {
        return total_delay;
    }

    public void setTotal_delay(int total_delay) {
        this.total_delay = total_delay;
    }

    public int getAverage_delay() {
        return average_delay;
    }

    public void setAverage_delay(int average_delay) {
        this.average_delay = average_delay;
    }

    public int getMin_delay() {
        return min_delay;
    }

    public void setMin_delay(int min_delay) {
        this.min_delay = min_delay;
    }

    public int getMax_delay() {
        return max_delay;
    }

    public void setMax_delay(int max_delay) {
        this.max_delay = max_delay;
    }

    public int getN_over30min() {
        return n_over30min;
    }

    public void setN_over30min(int n_over30min) {
        this.n_over30min = n_over30min;
    }

    public int getN_ontime() {
        return n_ontime;
    }

    public void setN_ontime(int n_ontime) {
        this.n_ontime = n_ontime;
    }
}
