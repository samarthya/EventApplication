package me.samarthya.events.controller;

import me.samarthya.events.ldap.model.UserModel;
import me.samarthya.events.ldap.repository.ApacheDSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class LdapController {
    @Autowired
    ApacheDSRepository apacheDSRepository;

    @GetMapping("/userlist")
    public Iterable<UserModel> getAllUsers(HttpServletRequest request) {
        return apacheDSRepository.findAll();
    }
}
