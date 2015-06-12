/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.penalty;

import java.util.List;
import javax.ejb.Local;
import pl.was05.wienzienie.dto.PenaltyDTO;

/**
 *
 * @author zar
 */
@Local
public interface PenaltyEndpointLocal {

    List<PenaltyDTO> getAll();

    void registerPenalty(final PenaltyDTO penaltyDTO);

    public void savePenaltyAfterEdit(PenaltyDTO penaltyDTO);

    public PenaltyDTO getPenaltyToEdit(String name);

    public void removePenalty(PenaltyDTO penaltyDTO);

    public PenaltyDTO findById(Long name);
    PenaltyDTO findByName(String name);
}
