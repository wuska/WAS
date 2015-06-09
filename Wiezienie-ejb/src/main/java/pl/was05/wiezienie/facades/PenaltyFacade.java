/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.was05.wiezienie.entities.Penalty;

/**
 *
 * @author Kawa
 */
@Stateless
public class PenaltyFacade extends AbstractFacade<Penalty> {
    @PersistenceContext(unitName = "was05punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PenaltyFacade() {
        super(Penalty.class);
    }
    
}
