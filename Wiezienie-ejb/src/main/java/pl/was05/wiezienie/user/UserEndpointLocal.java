/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.user;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import pl.was05.wienzienie.dto.UserDTO;

/**
 *
 * @author java
 */
@Local
public interface UserEndpointLocal {

    void registerUser(final UserDTO user);

    public List<UserDTO> getAllUsers();

    public void removeUser(UserDTO user);

    void activeUser(final UserDTO konto);

    void desactiveUser(final UserDTO konto);

    UserDTO findByLogin(String login);

    UserDTO getUserToEdit(String login);

    void saveUserAfterEdit(UserDTO userDTO);
}
