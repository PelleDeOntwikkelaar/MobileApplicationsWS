package LegiestReyniers.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="delayglobalrecord")
public class DelayGlobalRecord {

    @Id
    private int id;

    private String stationuri;
    private int total_delay;
    private int avg_delay;
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

    public String getStationuri() {
        return stationuri;
    }

    public void setStationuri(String stationuri) {
        this.stationuri = stationuri;
    }

    public int getTotal_delay() {
        return total_delay;
    }

    public void setTotal_delay(int total_delay) {
        this.total_delay = total_delay;
    }

    public int getAvg_delay() {
        return avg_delay;
    }

    public void setAvg_delay(int avg_delay) {
        this.avg_delay = avg_delay;
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

    public void addTotal(int i){
        total_delay += i;
    }

    public void addAvg(int i){
        avg_delay = (avg_delay +i)/2;
    }

    public void addMin(int i){
        if(i < min_delay)
            min_delay=i;
    }

    public void addMax(int i){
        if(i > max_delay)
            max_delay = i;

    }

    public void addOver(int i){
        n_over30min += i;
    }
    public void addOn(int i){
        n_ontime += i;
    }



}
