/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.userPages;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.web.admin.users.UserController;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class ViewPageBean {

    @Inject
    private UserController userController;

    public UserDTO getUser() {
        return userController.getViewUser();
    }

}
