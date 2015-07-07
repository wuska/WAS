/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.userPages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import pl.was05.wiezienie.web.admin.users.UserController;
import javax.enterprise.context.RequestScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.RoleDTO;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.web.admin.role.RoleController;
import pl.was05.wiezienie.web.core.SessionUtil;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class RegisterPageBean {

    @Inject
    UserController uctl;

    @Inject
    RoleController roleController;

    private UserDTO user = new UserDTO();
    private String passRepeat;
    private Long roleSelected;
    private Map<String, Long> roles;
    private DataModel<RoleDTO> roleDTOs;
    private List<RoleDTO> roleDTOList = new ArrayList<>();

    @PostConstruct
    private void init() {
        System.err.printf("RegisterPageBean:init()");
        roles = new LinkedHashMap<String, Long>();
        List<RoleDTO> listRole = roleController.getAllRoles();
        for (RoleDTO roleDTO : listRole) {
            roles.put(roleDTO.getGroupName(), roleDTO.getGroupId());
        }

        roleDTOs = new ListDataModel<>(roleController.getSelectedRoleDTOs());
    }

    public String addRoleLocation() {
        roleController.setLocationFrom("register");
        return "/admin/selectRole";
    }

    public UserDTO getUser() {
        System.out.println("RegisterPB:getUser()");
        return user;
    }

    public String getPassRepeat() {
        return passRepeat;
    }

    public void setPassRepeat(String passRepeat) {
        this.passRepeat = passRepeat;
    }

    public RegisterPageBean() {
        System.err.printf("new RegisterPB()");
    }

    public String register() throws Exception {

        System.err.printf("roleSelected: " + roleSelected);
        roleDTOList = roleController.getSelectedRoleDTOs();

        if (user.getPass() != null && user.getPass().equals(passRepeat)) {
            user.setPass(SessionUtil.getSha256(user.getPass()));
            user.setGroupId(roleSelected);
            user.setRoleDTOs(roleDTOList);
            uctl.setRegisteredUser(user);
            roleDTOList = null;
            return "registerConfirm";
        }
        return null;

    }

    public Map<String, Long> getRoles() {
        return roles;
    }

    public void setRoles(Map<String, Long> roles) {
        this.roles = roles;
    }

    public void roleChanged(ValueChangeEvent e) {
        String newLocaleValue = e.getNewValue().toString();
        System.err.printf("newLocaleValue: " + newLocaleValue);

    }

    public Long getRoleSelected() {
        return roleSelected;
    }

    public void setRoleSelected(Long roleSelected) {
        this.roleSelected = roleSelected;
    }

    public DataModel<RoleDTO> getRoleDTOs() {
        return roleDTOs;
    }

}
