/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.was05.wiezienie.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.was05.wiezienie.entities.Role;
import pl.was05.wiezienie.entities.User;

/**
 *
 * @author java
 */
@Stateless
public class RoleFacade extends AbstractFacade<Role> {

    @PersistenceContext(unitName = "was05punit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RoleFacade() {
        super(Role.class);
    }

    public Role findByName(String roleName) {
        TypedQuery tq = getEntityManager().createNamedQuery("User.findByName", User.class);
        tq.setParameter("roleName", roleName);
        return (Role) tq.getSingleResult();
    }

    public List<Role> findByNameLike(String name) {
        String namex = "%" + name + "%";
        System.err.println("Role findByName name: " + namex);
        TypedQuery<Role> tq   
                = em.createQuery("SELECT u FROM Role u WHERE u.groupName like :name", Role.class);
        tq.setParameter("name", namex);
        return tq.getResultList();
    }

}
