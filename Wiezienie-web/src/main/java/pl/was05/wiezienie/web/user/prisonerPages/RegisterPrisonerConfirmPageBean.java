/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.prisonerPages;

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
public class RegisterPrisonerConfirmPageBean {

    @Inject
    private PrisonerController prisonerController;

    public PrisonerDTO getPrisoner() {
         return prisonerController.getRegisteredPrison();

    }

    public String register() {
         prisonerController.register();
        return "success";
    }

}
