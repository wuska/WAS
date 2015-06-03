/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.userPages;

import pl.was05.wiezienie.web.admin.users.UserController;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.RoleDTO;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.web.admin.role.RoleController;
import pl.was05.wiezienie.web.core.SessionUtil;

/**
 *
 * @author java
 */
@RequestScoped
@Named
public class ListUsersPageBean {

    @Inject
    UserController uctl;
    
    @Inject
    RoleController roleController;
    
    DataModel<UserDTO> users;
    private Map<String, Long> roles;

    @PostConstruct
    private void init() {
        System.out.println("ListUsersPageBean:init()");
        users = new ListDataModel<>(uctl.getAllUsers());
        
        roles = new LinkedHashMap<String, Long>();
        List<RoleDTO> listRole = roleController.getAllRoles();
        for (RoleDTO roleDTO : listRole) {
            roles.put(roleDTO.getGroupName(), roleDTO.getGroupId());
        }
    }

    public DataModel<UserDTO> getUsers() {
        System.out.println("ListUsersPageBean:getUsers()");
        return users;
    }

    public void removeUser() {
        uctl.removeUser(users.getRowData());
        users = new ListDataModel<>(uctl.getAllUsers());
    }

    public String sessionId() {
        return SessionUtil.getSessionId();
    }

    public void activateUser() {
        uctl.activateUser(users.getRowData());
        init();
    }

    public void desactivateUser() {
        uctl.desactivateUser(users.getRowData());
        init();
    }

    public String viewUser() {
        uctl.getUserToView(users.getRowData());
        return "show";
    }

    public String editeUser() {
        uctl.getUsterToEdit(users.getRowData());
        return "edit";
    }


    public Map<String, Long> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Long> roles) {
        this.roles = roles;
    }

}
