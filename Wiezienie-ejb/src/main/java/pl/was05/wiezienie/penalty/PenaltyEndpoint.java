/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.penalty;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import pl.was05.wienzienie.dto.PenaltyDTO;
import pl.was05.wiezienie.entities.Penalty;
import pl.was05.wiezienie.facades.PenaltyFacade;
import pl.was05.wiezienie.utils.PenaltyConverter;

/**
 *
 * @author zar
 */
@Stateful
public class PenaltyEndpoint implements PenaltyEndpointLocal {

    @EJB
    private PenaltyFacade penaltyFacade;
    private Penalty penaltyEdit = null;
    
    @Override
    public List<PenaltyDTO> getAll() {
        List<Penalty> penaltys = penaltyFacade.findAll();
        List<PenaltyDTO> penaltyDTOs = new ArrayList<>();
        PenaltyConverter.convertPenaltyListToDTO(penaltys, penaltyDTOs);
        return penaltyDTOs;
    }


@Override
    public void registerPenalty(final PenaltyDTO penaltyDTO) {
        Penalty penalty = new Penalty();
        System.out.println("registerPenalty  penaltyDTO : "+penaltyDTO);
        PenaltyConverter.convertPenaltyToEntity(penaltyDTO, penalty);
        System.out.println(penalty);
        penaltyFacade.create(penalty);

    }
  
    @Override
 public void removePenalty(PenaltyDTO penaltyDTO) {
        penaltyFacade.remove(penaltyFacade.find(penaltyDTO.getId()));
    }


    @Override
    public PenaltyDTO getPenaltyToEdit(String name) {
        penaltyEdit = penaltyFacade.findByName(name);
        penaltyFacade.refresh(penaltyEdit);
        try {
            penaltyFacade.lock(penaltyEdit, LockModeType.WRITE);
        } catch (OptimisticLockException ex) {
            //optymistyczna blokada
            Logger.getLogger(PenaltyEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }

        PenaltyDTO penaltyDTO = new PenaltyDTO();

        PenaltyConverter.convertPenaltyToDTO(penaltyEdit, penaltyDTO);
        return penaltyDTO;
    }

    @Override
    public void savePenaltyAfterEdit(PenaltyDTO penaltyDTO) {
        if (null == penaltyEdit) {
            throw new IllegalArgumentException("Proba zapisania rekordu bez formularza edycji");
        }
        if (!penaltyEdit.getId().equals(penaltyDTO.getId())) {
            throw new IllegalArgumentException("Proba edycji innego rekordu niż pobrane do edycji");
        }
        PenaltyConverter.convertPenaltyToEntityAfterEdit(penaltyDTO, penaltyEdit);
        penaltyFacade.edit(penaltyEdit);
    }
    
    @Override
     public PenaltyDTO findById(Long penaltyId) {
        Penalty tmp = penaltyFacade.find(penaltyId);
        PenaltyDTO val = new PenaltyDTO();
        PenaltyConverter.convertPenaltyToDTO(tmp, val);
        return val;
    }

    @Override
     public PenaltyDTO findByName(String name) {
        Penalty tmp = penaltyFacade.findByName(name);
        PenaltyDTO val = new PenaltyDTO();
        PenaltyConverter.convertPenaltyToDTO(tmp, val);
        return val;
    }

}
