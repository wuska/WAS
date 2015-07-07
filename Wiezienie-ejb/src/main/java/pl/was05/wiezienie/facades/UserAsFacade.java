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
import pl.was05.wiezienie.entities.User;
import pl.was05.wiezienie.entities.UserAssociation;

/**
 *
 * @author java
 */
@Stateless
public class UserAsFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "was05punit")
   private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserAsFacade() {
        super(User.class);
    }
    
    @Override
   public void remove(User u){
       for (UserAssociation x : u.getRoles()){
           em.remove(x);
       }
   }
    
}
