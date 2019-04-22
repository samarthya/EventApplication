package me.samarthya.events.ldap.repository;

import me.samarthya.events.ldap.context.CustomUserDetails;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApacheDSRepository extends LdapRepository<CustomUserDetails> {

}
