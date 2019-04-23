package me.samarthya.events.ldap.context;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.ldap.userdetails.LdapUserDetailsImpl;

import java.util.Collection;

/**
 * Authenticated Principal details.
 */
public class CustomUserDetails extends LdapUserDetailsImpl {

    private String cn;
    private String sn;

    private LdapUserDetailsImpl userDetails;



    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }


    public CustomUserDetails(UserDetails ldapUserDetails) {
        this.userDetails = (LdapUserDetailsImpl) ldapUserDetails;

    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.userDetails.getAuthorities();
    }

    @Override
    public String getDn() {
        return this.userDetails.getDn();
    }

    @Override
    public String getPassword() {
        return this.userDetails.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userDetails.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.userDetails.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.userDetails.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.userDetails.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.userDetails.isEnabled();
    }

    @Override
    public void eraseCredentials() {
        this.userDetails.eraseCredentials();
    }

    @Override
    public int getTimeBeforeExpiration() {
        return this.userDetails.getTimeBeforeExpiration();
    }

    @Override
    public int getGraceLoginsRemaining() {
        return this.userDetails.getGraceLoginsRemaining();
    }

    public LdapUserDetailsImpl getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(LdapUserDetailsImpl userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public String toString() {
        return this.userDetails.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return this.userDetails.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.userDetails.hashCode();
    }
}
