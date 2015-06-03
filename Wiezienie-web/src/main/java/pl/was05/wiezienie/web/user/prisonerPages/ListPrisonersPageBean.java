/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.prisonerPages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.PrisonerDTO;
import pl.was05.wiezienie.web.user.prisoner.PrisonerController;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class ListPrisonersPageBean {

    @Inject
    private PrisonerController prisonerController;

    DataModel<PrisonerDTO> prisoners;

    @PostConstruct
    private void init() {
        prisoners = new ListDataModel<>(prisonerController.getAll());

    }

    public void remove() {
        prisonerController.remove(prisoners.getRowData());
        prisoners = new ListDataModel<>(prisonerController.getAll());
    }

    public String view() {
        prisonerController.getToView(prisoners.getRowData());
        return "show";
    }

    public String edit() {
        prisonerController.getToEdit(prisoners.getRowData());
        return "edit";
    }

    public DataModel<PrisonerDTO> getPrisoners() {
        return prisoners;
    }

    public void setPrisoners(DataModel<PrisonerDTO> prisoners) {
        this.prisoners = prisoners;
    }

}
