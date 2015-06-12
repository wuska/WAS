/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.penaltyPages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.PenaltyDTO;
import pl.was05.wiezienie.web.admin.penalty.PenaltyController;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class ListPenaltyPageBean {

    @Inject
    private PenaltyController penaltyController;

    DataModel<PenaltyDTO> penaltys;

    @PostConstruct
    private void init() {
        penaltys = new ListDataModel<>(penaltyController.getAll());

    }

    public void remove() {
        penaltyController.remove(penaltys.getRowData());
        penaltys = new ListDataModel<>(penaltyController.getAll());
    }

    public String view() {
        penaltyController.getToView(penaltys.getRowData());
        return "show";
    }

    public String edit() {
        penaltyController.getToEdit(penaltys.getRowData());
        return "edit";
    }

    public DataModel<PenaltyDTO> getPenaltys() {
        return penaltys;
    }

    public void setPenaltys(DataModel<PenaltyDTO> penaltys) {
        this.penaltys = penaltys;
    }

}
