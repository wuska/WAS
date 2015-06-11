/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.cell;

import java.util.List;
import javax.ejb.Local;
import pl.was05.wienzienie.dto.CellDTO;

/**
 *
 * @author zar
 */
@Local
public interface CellEndpointLocal {

    List<CellDTO> getAll();

    void registerCell(final CellDTO cellDTO);

    public void saveCellAfterEdit(CellDTO cellDTO);

    public CellDTO getCellToEdit(Long cellId);

    public void removeCell(CellDTO cellDTO);

    public CellDTO findById(Long cellId);
}
