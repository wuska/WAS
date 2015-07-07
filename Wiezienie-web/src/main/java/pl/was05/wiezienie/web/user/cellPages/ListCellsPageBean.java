/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.cellPages;

import javax.annotation.PostConstruct;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.CellDTO;
import pl.was05.wienzienie.dto.PrisonerDTO;
import pl.was05.wiezienie.web.user.cell.CellController;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class ListCellsPageBean {

    @Inject
    private CellController cellController;

    DataModel<CellDTO> cells;
    @PostConstruct
    private void init() {
        cells = new ListDataModel<>(cellController.getAll());
    }

    public DataModel<PrisonerDTO> getPrisoners(){
        DataModel<PrisonerDTO> prisonerDTOs = new ListDataModel<>(cells.getRowData().getPrisonerDTOs());
        return prisonerDTOs;
    }
    
    public void remove() {
        cellController.remove(cells.getRowData());
        cells = new ListDataModel<>(cellController.getAll());
    }

    public String view() {        
        cellController.getToView(cells.getRowData());
        return "show";
    }

    public String edit() {
        cellController.getToEdit(cells.getRowData());
        return "edit";
    }

    public DataModel<CellDTO> getCells() {
        return cells;
    }

    public void setCells(DataModel<CellDTO> cells) {
        this.cells = cells;
    }
    
 public boolean hasRole(String role) {
 
        FacesContext context = FacesContext.getCurrentInstance();
        System.err.print("getRequestContextPath: "+context.getExternalContext().getRemoteUser());
        System.err.print("role: "+role+" -> "+context.getExternalContext().getSessionMap());
        return context.getExternalContext().isUserInRole(role);
    }

}
