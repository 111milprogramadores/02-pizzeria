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
import poo.pizzeria.Factura;

/**
 *
 * @author joaquinleonelrobles
 */
public class FacturasDaoHibernateImpl implements FacturasDao {
    
    private final SessionFactory sessionFactory;

    public FacturasDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long obtenerProximoNumero() {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        Root<Factura> root = query.from(Factura.class);
        query.select(builder.max(root.get("numero")));
        
        Long proximo = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return (proximo == null) ? 1 : proximo + 1;
    }

    @Override
    public void guardar(Factura factura) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(factura);
        session.getTransaction().commit();
        session.close();
    }
    
}
