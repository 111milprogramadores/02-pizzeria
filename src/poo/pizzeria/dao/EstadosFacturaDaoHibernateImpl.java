/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.pizzeria.EstadoFactura;

/**
 *
 * @author joaquinleonelrobles
 */
public class EstadosFacturaDaoHibernateImpl implements EstadosFacturaDao {
    
    private final SessionFactory sessionFactory;

    public EstadosFacturaDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public EstadoFactura buscarPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EstadoFactura> query = builder.createQuery(EstadoFactura.class);
        Root<EstadoFactura> root = query.from(EstadoFactura.class);
        query.select(root);
        query.where(builder.equal(root.get("nombre"), nombre));
        
        EstadoFactura estado = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return estado;
    }
    
}
