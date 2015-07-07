/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Version;
import javax.persistence.criteria.Fetch;

/**
 *
 * @author Kawa
 */
@Entity
@Table(name = "Cells")
@TableGenerator(name = "CellGen", table = "generator", initialValue = 101, allocationSize = 10,
        pkColumnName = "class", pkColumnValue = "Cell", valueColumnName = "rsv")

public class Cell implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "CellGen")
    private Long id;

    @Column(nullable = false, unique = false)
    private Integer capacity;

    @Column(nullable = false, unique = false)
    private Integer employeeId;
    @OneToMany(mappedBy = "cellId")
    private List<Prisoner> prisoners;

    @Version
    int version;

    public Cell(Long id) {
        this.id = id;
    }

    public Cell() {
    }

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
        hash += (capacity != null ? capacity.hashCode() : 0);
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cell)) {
            return false;
        }
        Cell other = (Cell) object;
        if (((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
                || ((this.capacity == null && other.capacity != null) || (this.capacity != null && !this.capacity.equals(other.capacity)))
                || ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId)))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.was05.wiezienie.entities.Cell[ id=" + id + " ]";
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the employeeId
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<Prisoner> getPrisoners() {
        return prisoners;
    }

    public void setPrisoners(List<Prisoner> prisoners) {
        this.prisoners = prisoners;
    }

  

}
