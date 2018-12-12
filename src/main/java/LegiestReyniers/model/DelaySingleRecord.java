package LegiestReyniers.model;

import javax.persistence.*;

@Entity
@Table(name="delay_single_record")
public class DelaySingleRecord {

    @Id
    @Column(name="id")
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    //@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private int id;

    private int timestamp;
    private String stationuri;
    private int totaldelay;
    private int nontime;
    private int nover;

    public DelaySingleRecord() {}

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getTable_id() {
        return id;
    }

    public void setTable_id(int table_id) {
        this.id = table_id;
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
}
