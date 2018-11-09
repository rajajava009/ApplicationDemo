package raja;

import javax.persistence.*;

@Entity
@Table
public class Station {

    @Id
    @Column(name = "stationId")
    private String stationId;

    @Column(name = "name")
    private String name;

    @Column(name = "hdEnabled")
    private boolean hdEnabled;

    @Column(name = "callSign")
    private String callSign;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHdEnabled() {
        return hdEnabled;
    }

    public void setHdEnabled(boolean hdEnabled) {
        this.hdEnabled = hdEnabled;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }
}