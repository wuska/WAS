/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wienzienie.dto;


/**
 *
 * @author Dawid
 */
public class RoleDTO {

    private String groupName;
    private Long groupId;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    
    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    
    @Override
    public String toString() {
        return "Role{" + "id=" + groupId + " groupName=" + groupName  + "}";
    }

}
