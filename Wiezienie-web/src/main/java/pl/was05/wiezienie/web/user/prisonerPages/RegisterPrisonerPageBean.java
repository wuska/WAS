/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.prisonerPages;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
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
public class RegisterPrisonerPageBean {

    @Inject
    private PrisonerController prisonerController;
    private PrisonerDTO prisonDTO = new PrisonerDTO();

    @PostConstruct
    private void init() {
    }

    public String register() {
        prisonerController.setRegisteredPrison(prisonDTO);
        return "registerConfirm";
    }

    public PrisonerDTO getPrisonDTO() {
        return prisonDTO;
    }

    public void setPrisonDTO(PrisonerDTO prisonDTO) {
        this.prisonDTO = prisonDTO;
    }
    
    
}
