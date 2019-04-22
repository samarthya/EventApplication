package me.samarthya.events.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

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
    @JsonProperty("id")
    private long lEventId;

    @Column(name = "name")
    @JsonProperty("name")
    private String sName;

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yy hh:mm:ss")
    @JsonProperty("date")
    private Date dDate;

    @Column(name = "time")
    @JsonProperty("time")
    private String sTime;

    @Column(name = "price")
    @JsonProperty("price")
    private double dPrice;

    @Column(name = "imageUrl")
    @JsonProperty("imageUrl")
    private String urlImage;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fklocationid")
    @JsonProperty("location")
    private LocationModel locationModel;


    @Column(name = "onlineUrl")
    @JsonProperty("onlineUrl")
    private String urlOnlineLocation;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fksid")
    @JsonProperty("sessions")
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

    @JsonSetter("location")
    public void setLocationModel(LocationModel locationModel) {
        this.locationModel = locationModel;
    }

    public Set<SessionModel> getoSessions() {
        return oSessions;
    }

    @JsonSetter("sessions")
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
                "lEventId=" + lEventId +
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

    @JsonGetter("id")
    public long getlEventId() {
        return lEventId;
    }

    @JsonSetter("id")
    public void setlEventId(long lEventId) {
        this.lEventId = lEventId;
    }

    @JsonGetter("name")
    public String getsName() {
        return sName;
    }

    @JsonSetter("name")
    public void setsName(String sName) {
        this.sName = sName;
    }


    public Date getdDate() {
        return dDate;
    }

    @JsonSetter("date")
    public void setdDate(Date dDate) {
        this.dDate = dDate;
    }

    public String getsTime() {
        return sTime;
    }

    @JsonSetter("time")
    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public double getdPrice() {
        return dPrice;
    }

    @JsonSetter("price")
    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public String getUrlImage() {
        return urlImage;
    }

    @JsonSetter("imageUrl")
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getUrlOnlineLocation() {
        return urlOnlineLocation;
    }

    @JsonSetter("onlineUrl")
    public void setUrlOnlineLocation(String urlOnlineLocation) {
        this.urlOnlineLocation = urlOnlineLocation;
    }
}




