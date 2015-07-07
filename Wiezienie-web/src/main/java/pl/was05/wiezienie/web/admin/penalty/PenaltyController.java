/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.penalty;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import pl.was05.wienzienie.dto.PenaltyDTO;
import pl.was05.wiezienie.penalty.PenaltyEndpointLocal;

/**
 *
 * @author zar
 */
@SessionScoped
public class PenaltyController implements Serializable {
    
    @EJB
    private PenaltyEndpointLocal endpointLocal;
    
    private PenaltyDTO registeredPenalty;
    private PenaltyDTO viewPenalty;
    private PenaltyDTO editPenalty;
     private PenaltyDTO selectPenalty;
    
    public List<PenaltyDTO> getAll() {
        return endpointLocal.getAll();
    }
    public List<PenaltyDTO> getAllByNameLike(String name) {
         System.err.println("getAllByNameLike name: " + name);
        return endpointLocal.getByNameLike(name);
    }
    
    public void getToView(PenaltyDTO penaltyDTO) {
        viewPenalty = endpointLocal.findByName(penaltyDTO.getName());
    }
    
    public void register() {
         System.err.println("registeredPenalty" + registeredPenalty);
        endpointLocal.registerPenalty(registeredPenalty);
    }
    
    public void getToEdit(PenaltyDTO penaltyDTO) {
        editPenalty = endpointLocal.getPenaltyToEdit(penaltyDTO.getName());
    }
    public void getToSelect(PenaltyDTO penaltyDTO) {
         selectPenalty = endpointLocal.findByName(penaltyDTO.getName());
    }
    public void saveAfterEdit() {
        endpointLocal.savePenaltyAfterEdit(editPenalty);
    }
    
    public void remove(PenaltyDTO penaltyDTO) {
        endpointLocal.removePenalty(endpointLocal.findByName(penaltyDTO.getName()));
    }

//----------------------------------------------------------------------
    public PenaltyDTO getRegisteredPenalty() {
         System.err.println("registeredPenalty get"+registeredPenalty);
        return registeredPenalty;
    }
    
    public void setRegisteredPenalty(PenaltyDTO registeredPenalty) {
        this.registeredPenalty = registeredPenalty;
    }
    
    public PenaltyDTO getViewPenalty() {
        return viewPenalty;
    }
    
    public void setViewPenalty(PenaltyDTO viewPenalty) {
        this.viewPenalty = viewPenalty;
    }
    
    public PenaltyDTO getEditPenalty() {
        return editPenalty;
    }
    
    public void setEditPenalty(PenaltyDTO editPenalty) {
        this.editPenalty = editPenalty;
    }

    public PenaltyDTO getSelectPenalty() {
        return selectPenalty;
    }

    public void setSelectPenalty(PenaltyDTO selectPenalty) {
        this.selectPenalty = selectPenalty;
    }
    
    
}
