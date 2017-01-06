/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import poo.pizzeria.EstadoFactura;
import poo.pizzeria.EstadoPedido;
import poo.pizzeria.Factura;
import poo.pizzeria.Pedido;
import poo.pizzeria.dao.EstadosFacturaDao;
import poo.pizzeria.dao.EstadosFacturaDaoImpl;
import poo.pizzeria.dao.EstadosPedidoDaoImpl;
import poo.pizzeria.dao.FacturasDao;
import poo.pizzeria.dao.FacturasDaoImpl;
import poo.pizzeria.dao.PedidosDao;
import poo.pizzeria.dao.PedidosDaoImpl;
import poo.pizzeria.dao.PizzasDao;
import poo.pizzeria.dao.PizzasDaoImpl;
import poo.pizzeria.dao.TamaniosDao;
import poo.pizzeria.dao.TamaniosDaoImpl;
import poo.pizzeria.dao.TiposDao;
import poo.pizzeria.dao.TiposDaoImpl;
import poo.pizzeria.dao.VariedadesDao;
import poo.pizzeria.dao.VariedadesDaoImpl;
import poo.pizzeria.dao.EstadosPedidoDao;
import poo.pizzeria.ui.ImpresorFactura;
import poo.pizzeria.ui.PantallaFacturacion;

/**
 *
 * @author Candelaria
 */
public class GestorFacturacion {
    
    private final PedidosDao pedidosDao;
    private final PizzasDao pizzasDao;
    private final EstadosPedidoDao estadosPedidoDao;
    private final EstadosFacturaDao estadosFacturaDao;
    private final TiposDao tiposDao;
    private final VariedadesDao variedadesDao;
    private final TamaniosDao tamaniosDao;
    private final FacturasDao facturasDao;
    
    private Pedido pedido;

    /**
     * Constructor por defecto.
     */
    public GestorFacturacion() {
        // creamos las instancias de los objetos de acceso a datos
        this.tiposDao = new TiposDaoImpl();
        this.variedadesDao = new VariedadesDaoImpl();
        this.tamaniosDao = new TamaniosDaoImpl();
        this.pizzasDao = new PizzasDaoImpl(tiposDao, variedadesDao, tamaniosDao);
        this.estadosPedidoDao = new EstadosPedidoDaoImpl();
        this.estadosFacturaDao = new EstadosFacturaDaoImpl();
        this.pedidosDao = new PedidosDaoImpl(pizzasDao, estadosPedidoDao);
        this.facturasDao = new FacturasDaoImpl();
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
        int numero = facturasDao.obtenerProximoNumero();
        EstadoFactura generada = estadosFacturaDao.buscarPorNombre("Generada");
        EstadoPedido facturado = estadosPedidoDao.buscarPorNombre("Facturado");
        Date ahora = Calendar.getInstance().getTime();
        
        // creamos la factura para el pedido
        Factura factura = new Factura(ahora, numero, generada, pedido.getDetallesPedido());
        
        // facturamos el pedido
        pedido.facturar (factura, facturado);
        
        // guardamos la factura en el repositorio de datos
        facturasDao.guardar(factura);
    }

    public void imprimir(Pedido pedido) {
        new ImpresorFactura(pedido).setVisible(true);
    }
         
}
