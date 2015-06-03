/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.user;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import pl.was05.wienzienie.dto.RoleDTO;
import pl.was05.wiezienie.entities.Role;
import pl.was05.wiezienie.facades.RoleFacade;
import pl.was05.wiezienie.utils.RoleConverter;

/**
 *
 * @author zar
 */
@Stateful
public class RoleEndpoint implements RoleEndpointLocal {

    @EJB
    private RoleFacade roleFacade;

  
    public List<RoleDTO> getAllRoles() {
        System.out.println("RoleEndpoint:getAllRole()");
        List<Role> roles = roleFacade.findAll();
        List<RoleDTO> roledtos = new ArrayList<>();
        RoleConverter.convertRoleListToDTO(roles, roledtos);
        return roledtos;
    }


}
