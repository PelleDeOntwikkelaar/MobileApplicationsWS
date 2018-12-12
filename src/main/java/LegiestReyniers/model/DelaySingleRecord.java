package LegiestReyniers.model;

import javax.persistence.*;

@Entity
@Table(name="delay_single_record")
public class DelaySingleRecord {

    @Id
    @Column(name="table_id")
    //@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
    //@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
    private int table_id;

    private int timestamp;
    private String station_uri;
    private int totaldelay;

    public DelaySingleRecord() {}

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public String getStation_uri() {
        return station_uri;
    }

    public void setStation_uri(String station_uri) {
        this.station_uri = station_uri;
    }

    public int getTotaldelay() {
        return totaldelay;
    }

    public void setTotaldelay(int totaldelay) {
        this.totaldelay = totaldelay;
    }
}
