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
       
       viewCell = endpointLocal.findById(cellDTO.getId());
    }
    
    public CellDTO getEdit() {
        return this.editCell;
    }
    
    public CellDTO getRegistered() {
        return this.registeredCell;
    }
    
    public void register() {
        endpointLocal.registerCell(registeredCell);
    }
    
    public void getToEdit(CellDTO cellDTO) {
      editCell =  endpointLocal.getCellToEdit(cellDTO.getId());
    }
    
    public void saveAfterEdit() {
        endpointLocal.saveCellAfterEdit(editCell);
    }
    
    public void remove(CellDTO cellDTO) {
        endpointLocal.removeCell(cellDTO);
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
