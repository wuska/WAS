/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wienzienie.dto;


/**
 *
 * @author Kawa
 */
public class PrisonerDTO {
    
    private String name;
    private Long pesel;
    private Long karaId;

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
    
    @Override
    public String toString() {
        return "PrisonerDTO{" + "name=" + name + " pesel=" + pesel + " karaId=" + karaId + "}";
    }
}
