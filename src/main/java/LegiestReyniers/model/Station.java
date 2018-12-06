package LegiestReyniers.model;

import javax.persistence.*;

@Entity
@Table(name="stations")
public class Station {

    @Id
    private String uri;

    private String name;
    private float langitude;
    private float longitude;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLangitude() {
        return langitude;
    }

    public void setLangitude(float langitude) {
        this.langitude = langitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
