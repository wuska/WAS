/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.penaltyPages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.PenaltyDTO;
import pl.was05.wienzienie.dto.UserDTO;
import pl.was05.wiezienie.web.admin.penalty.PenaltyController;
import pl.was05.wiezienie.web.admin.users.UserController;

/**
 *
 * @author zar
 */
@RequestScoped
@Named
public class SerchBeen {

    private String searchString;

    private String title;

    public String searchByTitle(String title) {
        if (title.equals("a")) {
            this.title = "xxxx";
        } else {
            this.title = "www";
        }

        return null;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    public String getTitle() {
        return title;
    }

    public void phaseListener(AjaxBehaviorEvent e) {
        System.out.println(e);
         this.title = (String)((UIInput)e.getSource()).getValue();
         penaltys = new ListDataModel<>(penaltyController.getAllByNameLike(this.title ));
    }
    

    @Inject
    private PenaltyController penaltyController;

    DataModel<PenaltyDTO> penaltys;

    public DataModel<PenaltyDTO> getPenaltys() {
        return penaltys;
    }

    public void setPenaltys(DataModel<PenaltyDTO> penaltys) {
        this.penaltys = penaltys;
    }
    
    

    @PostConstruct
    private void init() {
        penaltys = new ListDataModel<>(penaltyController.getAll());

    }
    
     public String view() {
        penaltyController.getToSelect(penaltys.getRowData());       
        return "/users/prisoner/registerNew";
    }
}
