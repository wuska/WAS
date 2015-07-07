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

    public void lock(Penalty penalty, LockModeType lockModeType) {
        getEntityManager().lock(penalty, lockModeType);

    }

    public Penalty findByName(String name) {
        
        TypedQuery tq = getEntityManager().createNamedQuery("Penalty.findByName", Penalty.class);
        tq.setParameter("name", name);
        return (Penalty) tq.getSingleResult();
    }

    public List<Penalty> findByNameLike(String name) {
        
        String namex = "%"+name+"%";
        System.err.println("findByName name: " + namex);
        TypedQuery<Penalty> tq
                = em.createQuery("SELECT u FROM Penalty u WHERE u.name like :name", Penalty.class);
        tq.setParameter("name", namex);
        System.err.println("findByName name: " + tq.getResultList().toString());
        return tq.getResultList();

    }
}
