package me.samarthya.events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "location_model")
public class LocationModel {

    @Id
    @NotNull
    @Column(name = "locationid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;

    @Column(name = "address")
    @JsonProperty("address")
    private String sAddress;

    @Column(name = "city")
    @JsonProperty("city")
    private String sCity;

    @Column(name = "country")
    @JsonProperty("country")
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

    @JsonSetter("id")
    public void setId(int id) {
        this.id = id;
    }

    public String getsAddress() {
        return sAddress;
    }

    @JsonSetter("address")
    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsCity() {
        return sCity;
    }

    @JsonSetter("city")
    public void setsCity(String sCity) {
        this.sCity = sCity;
    }

    public String getsCountry() {
        return sCountry;
    }

    @JsonSetter("country")
    public void setsCountry(String sCountry) {
        this.sCountry = sCountry;
    }
}


