/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.cellPages;

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
public class EditCellPageBean {

    @Inject
    private CellController cellController;

    public CellDTO getCell() {
       return cellController.getEdit();
      
    }

    public String save() {
        cellController.saveAfterEdit();
        return "list";
    }

}
