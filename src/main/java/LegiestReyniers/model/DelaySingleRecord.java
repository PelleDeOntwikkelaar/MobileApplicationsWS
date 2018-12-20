package LegiestReyniers.model;

import javax.persistence.*;

@Entity
@Table(name="delay_single_record")
public class DelaySingleRecord {

    @Id
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    //@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private int id;

    private long timestamp;
    private String stationuri;
    private int totaldelay;
    private int nontime;
    private int nover;
    private int ndelay;

    public DelaySingleRecord() {}

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

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

    public int getTotaldelay() {
        return totaldelay;
    }

    public void setTotaldelay(int totaldelay) {
        this.totaldelay = totaldelay;
    }

    public int getNontime() {
        return nontime;
    }

    public void setNontime(int nontime) {
        this.nontime = nontime;
    }

    public int getNover() {
        return nover;
    }

    public void setNover(int nover) {
        this.nover = nover;
    }

    public int getNdelay() {
        return ndelay;
    }

    public void setNdelay(int ndelay) {
        this.ndelay = ndelay;
    }
}
