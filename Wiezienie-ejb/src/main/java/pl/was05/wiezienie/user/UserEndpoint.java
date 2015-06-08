/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.user;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.entities.User;
import pl.was05.wiezienie.facades.UserFacade;
import pl.was05.wiezienie.utils.UserConverter;

/**
 *
 * @author java
 */
@Stateful
public class UserEndpoint implements UserEndpointLocal {

    @EJB
    private UserFacade userFacade;
    private User userEdit = null;

    @Override
    public void registerUser(final UserDTO user) {
        User u = new User();
        UserConverter.convertUserToEntity(user, u);
        System.out.println(u);
        userFacade.create(u);
        System.out.println(u);
    }

    public List<UserDTO> getAllUsers() {
        System.out.println("UserEndpoint:getAllUsers()");
        List<User> users = userFacade.findAll();
        List<UserDTO> userdtos = new ArrayList<>();
        UserConverter.convertUserListToDTO(users, userdtos);
        return userdtos;
    }

    public void removeUser(UserDTO user) {
        userFacade.remove(userFacade.findByLogin(user.getLogin()));
    }

    @Override
    public void activeUser(final UserDTO userDTO) {
        setActivation(userDTO, true);
    }

    @Override
    public void desactiveUser(final UserDTO userDTO) {
        setActivation(userDTO, false);
    }

    private void setActivation(final UserDTO userDTO, boolean value) {
        User tmp = userFacade.findByLogin(userDTO.getLogin());
        tmp.setActive(value);
    }

    public UserDTO findByLogin(String login) {
        User tmp = userFacade.findByLogin(login);
        UserDTO val = new UserDTO();
        UserConverter.convertUserToDTO(tmp, val);
        return val;
    }

    public UserDTO getUserToEdit(String login) {
        userEdit = userFacade.findByLogin(login);
        userFacade.refresh(userEdit);
        try {
            userFacade.lock(userEdit, LockModeType.WRITE);
        } catch (OptimisticLockException ex) {
            //optymistyczna blokada
            Logger.getLogger(UserEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }

        UserDTO userDTO = new UserDTO();

        UserConverter.convertUserToDTO(userEdit, userDTO);
        return userDTO;
    }

    public void saveUserAfterEdit(UserDTO userDTO) {
        if (null == userEdit) {
            throw new IllegalArgumentException("Proba zapisania konta bez formularza edycji");
        }
        if (!userEdit.getLogin().equals(userDTO.getLogin())) {
            throw new IllegalArgumentException("Proba edycji innego konta niż pobrane do edycji");
        }
        UserConverter.convertUserToEntityAfterEdit(userDTO, userEdit);
        userFacade.edit(userEdit);
    }
}
