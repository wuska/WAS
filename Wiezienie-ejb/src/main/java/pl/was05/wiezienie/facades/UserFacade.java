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

/**
 *
 * @author java
 */
@Stateless
public class UserFacade extends AbstractFacade<User> {
    @PersistenceContext(unitName = "was05punit")
   private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }
    
    public User findByLogin(String login) {
        TypedQuery tq = getEntityManager().createNamedQuery("User.findByLogin", User.class);
        tq.setParameter("login", login);
        return (User) tq.getSingleResult();
    }
    
    public void lock(User user,LockModeType lockModeType){
        getEntityManager().lock(user, lockModeType);
        
    }
    
    protected Long getIdByLogin(String login){
        return findByLogin(login).getId();
    }
    
}
