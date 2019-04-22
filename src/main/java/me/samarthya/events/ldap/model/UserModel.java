package me.samarthya.events.ldap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.ldap.odm.annotations.*;

import javax.naming.Name;



@Entry(base="ou=users", objectClasses = {
        "top",
        "inetOrgPerson", "person", "organizationalPerson",
        "simpleSecurityObject"})
public class UserModel {

    @JsonIgnore
    private Name id;

    @JsonIgnore
    @JsonProperty("userName")
    private @Attribute(name = "uid") String uid;

    @JsonProperty("firstName")
    private @Attribute(name = "cn") String firstName;


    @JsonIgnore
    private @Attribute(name = "displayname") String displayName;

    @JsonProperty("lastName")
    private  @Attribute(name = "sn") String lastName;

    @JsonIgnore
    @JsonProperty("password")
    private @Attribute(name = "userpassword") Object password;

    public UserModel(String uid, String firstName, String displayName, String lastName) {
        this.uid = uid;
        this.firstName = firstName;
        this.displayName = displayName;
        this.lastName = lastName;
    }

    public UserModel(String userName, String firstName, String lastName) {
        this.uid = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UserModel() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUid() {
        return uid;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }


    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "uid='" + uid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
