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
import poo.pizzeria.Pizza;

/**
 *
 * @author joaquinleonelrobles
 */
public class PizzasDaoHibernateImpl implements PizzasDao {
    
    private final SessionFactory sessionFactory;

    public PizzasDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Pizza buscarPorNombre(String nombre) {
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pizza> query = builder.createQuery(Pizza.class);
        Root<Pizza> root = query.from(Pizza.class);
        query.select(root);
        query.where(builder.equal(root.get("nombre"), nombre));
        
        Pizza pizza = session.createQuery(query).uniqueResult();
        
        session.close();
        
        return pizza;
    }
    
}
