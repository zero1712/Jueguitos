/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Noticias;

/**
 *
 * @author CYNTIA OSORNO
 */
@Stateless
public class NoticiasFacade extends AbstractFacade<Noticias> {

    @PersistenceContext(unitName = "JueguitosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoticiasFacade() {
        super(Noticias.class);
    }
    
}
