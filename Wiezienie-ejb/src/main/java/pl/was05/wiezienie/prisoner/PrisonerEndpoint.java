/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.prisoner;

import java.util.List;
import javax.ejb.Stateful;
import pl.was05.wienzienie.dto.PrisonerDTO;

/**
 *
 * @author zar
 */
@Stateful
public class PrisonerEndpoint implements PrisonerEndpointLocal {


    @Override
    public List<PrisonerDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  


}
