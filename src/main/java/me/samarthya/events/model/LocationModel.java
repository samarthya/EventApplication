package me.samarthya.events.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "location_model")
public class LocationModel {

    @Id
    @NotNull
    @Column(name = "locationid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "address")
    private String sAddress;

    @Column(name = "city")
    private String sCity;

    @Column(name = "country")
    private String sCountry;


    public LocationModel() {

    }

    public LocationModel(String sAddress, String sCity, String sCountry) {
        this.sAddress = sAddress;
        this.sCity = sCity;
        this.sCountry = sCountry;
    }

    @Override
    public String toString() {
        return "LocationModel {" +
                "iLocationId=" + id +
                ", sAddress='" + sAddress + '\'' +
                ", sCity='" + sCity + '\'' +
                ", sCountry='" + sCountry + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsCity() {
        return sCity;
    }

    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public String getsCountry() {
        return sCountry;
    }

    public void setsCountry(String sCountry) {
        this.sCountry = sCountry;
    }
}


