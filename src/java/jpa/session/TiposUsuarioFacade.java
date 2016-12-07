/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.TiposUsuario;

/**
 *
 * @author Cyntia Yomally Osorno López
 * @author Cesar Gibran Cadena Espinoza
 * @author Hever Luis Alvarez Carmona
 * @author Albaro Tonatihu Fabian Silverio
 * @author Jhonatan Saúl Ramírez Bravo
 * @version 06/12/2016
 * 
 */
@Stateless
public class TiposUsuarioFacade extends AbstractFacade<TiposUsuario> {

    @PersistenceContext(unitName = "JueguitosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposUsuarioFacade() {
        super(TiposUsuario.class);
    }
    
}
