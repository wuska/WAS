/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.utils;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import pl.was05.wienzienie.dto.CellDTO;
import pl.was05.wienzienie.dto.PenaltyDTO;
import pl.was05.wienzienie.dto.PrisonerDTO;
import pl.was05.wiezienie.entities.Cell;
import pl.was05.wiezienie.entities.Penalty;
import pl.was05.wiezienie.entities.Prisoner;

/**
 *
 * @author zar
 */
public class PrisonerConverter {

    public static void convertPrisonerToDTO(Prisoner src, PrisonerDTO dst) {
        dst.setDateExit(src.getDateExit());
        dst.setName(src.getName());
        dst.setPesel(src.getPesel());
        dst.setPrisonerId(src.getId());
        PenaltyDTO dTO = new PenaltyDTO();
        PenaltyConverter.convertPenaltyToDTO(src.getKaraId(), dTO);
        dst.setPenaltyDTO(dTO);
        CellDTO cellDTO = new CellDTO();
        CellConverter.convertCellToDTO(src.getCellId(), cellDTO);
        dst.setCellDTO(cellDTO);
    }
    public static PrisonerDTO convertPrisonerToDTO(Prisoner src) {
         PrisonerDTO dst = new PrisonerDTO();
                 
        dst.setDateExit(src.getDateExit());
        dst.setName(src.getName());
        dst.setPesel(src.getPesel());
        dst.setPrisonerId(src.getId());
        PenaltyDTO dTO = new PenaltyDTO();
        PenaltyConverter.convertPenaltyToDTO(src.getKaraId(), dTO);
        dst.setPenaltyDTO(dTO);
        return dst;
    }

    public static void convertPrisonerToEntity(PrisonerDTO src, Prisoner dst) {

        dst.setDateExit(src.getDateExit());
        dst.setKaraId(new Penalty(src.getPenaltyDTO().getId()));
        dst.setCellId(new Cell(src.getCellDTO().getId()));
        dst.setName(src.getName());
        dst.setPesel(src.getPesel());
        dst.setId(src.getPrisonerId());
    }

    public static void convertPrisonerToEntityAfterEdit(PrisonerDTO src, Prisoner dst) {
        dst.setDateExit(src.getDateExit());
        dst.setKaraId(new Penalty(src.getPenaltyDTO().getId()));
        dst.setCellId(new Cell(src.getCellDTO().getId()));
        dst.setName(src.getName());
    }

    public static void convertPrisonerListToDTO(List<Prisoner> src, List<PrisonerDTO> dst) {
        for (Prisoner u : src) {
            PrisonerDTO tmp = new PrisonerDTO();
            convertPrisonerToDTO(u, tmp);
            dst.add(tmp);
        }
    }

    public static List<PrisonerDTO> convertPrisonerListToDTO(List<Prisoner> src) {
        List<PrisonerDTO> dst = new ArrayList<>();
        for (Prisoner u : src) {
            dst.add(convertPrisonerToDTO(u));
        }
        return dst;
    }
}
