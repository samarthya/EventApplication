package me.samarthya.events.ldap.repository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

@Configuration
@EnableLdapRepositories(basePackages = "me.samarthya.events.ldap.repository")
public class LdapApacheDSConfiguration {

    @Bean
    ContextSource contextSource() {
        LdapContextSource ldapContextSource = new LdapContextSource();

        ldapContextSource.setUrl("ldap://localhost:10389");
        ldapContextSource.setPassword("secret");
        ldapContextSource.setUserDn("uid=admin,ou=system");
        ldapContextSource.setBase("dc=example,dc=com");

        return ldapContextSource;
    }

    @Bean
    LdapTemplate ldapTemplate(ContextSource contextSource) {
        return new LdapTemplate(contextSource);
    }
}
