package me.samarthya.events.controller;

import me.samarthya.events.ldap.context.CustomUserDetails;
import me.samarthya.events.ldap.model.UserModel;
import me.samarthya.events.ldap.LdapUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


@RestController
public class FoundationController {



    @ResponseBody
    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    String sayHello() {
        return "Hello world!";
    }

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }

    @GetMapping("/login")
    public UserModel login(HttpServletRequest request) {
        UserModel um = null;
        Principal principal = request.getUserPrincipal();

        if (principal instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken utoken = (UsernamePasswordAuthenticationToken) principal;
            CustomUserDetails userDetails = (CustomUserDetails) utoken.getPrincipal();
            um = new UserModel(userDetails.getUsername(), userDetails.getCn(), userDetails.getSn());
            um.setUid(userDetails.getUsername());
        }

        return um;
    }

    @PostMapping("/login")
    public UserModel doPostLogin(HttpServletRequest request) {
        System.out.println(" Post: Login");
        return login(request);
    }

    @GetMapping("/status")
    public UserModel getLoggedInUser(HttpServletRequest request) {
        System.out.println(" Get: Status");
        if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            return login(request);
        else
            return null;
    }

    @Autowired
    LdapUserService ldapUserService;


    @PostMapping("/update")
    public UserModel updateUserInformation(@RequestBody UserModel userModel) {

        if(ldapUserService != null) {
            List<UserModel> usersFound = ldapUserService.findByName(userModel.getUid());

            if(usersFound != null && usersFound.size() > 0) {

                for(UserModel usrM: usersFound) {

                    System.out.println(usrM.toString());

                    if(usrM.getUid().compareToIgnoreCase(userModel.getUid()) == 0) {

                        if((
                                usrM.getFirstName()
                                        .compareToIgnoreCase(
                                                userModel.getFirstName()) != 0)){

                            usrM.setFirstName(userModel.getFirstName());
                            ldapUserService.updateFirstName(usrM);
                        }

                        if((usrM.getLastName()
                                        .compareToIgnoreCase(
                                                userModel.getLastName()) != 0)) {

                                    usrM.setLastName(userModel.getLastName());
                                    ldapUserService.updateLastName(usrM);

                        }

                        return usrM;
                    }
                }
            }
        }
        return userModel;
    }

    @PostMapping("/logout")
    public boolean logOutP(HttpServletRequest httpServletRequest) {

        if(httpServletRequest.getUserPrincipal() != null) {
         if(SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
            SecurityContextHolder.clearContext();
             System.out.println("Logged out.");
         }
         return true;
        }
        return false;
    }

    @GetMapping("/logout")
    public boolean logOutG(HttpServletRequest httpServletRequest) {
        return logOutP(httpServletRequest);
    }
}
