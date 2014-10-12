/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.example;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Pawel
 */
@Stateless
public class DbuserFacade extends AbstractFacade<Dbuser> {
    @PersistenceContext(unitName = "jpa.example_JPA-test2-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DbuserFacade() {
        super(Dbuser.class);
    }
    
}
