/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import poo.pizzeria.EstadoPedido;
import poo.pizzeria.Pedido;

/**
 *
 * @author joaquinleonelrobles
 */
public class PedidosDaoHibernateImpl implements PedidosDao {
    
    private final SessionFactory sessionFactory;
    private final EstadosPedidoDao estadosDao;

    public PedidosDaoHibernateImpl(EstadosPedidoDao estadosDao, SessionFactory sessionFactory) {
        this.estadosDao = estadosDao;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Pedido> buscarPendientesDeFacturacion() {
        // obtenemos el estado del pedido Pendiente de Facturación.
        EstadoPedido pteFacturacion = estadosDao.buscarPorNombre("Pendiente de Facturación");
        
        Session session = sessionFactory.openSession();
        
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Pedido> query = builder.createQuery(Pedido.class);
        Root<Pedido> root = query.from(Pedido.class);
        query.select(root);
        query.where(builder.equal(root.get("estado"), pteFacturacion));
        
        List<Pedido> pedidos = session.createQuery(query).list();
        
        session.close();
        
        return pedidos;
    }

    @Override
    public void guardar(Pedido pedido) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(pedido);
        session.getTransaction().commit();
        session.close();
    }
    
}
