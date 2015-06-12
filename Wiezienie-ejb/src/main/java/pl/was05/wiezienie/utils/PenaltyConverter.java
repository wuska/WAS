/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.utils;

import java.util.List;
import pl.was05.wienzienie.dto.PenaltyDTO;
import pl.was05.wiezienie.entities.Penalty;

/**
 *
 * @author zar
 */
public class PenaltyConverter {

    public static void convertPenaltyToDTO(Penalty src, PenaltyDTO dst) {
        dst.setName(src.getName());
        dst.setId(src.getId());
    }

    public static void convertPenaltyToEntity(PenaltyDTO src, Penalty dst) {
        dst.setName(src.getName());
        dst.setId(src.getId());
    }

    public static void convertPenaltyToEntityAfterEdit(PenaltyDTO src, Penalty dst) {
        dst.setName(src.getName());
    }

    public static void convertPenaltyListToDTO(List<Penalty> src, List<PenaltyDTO> dst) {
        for (Penalty u : src) {
            PenaltyDTO tmp = new PenaltyDTO();
            convertPenaltyToDTO(u, tmp);
            dst.add(tmp);
        }
    }

}
