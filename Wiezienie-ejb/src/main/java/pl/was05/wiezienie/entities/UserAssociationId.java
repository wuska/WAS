/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.entities;

import java.io.Serializable;

public class UserAssociationId implements Serializable {

    private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        return (int) (userId + roleId);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof UserAssociationId) {
            UserAssociationId otherId = (UserAssociationId) object;
            return (otherId.userId == this.userId) && (otherId.roleId == this.roleId);
        }
        return false;
    }
}
