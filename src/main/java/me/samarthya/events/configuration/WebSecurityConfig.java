package me.samarthya.events.configuration;

import me.samarthya.events.ldap.context.CustomUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.NameAwareAttribute;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.ldap.userdetails.LdapUserDetailsMapper;
import org.springframework.security.ldap.userdetails.UserDetailsContextMapper;


import javax.naming.directory.Attributes;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .ldapAuthentication().userDetailsContextMapper(userDetailsContextMapper()).contextSource()
                .root("dc=example,dc=com")
                .url("ldap://localhost:10389/dc=example,dc=com").managerDn("uid=admin,ou=system").managerPassword("secret")
                .and()
                .userSearchBase("ou=users")
                .groupSearchBase("ou=groups")
                .groupSearchFilter("member={0}")
                .groupRoleAttribute("cn")
                .userDnPatterns("ou=users,dc=example,dc=com")
                .userSearchFilter("uid={0}");

    }

    /**
     * Configuration based web security.
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/hello", "/ets", "/ets/**", "/status","/sessions", "/clean").permitAll().anyRequest()
                .authenticated()
                .and()
                .csrf().disable();
    }




    @Bean
    public UserDetailsContextMapper userDetailsContextMapper() {

        return new LdapUserDetailsMapper() {

            @Override
            public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {

                Attributes ats = ctx.getAttributes();

                NameAwareAttribute nawcn = (NameAwareAttribute) ats.get("cn");
                NameAwareAttribute nawsn = (NameAwareAttribute) ats.get("sn");


                UserDetails ud = super.mapUserFromContext(ctx, username, authorities);

                CustomUserDetails cud = new CustomUserDetails(ud);

                cud.setCn((String) nawcn.get());
                cud.setSn((String) nawsn.get());
                return cud;
            }
        };
    }
}
