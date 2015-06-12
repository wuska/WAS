/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.penaltyPages;

import javax.enterprise.context.RequestScoped;
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
public class RegisterPenaltyConfirmPageBean {

    @Inject
    private PenaltyController penaltyController;

    public PenaltyDTO getPenalty() {
         return penaltyController.getRegisteredPenalty();

    }

    public String register() {
         penaltyController.register();
        return "success";
    }

}
