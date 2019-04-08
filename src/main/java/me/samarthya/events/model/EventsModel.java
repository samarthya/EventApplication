package me.samarthya.events.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "events_model")
public class EventsModel {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "eventid")
    private int iEventId;

    @Column(name = "name")
    private String sName;

    @Column(name = "date")
    private Date dDate;

    @Column(name = "time")
    private String sTime;

    @Column(name = "price")
    private double dPrice;

    @Column(name = "imageUrl")
    private String urlImage;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fklocationid")
    private LocationModel locationModel;


    @Column(name = "onlineUrl")
    private String urlOnlineLocation;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fksid")
    private Set<SessionModel> oSessions = new HashSet<>();


    /**
     * Event Model overloaded constructor.
     *
     * @param sName
     * @param dDate
     * @param sTime
     * @param dPrice
     * @param urlImage
     * @param urlOnlineLocation
     * @param locationModel
     * @param sessionModel
     */
    public EventsModel(String sName, Date dDate,
                       String sTime, double dPrice,
                       String urlImage,
                       String urlOnlineLocation,
                       LocationModel locationModel, Set<SessionModel> sessionModel) {
        this.sName = sName;
        this.dDate = dDate;
        this.sTime = sTime;
        this.dPrice = dPrice;
        this.urlImage = urlImage;

        this.urlOnlineLocation = urlOnlineLocation;
        this.locationModel = locationModel;

        if (sessionModel != null) {
            this.oSessions.addAll(sessionModel);
        }

    }

    /**
     * Default constructor
     */
    public EventsModel() {

    }

    public LocationModel getLocationModel() {
        return locationModel;
    }

    public void setLocationModel(LocationModel locationModel) {
        this.locationModel = locationModel;
    }

    public Set<SessionModel> getoSessions() {
        return oSessions;
    }

    public void setoSessions(Set<SessionModel> oSessions) {
        if (oSessions != null) {
            this.oSessions.addAll(oSessions);
        }
    }

    private String sessionToString() {
        StringBuffer sbuf = new StringBuffer();
        for (SessionModel sm : this.oSessions) {
            sbuf.append(sm.toString() + ", ");
        }

        return sbuf.toString();
    }


    @Override
    public String toString() {
        return "EventsModel{" +
                "iEventId=" + iEventId +
                ", sName='" + sName + '\'' +
                ", dDate=" + dDate +
                ", sTime='" + sTime + '\'' +
                ", dPrice=" + dPrice +
                ", urlImage='" + urlImage + '\'' +
                ", locationModel=" + locationModel.toString() +
                ", urlOnlineLocation='" + urlOnlineLocation + '\'' +
                ". oSessions= '" + sessionToString() + '\'' +
                '}';
    }

    public int getiEventId() {
        return iEventId;
    }

    public void setiEventId(int iEventId) {
        this.iEventId = iEventId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Date getdDate() {
        return dDate;
    }

    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlOnlineLocation() {
        return urlOnlineLocation;
    }

    public void setUrlOnlineLocation(String urlOnlineLocation) {
        this.urlOnlineLocation = urlOnlineLocation;
    }
}




