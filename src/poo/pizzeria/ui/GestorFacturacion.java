/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import poo.pizzeria.Pedido;
import poo.pizzeria.dao.EstadosDao;
import poo.pizzeria.dao.EstadosDaoImpl;
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
import poo.pizzeria.ui.PantallaFacturacion;

/**
 *
 * @author Candelaria
 */
public class GestorFacturacion {
    
    private final PedidosDao pedidosDao;
    private final PizzasDao pizzasDao;
    private final EstadosDao estadosDao;
    private final TiposDao tiposDao;
    private final VariedadesDao variedadesDao;
    private final TamaniosDao tamaniosDao;

    /**
     * Constructor por defecto.
     */
    public GestorFacturacion() {
        // creamos las instancias de los objetos de acceso a datos
        this.tiposDao = new TiposDaoImpl();
        this.variedadesDao = new VariedadesDaoImpl();
        this.tamaniosDao = new TamaniosDaoImpl();
        this.pizzasDao = new PizzasDaoImpl(tiposDao, variedadesDao, tamaniosDao);
        this.estadosDao = new EstadosDaoImpl();
        this.pedidosDao = new PedidosDaoImpl(pizzasDao, estadosDao);
    }

    public void run () {
        List<Pedido> pedidosPendientes = pedidosDao.buscarPendientesDeFacturacion();
        
        new PantallaFacturacion(pedidosPendientes, this).setVisible(true);
    }
         
}
