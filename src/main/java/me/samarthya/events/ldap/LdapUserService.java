package me.samarthya.events.ldap;

import me.samarthya.events.ldap.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.DirContextOperations;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.AbstractContextMapper;
import org.springframework.ldap.core.support.BaseLdapNameAware;
import org.springframework.ldap.filter.EqualsFilter;
import org.springframework.ldap.query.LdapQuery;
import org.springframework.ldap.support.LdapNameBuilder;
import org.springframework.ldap.support.LdapUtils;
import org.springframework.stereotype.Service;

import javax.naming.Name;
import javax.naming.directory.*;
import javax.naming.ldap.LdapName;
import java.util.List;


import static org.springframework.ldap.query.LdapQueryBuilder.query;

@Service()
public class LdapUserService implements BaseLdapNameAware {

    @Autowired
    private LdapTemplate ldapTemplate;

    private LdapName baseLdapPath = LdapUtils.newLdapName("");

    public void setBaseLdapPath(LdapName baseLdapPath) {
        this.baseLdapPath = baseLdapPath;
    }


    public void create(UserModel p) {
        Name dn = buildDn(p);
        ldapTemplate.bind(dn, null, buildAttributes(p));
    }

    public List<UserModel> findAll() {
        EqualsFilter filter = new EqualsFilter("objectclass", "person");
        return ldapTemplate.search(LdapUtils.emptyLdapName(), filter.encode(), new PersonContextMapper());
    }

    public UserModel findOne(String uid) {
        Name dn = LdapNameBuilder.newInstance(baseLdapPath)
                .add("ou", "users")
                .add("uid", uid)
                .build();
        return ldapTemplate.lookup(dn, new PersonContextMapper());
    }

    public List<UserModel> findByName(String name) {
        LdapQuery q = query()
                .where("objectclass").is("person")
                .and("uid").whitespaceWildcardsLike(name);
        return ldapTemplate.search(q, new PersonContextMapper());
    }

    public void update(UserModel p) {
        ldapTemplate.rebind(buildDn(p), null, buildAttributes(p));
    }

    public void updateFirstName(UserModel p) {
        Attribute attr = new BasicAttribute("cn", p.getFirstName());
        ModificationItem item = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr);
        ldapTemplate.modifyAttributes(buildDn(p), new ModificationItem[] {item});
    }

    public void updateLastName(UserModel p) {
        Attribute attr = new BasicAttribute("sn", p.getLastName());
        ModificationItem item = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attr);
        ldapTemplate.modifyAttributes(buildDn(p), new ModificationItem[] {item});
    }

    public void delete(UserModel p) {
        ldapTemplate.unbind(buildDn(p));
    }

    private Name buildDn(UserModel p) {
        return LdapNameBuilder.newInstance(baseLdapPath)
                .add("ou", "users")
                .add("uid", p.getUid())
                .build();
    }

    private Attributes buildAttributes(UserModel p) {
        Attributes attrs = new BasicAttributes();
        BasicAttribute ocAttr = new BasicAttribute("objectclass");
        ocAttr.add("top");
        ocAttr.add("inetOrgPerson");
        ocAttr.add("person");
        ocAttr.add("organizationalPerson");
        ocAttr.add("simpleSecurityObject");
        attrs.put(ocAttr);
        attrs.put("ou", "users");
        attrs.put("uid", p.getUid());
        attrs.put("cn", p.getFirstName());
        attrs.put("sn", p.getLastName());
        return attrs;
    }


    private static class PersonContextMapper extends AbstractContextMapper<UserModel> {
        public UserModel doMapFromContext(DirContextOperations context) {
            UserModel person = new UserModel();
            person.setFirstName(context.getStringAttribute("cn"));
            person.setLastName(context.getStringAttribute("sn"));
            person.setUid(context.getStringAttribute("uid"));
            person.setDisplayName(context.getStringAttribute("displayname"));
            return person;
        }
    }
}
