/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.cell;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import pl.was05.wienzienie.dto.CellDTO;
import pl.was05.wiezienie.cell.CellEndpointLocal;

/**
 *
 * @author zar
 */
@SessionScoped
public class CellController implements Serializable {

    @EJB
    private CellEndpointLocal endpointLocal;

    private CellDTO registeredCell;
    private CellDTO viewCell;
    private CellDTO editCell;

    public List<CellDTO> getAll() {
        return endpointLocal.getAll();
    }

    public void getToView(CellDTO cellDTO) {

    }

    public CellDTO getEdit() {
        return new CellDTO();
    }

    public CellDTO getRegistered() {
        return new CellDTO();
    }

    public CellDTO getView() {
        return new CellDTO();
    }

    public void register() {

    }

    public void getToEdit(CellDTO cellDTO) {

    }

    public void saveAfterEdit() {

    }

    public void remove(CellDTO cellDTO) {

    }

    //----------------------------------------------------------------------
    public CellDTO getRegisteredCell() {
        return registeredCell;
    }

    public void setRegisteredCell(CellDTO registeredCell) {
        this.registeredCell = registeredCell;
    }

    public CellDTO getViewCell() {
        return viewCell;
    }

    public void setViewCell(CellDTO viewCell) {
        this.viewCell = viewCell;
    }

    public CellDTO getEditCell() {
        return editCell;
    }

    public void setEditCell(CellDTO editCell) {
        this.editCell = editCell;
    }

}
