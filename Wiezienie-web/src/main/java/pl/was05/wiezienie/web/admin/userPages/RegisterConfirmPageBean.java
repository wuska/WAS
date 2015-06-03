/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.userPages;

import pl.was05.wiezienie.web.admin.users.UserController;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.UserDTO;

/**
 *
 * @author java
 */
@RequestScoped
@Named
public class RegisterConfirmPageBean {

    @Inject
    UserController uctl;

    public UserDTO getUser() {
        return uctl.getRegisteredUser();
    }

    public String register() {
        uctl.register();
        return "success";
    }

}
