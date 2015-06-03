/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.role;

import pl.was05.wiezienie.web.admin.users.*;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import pl.was05.wienzienie.dto.RoleDTO;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.user.RoleEndpointLocal;
import pl.was05.wiezienie.web.core.SessionUtil;
import pl.was05.wiezienie.user.UserEndpointLocal;

/**
 *
 * @author zar
 */
@SessionScoped
public class RoleController implements Serializable {

    @EJB
    private RoleEndpointLocal roleEndpoint;
    
    public List<RoleDTO> getAllRoles() {
        System.out.println("UserController:getAllUsers()");
        return roleEndpoint.getAllRoles();
    }


  
    
}
