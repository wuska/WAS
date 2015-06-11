/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wienzienie.dto;

import java.util.Date;


/**
 *
 * @author Kawa
 */
public class PrisonerDTO {
    
    private String name;
    private Long pesel;
    private Long karaId;
    private Long prisonerId;
    private Date dateExit;

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

    public Long getPrisonerId() {
        return prisonerId;
    }

    public void setPrisonerId(Long prisonerId) {
        this.prisonerId = prisonerId;
    }

    public Date getDateExit() {
        return dateExit;
    }

    public void setDateExit(Date dateExit) {
        this.dateExit = dateExit;
    }
    
    
    
    @Override
    public String toString() {
        return "PrisonerDTO{" + "name=" + name + " pesel=" + pesel + " karaId=" + karaId +" dateExit="+dateExit+ "}";
    }
}
