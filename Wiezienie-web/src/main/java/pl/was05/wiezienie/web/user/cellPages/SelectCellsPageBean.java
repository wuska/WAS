/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.cellPages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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
public class SelectCellsPageBean {

    @Inject
    private CellController cellController;

    DataModel<CellDTO> cells;

    @PostConstruct
    private void init() {
        cells = new ListDataModel<>(cellController.getAllByIdLike(Long.parseLong("-1", 10)));
    }

    public void phaseListener(AjaxBehaviorEvent e) {
        String data = (String) ((UIInput) e.getSource()).getValue();
        if (data != null && !data.isEmpty()) {
            cells = new ListDataModel<>(cellController.getAllByIdLike(Long.parseLong(data, 10)));
        }
    }

    public String select() {
        cellController.getToSelect(cells.getRowData());
        return "/users/prisoner/registerNew";
    }

    public DataModel<CellDTO> getCells() {
        return cells;
    }

}
