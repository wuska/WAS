/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.prisonerPages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.CellDTO;
import pl.was05.wienzienie.dto.PenaltyDTO;
import pl.was05.wienzienie.dto.PrisonerDTO;
import pl.was05.wiezienie.web.admin.penalty.PenaltyController;
import pl.was05.wiezienie.web.user.cell.CellController;
import pl.was05.wiezienie.web.user.prisoner.PrisonerController;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class RegisterPrisonerPageBeanNew {

    @Inject
    private PenaltyController penaltyController;
    @Inject
    private PrisonerController prisonerController;
    @Inject
    private CellController cellController;

    private PrisonerDTO prisonDTO = new PrisonerDTO();
    private PenaltyDTO penaltyDTO = new PenaltyDTO();
    private CellDTO cellDTO = new CellDTO();

    @PostConstruct
    private void init() {
        penaltyDTO = penaltyController.getSelectPenalty();
        if (penaltyDTO == null) {
            penaltyDTO = new PenaltyDTO();
        }
        cellDTO = cellController.getSelectCell();
        if (cellDTO == null) {
            cellDTO = new CellDTO();
        }
    }

    public String register() {

        prisonDTO.setPenaltyDTO(penaltyController.getSelectPenalty());
        prisonDTO.setCellDTO(cellController.getSelectCell());
        prisonerController.setRegisteredPrison(prisonDTO);
        clearExt();
        return "registerConfirm";
    }

    private void clearExt(){
        penaltyController.setSelectPenalty(null);
        cellController.setSelectCell(null);
    }
    public PrisonerDTO getPrisonDTO() {
        return prisonDTO;
    }

    public void setPrisonDTO(PrisonerDTO prisonDTO) {
        this.prisonDTO = prisonDTO;
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

    public String goTo(String value) {

        switch (value) {
            case "P":
                return "/users/penalty/test";
            case "C":
                return "/users/cell/selectCells";
            case "CANCEL":
            default:
                clearExt();
                return "/users/index";
        }

    }

}
