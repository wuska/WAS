/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.userPages;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.RoleDTO;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.web.admin.role.RoleController;
import pl.was05.wiezienie.web.admin.users.UserController;

/**
 *
 * @author java
 */
@RequestScoped
@Named
public class EditPageBean {

    @Inject
    private UserController userController;
    @Inject
    RoleController roleController;


    
    public UserDTO getUser() {
        return userController.getEditUser();
    }

    public String saveUser() {
        userController.saveUserAfterEdit();
        return "listUsers";
    }

    public String addRoleLocation() {
        roleController.setLocationFrom("edit");
        return "/admin/selectRole";
    }

}
