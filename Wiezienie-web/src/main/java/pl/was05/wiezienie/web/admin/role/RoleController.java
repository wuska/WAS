/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.role;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import pl.was05.wienzienie.dto.RoleDTO;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.user.RoleEndpointLocal;
import pl.was05.wiezienie.web.admin.users.UserController;

/**
 *
 * @author zar
 */
@SessionScoped
public class RoleController implements Serializable {

    @Inject
    UserController userController;
    @EJB
    private RoleEndpointLocal roleEndpoint;
    private String sarchString = "";
    private String locationFrom;

    private List<RoleDTO> selectedRoleDTOs = new ArrayList<>();
    private List<RoleDTO> allRoleDTOs = new ArrayList<>();

    public List<RoleDTO> getAllRoles() {
        System.out.println("UserController:getAllUsers()");
        return roleEndpoint.getAllRoles();
    }

    public List<RoleDTO> getAllByNameLike(String name) {
        return roleEndpoint.getAllByNameLike(name);
    }

    void getToSelect(List<RoleDTO> rowData) {
        selectedRoleDTOs = rowData;
    }

    public List<RoleDTO> getSelectedRoleDTOs() {
        return selectedRoleDTOs;
    }

    public void setSelectedRoleDTOs(List<RoleDTO> selectedRoleDTOs) {

        this.selectedRoleDTOs = selectedRoleDTOs;
    }

    public void selectedOper(RoleDTO roleDTO, String operType) {
        if (allRoleDTOs.size() == 0) {
            allRoleDTOs = getAllRoles();
        }
        for (RoleDTO ithem : this.allRoleDTOs) {
            if (Objects.equals(ithem.getGroupId(), roleDTO.getGroupId()) && operType.equals("I")) {
                if (!selectedRoleDTOs.contains(ithem)) {
                    System.err.println("add : " + ithem);
                    selectedRoleDTOs.add(ithem);
                }
            } else if (Objects.equals(ithem.getGroupId(), roleDTO.getGroupId()) && operType.equals("D") && ithem.getGroupName().contains(sarchString)) {
                selectedRoleDTOs.remove(ithem);
                System.err.println("del : " + ithem + "sarchString: " + sarchString);
            }
        }
    }

    public String getSarchString() {
        return sarchString;
    }

    public void setSarchString(String sarchString) {
        this.sarchString = sarchString;
    }

    public String getLocationFrom() {
        if (locationFrom.equals("edit")) {
            UserDTO userDTO = userController.getEditUser();
            userDTO.setRoleDTOs(selectedRoleDTOs);
            userController.setEditUser(userDTO);
            selectedRoleDTOs = null;
        }
        return locationFrom;
    }

    public void setLocationFrom(String locationFrom) {
        if (locationFrom.equals("edit")) {
            selectedRoleDTOs = userController.getEditUser().getRoleDTOs();
        }
        this.locationFrom = locationFrom;
    }

}
