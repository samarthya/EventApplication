package me.samarthya.events.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * sessions:
 */
@Entity
@Table(name = "session_model")
public class SessionModel {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int iId;


    @Column(name = "name")
    private String sName;

    @Column(name = "presenter")
    private String sPresenter;

    @Column(name = "duration")
    private int iDuration;

    @Column(name = "level")
    private String sLevel;

    @Column(name = "abstract", length = 520)
    private String sAbstract;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "fkvid")
    private Set<VotersModel> voters = new HashSet<>();

    public SessionModel(String sName, String sPresenter,
                        int iDuration, String sLevel,
                        String sAbstract, Set<VotersModel> voters) {

        this.sName = sName;
        this.sPresenter = sPresenter;
        this.iDuration = iDuration;
        this.sLevel = sLevel;
        this.sAbstract = sAbstract;

        if (voters != null)
            this.voters.addAll(voters);
    }

    public SessionModel() {

    }

    public Set<VotersModel> getVoters() {
        return voters;
    }

    public void setVoters(Set<VotersModel> voters) {
        if (voters != null) {
            this.voters.addAll(voters);
        }
    }

    private String votersToString() {
        StringBuffer sbuf = new StringBuffer();
        for (VotersModel vm : this.voters) {
            sbuf.append(vm.toString() + ",");
        }
        return sbuf.toString();
    }

    @Override
    public String toString() {
        return "SessionModel {" +
                "iId=" + iId +
                ", sName='" + sName + '\'' +
                ", sPresenter='" + sPresenter + '\'' +
                ", iDuration=" + iDuration +
                ", sLevel='" + sLevel + '\'' +
                ", sAbstract='" + sAbstract + '\'' +
                ", voters=" + votersToString() +
                '}';
    }

    public int getiId() {
        return iId;
    }

    public void setiId(int iId) {
        this.iId = iId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPresenter() {
        return sPresenter;
    }

    public void setsPresenter(String sPresenter) {
        this.sPresenter = sPresenter;
    }

    public int getiDuration() {
        return iDuration;
    }

    public void setiDuration(int iDuration) {
        this.iDuration = iDuration;
    }

    public String getsLevel() {
        return sLevel;
    }

    public void setsLevel(String sLevel) {
        this.sLevel = sLevel;
    }

    public String getsAbstract() {
        return sAbstract;
    }

    public void setsAbstract(String sAbstract) {
        this.sAbstract = sAbstract;
    }
}
