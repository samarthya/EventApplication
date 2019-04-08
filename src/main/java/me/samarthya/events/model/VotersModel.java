package me.samarthya.events.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "voters_model")
public class VotersModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "voterid")
    private int iId;

    @NotNull
    @Column(name = "name")
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
