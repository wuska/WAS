/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.was05.wienzienie.dto.RoleDTO;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.entities.Role;
import pl.was05.wiezienie.entities.User;

/**
 *
 * @author java
 */
public class UserConverter {

    public static void convertUserToDTO(User src, UserDTO dst) {
        dst.setEmail(src.getEmail());
        dst.setLogin(src.getLogin());
        dst.setPass(src.getPassword());
        dst.setGroupId(src.getGroup().getId());
        dst.setActive(src.isActive());
    }

    public static void convertUserToEntity(UserDTO src, User dst) {
        dst.setEmail(src.getEmail());
        dst.setLogin(src.getLogin());
        dst.setPassword(src.getPass());
        dst.setGroup(new  Role(src.getGroupId()));
        dst.setActive(src.isActive());

    }
    
    public static void convertUserToEntityAfterEdit(UserDTO src, User dst) {
        dst.setEmail(src.getEmail());
    }

    public static void convertUserListToDTO(List<User> src, List<UserDTO> dst) {
        for (User u : src) {
            UserDTO tmp = new UserDTO();
            convertUserToDTO(u, tmp);
            dst.add(tmp);
        }
    }

}
