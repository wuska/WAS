/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.cell;

import java.util.List;
import javax.ejb.Stateful;
import pl.was05.wienzienie.dto.CellDTO;

/**
 *
 * @author zar
 */
@Stateful
public class CellEndpoint implements CellEndpointLocal {

    @Override
    public List<CellDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



  


}
