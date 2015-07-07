/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.was05.wiezienie.entities.Cell;

/**
 *
 * @author Kawa
 */
@Stateless
public class CellFacade extends AbstractFacade<Cell> {

    @PersistenceContext(unitName = "was05punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CellFacade() {
        super(Cell.class);
    }

    public void lock(Cell cell, LockModeType lockModeType) {
        getEntityManager().lock(cell, lockModeType);

    }

    public List<Cell> findByIdLike(Long id) {

        TypedQuery<Cell> tq
                = em.createQuery("SELECT u FROM Cell u WHERE u.id >= :id", Cell.class);
        tq.setParameter("id", id);
        return tq.getResultList();

    }

}
