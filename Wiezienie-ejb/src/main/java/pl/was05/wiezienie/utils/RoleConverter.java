/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.was05.wienzienie.dto.RoleDTO;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.entities.Role;
import pl.was05.wiezienie.entities.User;
import pl.was05.wiezienie.entities.UserAssociation;

/**
 *
 * @author java
 */
public class RoleConverter {

    public static void convertRoleToDTO(Role src, RoleDTO dst) {
        dst.setGroupId(src.getId());
        dst.setGroupName(src.getGroupName());
    }

    public static void convertUserToEntity(RoleDTO src, Role dst) {
        dst.setGroupName(src.getGroupName());
        dst.setId(src.getGroupId());

    }

    public static UserAssociation convertRoleToEntity(RoleDTO src) {
        UserAssociation dst = new UserAssociation();
        Role role = new Role();
        role.setGroupName(src.getGroupName());
        role.setId(src.getGroupId());
        
        dst.setRoleId(src.getGroupId());
        dst.setRole(role);        
        return dst;
    }

    public static void convertRoleListToDTO(List<Role> src, List<RoleDTO> dst) {
        for (Role u : src) {
            RoleDTO tmp = new RoleDTO();
            convertRoleToDTO(u, tmp);
            dst.add(tmp);
        }
    }

    static List<RoleDTO> convertRoleListToDTO(List<UserAssociation> roles) {
        List<RoleDTO> dTOs = new ArrayList<>();
        for (UserAssociation u : roles) {
            RoleDTO tmp = new RoleDTO();
            convertRoleToDTO(u.getRole(), tmp);
            dTOs.add(tmp);
        }
        return dTOs;
    }

    static List<UserAssociation> convertRoleListToEntity(List<RoleDTO> roles, User user) {
        List<UserAssociation> dTOs = new ArrayList<>();
        for (RoleDTO u : roles) {
            dTOs.add(convertRoleToEntity(u));
        }
        return dTOs;
    }

}
