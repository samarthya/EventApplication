package me.samarthya.events.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "voters_model")
public class VotersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "voterid")
    @JsonIgnore
    private int iId;

    @NotNull
    @Column(name = "name")
    @JsonProperty("name")
    private String sVoterName;

    public VotersModel() {
    }

    public VotersModel(String sVoterName) {
        this.sVoterName = sVoterName;
    }

    @Override
    public String toString() {
        return "VotersModel {" +
                "iId=" + iId +
                ", sVoterName='" + sVoterName + '\'' +
                '}';
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getsVoterName() {
        return sVoterName;
    }

    public void setsVoterName(String sVoterName) {
        this.sVoterName = sVoterName;
    }
}
