/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.prisoner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import pl.was05.wienzienie.dto.PrisonerDTO;
import pl.was05.wiezienie.entities.Prisoner;
import pl.was05.wiezienie.facades.PenaltyFacade;
import pl.was05.wiezienie.facades.PrisonerFacade;
import pl.was05.wiezienie.utils.PrisonerConverter;

/**
 *
 * @author zar
 */
@Stateful
public class PrisonerEndpoint implements PrisonerEndpointLocal {

    @EJB
    private PrisonerFacade prisonerFacade;
    @EJB
    private PenaltyFacade penaltyFacade;

    private Prisoner prisonerEdit = null;

    @Override
    public List<PrisonerDTO> getAll() {
        List<Prisoner> cells = prisonerFacade.findAll();
        List<PrisonerDTO> prisonerDTOs = new ArrayList<>();
        PrisonerConverter.convertPrisonerListToDTO(cells, prisonerDTOs);
        return prisonerDTOs;
    }

    @Override
    public void registerPrisoner(final PrisonerDTO prisonerDTO) {
        if (null == prisonerDTO.getKaraId()) {
            throw new IllegalArgumentException("Wskazanie na kare nie może być puste");
        }
        try {
            prisonerDTO.setKaraId(penaltyFacade.find(prisonerDTO.getKaraId()).getId());
        } catch (NullPointerException ex) {
            throw new IllegalArgumentException("Nie znaleźiono kary o podanym identyfikatoże.");
        }
        Prisoner prisoner = new Prisoner();
        System.err.println(prisonerDTO);

        PrisonerConverter.convertPrisonerToEntity(prisonerDTO, prisoner);

        System.out.println(prisoner);
        prisonerFacade.create(prisoner);

    }

    @Override
    public void removePrisoner(PrisonerDTO prisonerDTO) {
        prisonerFacade.remove(prisonerFacade.find(prisonerDTO.getPrisonerId()));
    }

    @Override
    public PrisonerDTO getPrisonerToEdit(Long cellId) {
        prisonerEdit = prisonerFacade.find(cellId);
        prisonerFacade.refresh(prisonerEdit);
        try {
            prisonerFacade.lock(prisonerEdit, LockModeType.WRITE);
        } catch (OptimisticLockException ex) {
            //optymistyczna blokada
            Logger.getLogger(PrisonerEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }

        PrisonerDTO prisonerDTO = new PrisonerDTO();

        PrisonerConverter.convertPrisonerToDTO(prisonerEdit, prisonerDTO);
        return prisonerDTO;
    }

    @Override
    public void savePrisonerAfterEdit(PrisonerDTO prisonerDTO) {
        if (null == prisonerEdit) {
            throw new IllegalArgumentException("Proba zapisania rekordu bez formularza edycji");
        }
        if (!prisonerEdit.getId().equals(prisonerDTO.getPrisonerId())) {
            throw new IllegalArgumentException("Proba edycji innego rekordu niż pobrane do edycji");
        }
        PrisonerConverter.convertPrisonerToEntityAfterEdit(prisonerDTO, prisonerEdit);
        prisonerFacade.edit(prisonerEdit);
    }

    @Override
    public PrisonerDTO findById(Long cellId) {
        Prisoner tmp = prisonerFacade.find(cellId);
        PrisonerDTO val = new PrisonerDTO();
        PrisonerConverter.convertPrisonerToDTO(tmp, val);
        return val;
    }

}
