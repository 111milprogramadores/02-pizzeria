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
import poo.pizzeria.EstadoPedido;

/**
 *
 * @author joaquinleonelrobles
 */
public class EstadosPedidoDaoHibernateImpl implements EstadosPedidoDao {
    
    private final SessionFactory sessionFactory;

    public EstadosPedidoDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public EstadoPedido buscarPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EstadoPedido> query = builder.createQuery(EstadoPedido.class);
        Root<EstadoPedido> root = query.from(EstadoPedido.class);
        query.select(root);
        query.where(builder.equal(root.get("nombre"), nombre));
        
        EstadoPedido estado = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return estado;
    }
    
}
