/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.utils;

import java.util.List;
import pl.was05.wienzienie.dto.PrisonerDTO;
import pl.was05.wiezienie.entities.Prisoner;

/**
 *
 * @author zar
 */
public class PrisonerConverter {

    public static void convertPrisonerToDTO(Prisoner src, PrisonerDTO dst) {
        dst.setDateExit(src.getDateExit());
        dst.setKaraId(src.getKaraId());
        dst.setName(src.getName());
        dst.setPesel(src.getPesel());
        dst.setPrisonerId(src.getId());
    }

    public static void convertPrisonerToEntity(PrisonerDTO src, Prisoner dst) {
        
        dst.setDateExit(src.getDateExit());
        dst.setKaraId(src.getKaraId());
        dst.setName(src.getName());
        dst.setPesel(src.getPesel());
        dst.setId(src.getPrisonerId());
    }

    public static void convertPrisonerToEntityAfterEdit(PrisonerDTO src, Prisoner dst) {
        dst.setDateExit(src.getDateExit());
        dst.setKaraId(src.getKaraId());
        dst.setName(src.getName());
    }

    public static void convertPrisonerListToDTO(List<Prisoner> src, List<PrisonerDTO> dst) {
        for (Prisoner u : src) {
            PrisonerDTO tmp = new PrisonerDTO();
            convertPrisonerToDTO(u, tmp);
            dst.add(tmp);
        }
    }

}
