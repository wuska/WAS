/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 *
 * @author Kawa
 */
@Entity
@Table(name = "Prisoners")
@TableGenerator(name = "UserGen", table = "generator", initialValue = 101, allocationSize = 10,
        pkColumnName = "class", pkColumnValue = "Prisoner", valueColumnName = "rsv")
public class Prisoner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "UserGen")
    private Long id;
    
    @Column(nullable = false, unique = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private Long pesel;
    
    @Column(nullable = false, unique = false)
    private Long karaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        hash += (name != null ? name.hashCode() : 0);
        hash += (pesel != null ? pesel.hashCode() : 0);
        hash += (karaId != null ? karaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prisoner)) {
            return false;
        }
        Prisoner other = (Prisoner) object;
        if (((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) ||
            ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) ||
            ((this.pesel == null && other.pesel != null) || (this.pesel != null && !this.pesel.equals(other.pesel))) ||
            ((this.karaId == null && other.karaId != null) || (this.karaId != null && !this.karaId.equals(other.karaId)))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.was05.wiezienie.entities.Prisoner[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pesel
     */
    public Long getPesel() {
        return pesel;
    }

    /**
     * @param pesel the pesel to set
     */
    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    /**
     * @return the karaId
     */
    public Long getKaraId() {
        return karaId;
    }

    /**
     * @param karaId the karaId to set
     */
    public void setKaraId(Long karaId) {
        this.karaId = karaId;
    }

}
