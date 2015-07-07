/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Kawa
 */
@Entity
@Table(name = "Prisoners")
@TableGenerator(name = "PrisonerGen", table = "generator", initialValue = 101, allocationSize = 10,
        pkColumnName = "class", pkColumnValue = "Prisoner", valueColumnName = "rsv")
@Inheritance(strategy = InheritanceType.JOINED)
public class Prisoner implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "PrisonerGen")
    private Long id;

    @Column(nullable = false, unique = false)
    private String name;

    @Column(nullable = false, unique = true)
    private Long pesel;

    @Column(nullable = true, unique = false)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateExit;

    @JoinColumn(name = "kara_id")
    @OneToOne
    private Penalty karaId;

    @JoinColumn(name = "cell_id")
    @ManyToOne(fetch=FetchType.LAZY)
    private Cell cellId;

    @Version
    int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateExit() {
        return dateExit;
    }

    public void setDateExit(Date dateExit) {
        this.dateExit = dateExit;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.pesel);
        hash = 79 * hash + Objects.hashCode(this.dateExit);
        hash = 79 * hash + Objects.hashCode(this.karaId);
        hash = 79 * hash + Objects.hashCode(this.cellId);
        return hash;
    }

    @Override
    public String toString() {
        return "pl.was05.wiezienie.entities.Prisoner[ id=" + id + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prisoner other = (Prisoner) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
       
     
        return true;
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
    public Penalty getKaraId() {
        return karaId;
    }

    /**
     * @param karaId the karaId to set
     */
    public void setKaraId(Penalty karaId) {
        this.karaId = karaId;
    }

    public Cell getCellId() {
        return cellId;
    }

    public void setCellId(Cell cellId) {
        this.cellId = cellId;
    }

}
