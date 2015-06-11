/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.prisoner;

import java.util.List;
import javax.ejb.Local;
import pl.was05.wienzienie.dto.PrisonerDTO;
/**
 *
 * @author zar
 */
@Local
public interface PrisonerEndpointLocal {

    List<PrisonerDTO> getAll();

    public PrisonerDTO getPrisonerToEdit(Long cellId);

    public void removePrisoner(PrisonerDTO prisonerDTO);

    public void registerPrisoner(PrisonerDTO prisonerDTO);

    public void savePrisonerAfterEdit(PrisonerDTO prisonerDTO);

    public PrisonerDTO findById(Long cellId);
}
