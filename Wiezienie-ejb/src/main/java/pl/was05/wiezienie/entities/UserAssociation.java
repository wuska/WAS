/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
@IdClass(UserAssociationId.class)
public class UserAssociation {

    @Id
    private Long userId;
    @Id
    private Long roleId;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "USERID", referencedColumnName = "ID")
    /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
     *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
     *  @JoinColumn(name = "employeeId", updatable = false, insertable = false)
     * or @JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "id")
     */
    private User user;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "ROLEID", referencedColumnName = "ID")
    /* the same goes here:
     *  if this JPA model doesn't create a table for the "PROJ_EMP" entity,
     *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
     *  @JoinColumn(name = "projectId", updatable = false, insertable = false)
     * or @JoinColumn(name = "projectId", updatable = false, insertable = false, referencedColumnName = "id")
     */
    private Role role;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
