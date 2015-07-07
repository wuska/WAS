/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.users;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.web.core.SessionUtil;
import pl.was05.wiezienie.user.UserEndpointLocal;

/**
 *
 * @author java
 */
@SessionScoped
public class UserController implements Serializable {

    @EJB
    private UserEndpointLocal userEndpoint;

    private UserDTO registeredUser;
    private UserDTO viewUser;
    private UserDTO editUser;

    public UserDTO getRegisteredUser() {
        return registeredUser;
    }

    public void setRegisteredUser(UserDTO registeredUser) {
        this.registeredUser = registeredUser;
    }

    public UserDTO getViewUser() {
        return viewUser;
    }

    public void setViewUser(UserDTO viewUser) {
        this.viewUser = viewUser;
    }

    public UserDTO getEditUser() {
        return editUser;
    }

    public void setEditUser(UserDTO editUser) {
        this.editUser = editUser;
    }

    public void register() {
        if (null == registeredUser) {
            throw new IllegalArgumentException("Try to register user omitting registration form");
        }
        System.err.println("userDTO-registeredUser: "+registeredUser);
        userEndpoint.registerUser(registeredUser);
        registeredUser = null;
    }

    public List<UserDTO> getAllUsers() {
        System.out.println("UserController:getAllUsers()");
        return userEndpoint.getAllUsers();
    }

    public void removeUser(UserDTO user) {
        userEndpoint.removeUser(user);
    }

    public void activateUser(final UserDTO userDTO) {
        userEndpoint.activeUser(userDTO);
    }

    public void desactivateUser(final UserDTO userDTO) {
        userEndpoint.desactiveUser(userDTO);
    }

    public void getUserToView(UserDTO userDTO) {
        viewUser = userEndpoint.findByLogin(userDTO.getLogin());
    }

    public void getUsterToEdit(UserDTO userDTO) {
        editUser = userEndpoint.getUserToEdit(userDTO.getLogin());
    }

    public void saveUserAfterEdit() {
        userEndpoint.saveUserAfterEdit(editUser);
    }

}
