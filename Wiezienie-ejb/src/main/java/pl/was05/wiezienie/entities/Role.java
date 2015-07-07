/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author zar
 */
@Entity
@Table(name = "Role")
@TableGenerator(name = "RoleGen", table = "generator", initialValue = 101, allocationSize = 10,
        pkColumnName = "class", pkColumnValue = "Role", valueColumnName = "rsv")
@NamedQuery(name = "Role.findByName", query = "SELECT u FROM Role u WHERE u.groupName = :group_name")
//@NamedQuery(name = "Role.findById",query = "SELECT u FROM Role u WHERE u.id = :id")

public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "UserGen")

    private Long id;

    @Column(nullable = false, unique = true)
    private String groupName;

    @OneToMany(mappedBy = "role")
    private List<UserAssociation> users;

    public Role() {
    }

    public Role(Long groupId) {
        this.id = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<UserAssociation> getUsers() {
        return users;
    }

    public void setUsers(List<UserAssociation> users) {
        this.users = users;
    }

  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.was05.entities.Role[ id=" + id + " ]";
    }

}
