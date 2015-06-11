/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.utils;

import java.util.List;
import pl.was05.wienzienie.dto.CellDTO;
import pl.was05.wiezienie.entities.Cell;

/**
 *
 * @author zar
 */
public class CellConverter {

    public static void convertCellToDTO(Cell src, CellDTO dst) {
        dst.setEmployeeId(src.getEmployeeId());
        dst.setCapacity(src.getCapacity());
        dst.setId(src.getId());
    }

    public static void convertCellToEntity(CellDTO src, Cell dst) {
        dst.setEmployeeId(src.getEmployeeId());
        dst.setCapacity(src.getCapacity());
        dst.setId(src.getId());
    }

    public static void convertCellToEntityAfterEdit(CellDTO src, Cell dst) {
        dst.setEmployeeId(src.getEmployeeId());
    }

    public static void convertCellListToDTO(List<Cell> src, List<CellDTO> dst) {
        for (Cell u : src) {
            CellDTO tmp = new CellDTO();
            convertCellToDTO(u, tmp);
            dst.add(tmp);
        }
    }

}
