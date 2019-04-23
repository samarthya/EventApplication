package me.samarthya.events.ldap.repository;

import me.samarthya.events.ldap.model.UserModel;
import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApacheDSRepository extends LdapRepository<UserModel> {

}
