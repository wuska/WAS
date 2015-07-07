/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.cell;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;
import pl.was05.wienzienie.dto.CellDTO;
import pl.was05.wiezienie.entities.Cell;
import pl.was05.wiezienie.entities.Prisoner;
import pl.was05.wiezienie.facades.CellFacade;
import pl.was05.wiezienie.facades.PrisonerFacade;
import pl.was05.wiezienie.utils.CellConverter;

/**
 *
 * @author zar
 */
@Stateful
public class CellEndpoint implements CellEndpointLocal {

    @EJB
    private CellFacade cellFacade;

    private Cell cellEdit = null;
    private Cell cellCreate = null;

    @Override
    public List<CellDTO> getAll() {
        List<Cell> cells = cellFacade.findAll();
        List<CellDTO> cellDTOs = new ArrayList<>();
        CellConverter.convertCellListToDTO(cells, cellDTOs);
        return cellDTOs;
    }

    @Override
    public List<CellDTO> getByIdLike(Long id) {
        List<Cell> cells = cellFacade.findByIdLike(id);
        List<Cell> cellsOut = new ArrayList<>();

        for (Cell x : cells) {
            cellFacade.refresh(x);
            if (x.getPrisoners().size() < x.getCapacity()) {
                cellsOut.add(x);
            }
        }

        List<CellDTO> cellDTOs = new ArrayList<>();
        CellConverter.convertCellListToDTO(cellsOut, cellDTOs);
        return cellDTOs;
    }

    @Override
    public void registerCell(final CellDTO cellDTO) {
        Cell cell = new Cell();
        CellConverter.convertCellToEntity(cellDTO, cell);
        System.out.println(cell);
        cellFacade.create(cell);
       

    }

    @Override
    public void removeCell(CellDTO cellDTO) {
        cellFacade.remove(cellFacade.find(cellDTO.getId()));
    }

    @Override
    public CellDTO getCellToEdit(Long cellId) {
        cellEdit = cellFacade.find(cellId);
        cellFacade.refresh(cellEdit);
        try {
            cellFacade.lock(cellEdit, LockModeType.WRITE);
        } catch (OptimisticLockException ex) {
            //optymistyczna blokada
            Logger.getLogger(CellEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }

        CellDTO cellDTO = new CellDTO();

        CellConverter.convertCellToDTO(cellEdit, cellDTO);
        return cellDTO;
    }

    @Override
    public void saveCellAfterEdit(CellDTO cellDTO) {
        if (null == cellEdit) {
            throw new IllegalArgumentException("Proba zapisania rekordu bez formularza edycji");
        }
        if (!cellEdit.getId().equals(cellDTO.getId())) {
            throw new IllegalArgumentException("Proba edycji innego rekordu niż pobrane do edycji");
        }
        CellConverter.convertCellToEntityAfterEdit(cellDTO, cellEdit);
        cellFacade.edit(cellEdit);
        
    }

    @Override
    public CellDTO findById(Long cellId) {
        Cell tmp = cellFacade.find(cellId);
        CellDTO val = new CellDTO();
        CellConverter.convertCellToDTO(tmp, val);
        return val;
    }

}
