/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.user;

import java.util.List;
import javax.ejb.Local;
import pl.was05.wienzienie.dto.RoleDTO;

/**
 *
 * @author zar
 */
@Local
public interface RoleEndpointLocal {

    public List<RoleDTO> getAllRoles();

    public List<RoleDTO> getAllByNameLike(String name);

}
