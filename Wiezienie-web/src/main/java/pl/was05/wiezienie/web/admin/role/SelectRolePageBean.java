/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.RoleDTO;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class SelectRolePageBean {

    @Inject
    private RoleController roleController;

    DataModel<RoleDTO> roles;
    private Map<RoleDTO, Boolean> checkMap;

    @PostConstruct
    private void init() {
        Boolean chack;
        checkMap = new HashMap<>();
        roles = new ListDataModel<>(roleController.getAllByNameLike(roleController.getSarchString()));
        List<RoleDTO> ithemSelected = roleController.getSelectedRoleDTOs();
        for (RoleDTO item : roles) {
            chack = Boolean.FALSE;
            for (RoleDTO itemSelected : roleController.getSelectedRoleDTOs()) {
                if (Objects.equals(item.getGroupId(), itemSelected.getGroupId())) {
                    chack = Boolean.TRUE;
                    System.err.println("chack : " + chack + "itemSelected: " + itemSelected);
                    break;
                }
            }
            checkMap.put(item, chack);
        }
    }

    public void phaseListener(AjaxBehaviorEvent e) {
        roleController.setSarchString((String) ((UIInput) e.getSource()).getValue());
        roles = new ListDataModel<>(roleController.getAllByNameLike(roleController.getSarchString()));

    }

    public String select() {
        List<RoleDTO> rolesSelected = new ArrayList<>();
        for (Entry<RoleDTO, Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) {
                rolesSelected.add(entry.getKey());
            }
        }
        roleController.getToSelect(rolesSelected);
        roleController.setSarchString("");
        return roleController.getLocationFrom();
    }

    public DataModel<RoleDTO> getRoles() {
        return roles;
    }

    public Map<RoleDTO, Boolean> getCheckMap() {
        return checkMap;
    }

    public String getSelected() {
        String result = "";
        for (Entry<RoleDTO, Boolean> entry : checkMap.entrySet()) {
            if (entry.getValue()) {
                result = result + ", " + entry.getKey();
            }
        }
        List<RoleDTO> rolesSelected = new ArrayList<>();
        for (Entry<RoleDTO, Boolean> entry : checkMap.entrySet()) {
            
            if (entry.getValue()) {              
                roleController.selectedOper(entry.getKey(), "I");
            }
//            else {
//                roleController.selectedOper(entry.getKey(), "D");
//            }
            
        }
       
        return result.length() == 0 ? "" : result.substring(2);

    }
    


}
