/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import poo.pizzeria.EstadoFactura;
import poo.pizzeria.EstadoPedido;
import poo.pizzeria.Factura;
import poo.pizzeria.Pedido;
import poo.pizzeria.dao.EstadosFacturaDao;
import poo.pizzeria.dao.EstadosFacturaDaoHibernateImpl;
import poo.pizzeria.dao.FacturasDao;
import poo.pizzeria.dao.PedidosDao;
import poo.pizzeria.dao.EstadosPedidoDao;
import poo.pizzeria.dao.EstadosPedidoDaoHibernateImpl;
import poo.pizzeria.dao.FacturasDaoHibernateImpl;
import poo.pizzeria.dao.PedidosDaoHibernateImpl;
import poo.pizzeria.ui.ImpresorFactura;
import poo.pizzeria.ui.PantallaFacturacion;

/**
 *
 * @author Candelaria
 */
public class GestorFacturacion {
    
    private final SessionFactory sessionFactory;
    
    private final PedidosDao pedidosDao;
    private final EstadosPedidoDao estadosPedidoDao;
    private final EstadosFacturaDao estadosFacturaDao;
    private final FacturasDao facturasDao;
    
    private Pedido pedido;

    /**
     * Constructor por defecto.
     * @param sessionFactory
     */
    public GestorFacturacion(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        
        // creamos las instancias de los objetos de acceso a datos
        this.estadosPedidoDao = new EstadosPedidoDaoHibernateImpl(sessionFactory);
        this.estadosFacturaDao = new EstadosFacturaDaoHibernateImpl(sessionFactory);
        this.pedidosDao = new PedidosDaoHibernateImpl(estadosPedidoDao, sessionFactory);
        this.facturasDao = new FacturasDaoHibernateImpl(sessionFactory);
    }

    public void run () {
        new PantallaFacturacion(this).setVisible(true);
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public List<Pedido> buscarPedidosPtesFacturacion () {
        return pedidosDao.buscarPendientesDeFacturacion();
    }
    
    public void generarFactura () {
        // buscamos las entidades relacionadas
        long numero = facturasDao.obtenerProximoNumero();
        EstadoFactura generada = estadosFacturaDao.buscarPorNombre("Generada");
        EstadoPedido facturado = estadosPedidoDao.buscarPorNombre("Facturado");
        Date ahora = Calendar.getInstance().getTime();
        
        // creamos la factura para el pedido
        Factura factura = new Factura(ahora, numero, generada, pedido.getDetallesPedido());
        
        // guardamos la factura en el repositorio de datos
        facturasDao.guardar(factura);
        
        // facturamos el pedido
        pedido.facturar (factura, facturado);
        pedidosDao.guardar(pedido);
    }

    public void imprimir(Pedido pedido) {
        new ImpresorFactura(pedido).setVisible(true);
    }
    
    public void iniciarGenerarReporte () {
        new GestorReporte(sessionFactory).run();
    }

}
