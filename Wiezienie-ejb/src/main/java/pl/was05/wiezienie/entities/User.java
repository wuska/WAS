/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;

/**
 *
 * @author java
 */
@Entity
@Table(name = "Users")
@TableGenerator(name = "UserGen", table = "generator", initialValue = 101, allocationSize = 10,
        pkColumnName = "class", pkColumnValue = "User", valueColumnName = "rsv")

@NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login")

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "UserGen")

    private Long id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", cascade={CascadeType.REMOVE,CascadeType.PERSIST})
    private List<UserAssociation> roles;

    @Column(nullable = false)
    private boolean active;

    @Version
    int version;

    public void addRole(Role role) {
        UserAssociation association = new UserAssociation();
        association.setRole(role);
        association.setUser(this);
        association.setRoleId(role.getId());
        association.setUserId(this.getId());

        if (this.roles == null){
            this.roles = new ArrayList<>();
        }
        this.roles.add(association);
        role.getUsers().add(association);
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    protected void setId(Long id) {
        this.id = id;
    }

//    public Role getGroup() {
//        return group;
//    }
//
//    public void setGroup(Role group) {
//        this.group = group;
//    }
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<UserAssociation> getRoles() {
        return roles;
    }

    public void setRoles(List<UserAssociation> roles) {
        this.roles = roles;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.was05.entities.User[ id=" + id + " ]";
    }

}
