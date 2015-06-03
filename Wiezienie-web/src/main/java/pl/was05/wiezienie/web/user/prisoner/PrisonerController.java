/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.prisoner;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import pl.was05.wienzienie.dto.PrisonerDTO;
import pl.was05.wiezienie.prisoner.PrisonerEndpointLocal;

/**
 *
 * @author zar
 */
@SessionScoped
public class PrisonerController implements Serializable {

    @EJB
    private PrisonerEndpointLocal endpointLocal;

    private PrisonerDTO registeredPrison;
    private PrisonerDTO viewPrison;
    private PrisonerDTO editPrison;

    public List<PrisonerDTO> getAll() {
        return endpointLocal.getAll();
    }

    public void getToView(PrisonerDTO prisonDTO) {

    }

    public PrisonerDTO getEdit() {
        return new PrisonerDTO();
    }

    public PrisonerDTO getRegistered() {
        return new PrisonerDTO();
    }

    public PrisonerDTO getView() {
        return new PrisonerDTO();
    }

    public void register() {

    }

    public void getToEdit(PrisonerDTO prisonDTO) {

    }

    public void saveAfterEdit() {

    }

    public void remove(PrisonerDTO prisonDTO) {

    }

//----------------------------------------------------------------------
    public PrisonerDTO getRegisteredPrison() {
        return registeredPrison;
    }

    public void setRegisteredPrison(PrisonerDTO registeredPrison) {
        this.registeredPrison = registeredPrison;
    }

    public PrisonerDTO getViewPrison() {
        return viewPrison;
    }

    public void setViewPrison(PrisonerDTO viewPrison) {
        this.viewPrison = viewPrison;
    }

    public PrisonerDTO getEditPrison() {
        return editPrison;
    }

    public void setEditPrison(PrisonerDTO editPrison) {
        this.editPrison = editPrison;
    }

}
