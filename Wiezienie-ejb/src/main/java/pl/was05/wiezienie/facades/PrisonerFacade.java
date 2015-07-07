/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.was05.wiezienie.entities.Prisoner;

/**
 *
 * @author Kawa
 */
@Stateless
public class PrisonerFacade extends AbstractFacade<Prisoner> {
    @PersistenceContext(unitName = "was05punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrisonerFacade() {
        super(Prisoner.class);
    }
    public void lock(Prisoner prisoner,LockModeType lockModeType){
        getEntityManager().lock(prisoner, lockModeType);
        
    }
     public int countInCell(Long idCell){
        TypedQuery<Prisoner> tq
                = em.createQuery("SELECT u FROM Prisoner u WHERE u.cellId = :id ", Prisoner.class);
        tq.setParameter("id", idCell);
        return tq.getResultList().size();
        
    }
}
