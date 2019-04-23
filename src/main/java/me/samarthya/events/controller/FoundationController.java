package me.samarthya.events.controller;

import me.samarthya.events.ldap.context.CustomUserDetails;
import me.samarthya.events.ldap.model.UserModel;
import me.samarthya.events.ldap.LdapUserService;
import me.samarthya.events.ldap.repository.ApacheDSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.ldap.support.LdapUtils;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@RestController
public class FoundationController {

    /**
     * Cleans the session information.
     *
     * @param httpServletRequest
     * @return
     */
    @GetMapping("/clean")
    public boolean logOutG(HttpServletRequest httpServletRequest) {
        return logOutP(httpServletRequest);
    }

    /**
     * Helper function to test the rest end controller.
     *
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    String sayHello() {
        return "Hello world!";
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
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            return login(request);
        else
            return null;
    }

    @Autowired
    ApacheDSRepository ldapRepo;


    //    @Autowired
    //    LdapUserService ldapUserService;

    private final void dummyCode(LdapUserService ldapUserService, UserModel userModel) {

        if (ldapUserService != null) {
            List<UserModel> usersFound = ldapUserService.findByName(userModel.getUid());

            if (usersFound != null && usersFound.size() > 0) {

                for (UserModel usrM : usersFound) {

                    System.out.println(usrM.toString());

                    if (usrM.getUid().compareToIgnoreCase(userModel.getUid()) == 0) {

                        if ((
                                usrM.getFirstName()
                                        .compareToIgnoreCase(
                                                userModel.getFirstName()) != 0)) {

                            usrM.setFirstName(userModel.getFirstName());
                            ldapUserService.updateFirstName(usrM);
                        }

                        if ((usrM.getLastName()
                                .compareToIgnoreCase(
                                        userModel.getLastName()) != 0)) {

                            usrM.setLastName(userModel.getLastName());
                            ldapUserService.updateLastName(usrM);

                        }

//                        return usrM;
                    }
                }
            }
        }
    }

    @PostMapping("/update")
    public UserModel updateUserInformation(@RequestBody UserModel userModel) {
        Optional<UserModel> userModified = Optional.ofNullable(null);

        if (ldapRepo != null) {
            Optional<UserModel> usersFound = ldapRepo.findById(LdapUtils.newLdapName("uid=" +userModel.getUid() + ",ou=users"));

            if(usersFound.isPresent()){
                userModified = usersFound.map((usrM) -> {

                    if (usrM.getUid().compareToIgnoreCase(userModel.getUid()) == 0) {

                        if ((
                                usrM.getFirstName()
                                        .compareToIgnoreCase(
                                                userModel.getFirstName()) != 0)) {

                            usrM.setFirstName(userModel.getFirstName());
                            ldapRepo.save(usrM);
                        }

                        if ((usrM.getLastName()
                                .compareToIgnoreCase(
                                        userModel.getLastName()) != 0)) {

                            usrM.setLastName(userModel.getLastName());
                            ldapRepo.save(usrM);
                        }
                    }

                    return usrM;
                });
            }

        }

        return userModified.isPresent()? userModified.get(): userModel;
    }

    @PostMapping("/clean")
    public boolean logOutP(HttpServletRequest httpServletRequest) {

        if (httpServletRequest.getUserPrincipal() != null) {
            if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                SecurityContextHolder.clearContext();
                System.out.println("Logged out.");
            }
            return true;
        }
        return false;
    }


}
