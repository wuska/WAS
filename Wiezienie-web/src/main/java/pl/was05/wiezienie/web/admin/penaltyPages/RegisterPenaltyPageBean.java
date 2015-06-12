/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.admin.penaltyPages;


import javax.annotation.PostConstruct;
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
public class RegisterPenaltyPageBean {

    @Inject
    private PenaltyController penaltyController;
    private PenaltyDTO penaltyDTO = new PenaltyDTO();

    @PostConstruct
    private void init() {
    }

    public String register() {
        penaltyController.setRegisteredPenalty(penaltyDTO);
        return "registerConfirm";
    }

    public PenaltyDTO getPenaltyDTO() {
        return penaltyDTO;
    }

    public void setPenaltyDTO(PenaltyDTO penaltyDTO) {
        this.penaltyDTO = penaltyDTO;
    }
    
    
}
