/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.cellPages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.CellDTO;
import pl.was05.wiezienie.web.user.cell.CellController;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class RegisterCellPageBean {

    @Inject
    private CellController cellController;
    private CellDTO cellDTO = new CellDTO();

    @PostConstruct
    private void init() {
    }

    public String register() {
        cellController.setRegisteredCell(cellDTO);
        return "registerConfirm";
    }

    public CellDTO getCellDTO() {
        return cellDTO;
    }

    public void setCellDTO(CellDTO cellDTO) {
        this.cellDTO = cellDTO;
    }
    
}
