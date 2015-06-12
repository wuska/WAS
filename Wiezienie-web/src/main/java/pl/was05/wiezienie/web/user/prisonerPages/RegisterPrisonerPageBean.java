/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.web.user.prisonerPages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import pl.was05.wienzienie.dto.PenaltyDTO;
import pl.was05.wienzienie.dto.PrisonerDTO;
import pl.was05.wiezienie.web.admin.penalty.PenaltyController;
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
    @Inject
    private PenaltyController penaltyController;

   
private Map<String, Long> penaltys;

    @PostConstruct
    private void init() {
        penaltys = new LinkedHashMap<String, Long>();
        List<PenaltyDTO> listPenalty = penaltyController.getAll();
        for (PenaltyDTO penaltyDTO : listPenalty) {
            penaltys.put(penaltyDTO.getName(), penaltyDTO.getId());
        }
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

    public Map<String, Long> getPenaltys() {
        return penaltys;
    }

    public void setPenaltys(Map<String, Long> penaltys) {
        this.penaltys = penaltys;
    }

   
    
    
}
