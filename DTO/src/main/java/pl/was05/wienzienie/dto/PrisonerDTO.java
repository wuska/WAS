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
    private Long prisonerId;
    private Date dateExit;
    private PenaltyDTO penaltyDTO;
    private CellDTO cellDTO;

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

    public PenaltyDTO getPenaltyDTO() {
        return penaltyDTO;
    }

    public void setPenaltyDTO(PenaltyDTO penaltyDTO) {
        this.penaltyDTO = penaltyDTO;
    }

    public CellDTO getCellDTO() {
        return cellDTO;
    }

    public void setCellDTO(CellDTO cellDTO) {
        this.cellDTO = cellDTO;
    }

    @Override
    public String toString() {
        return "PrisonerDTO{" + "name=" + name + " pesel=" + pesel + " dateExit=" + dateExit + "}";
    }
}
