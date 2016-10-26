/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import poo.pizzeria.DetallePedido;
import poo.pizzeria.EstadoPedido;
import poo.pizzeria.Pedido;
import poo.pizzeria.Pizza;

/**
 *
 * @author joaquinleonelrobles
 */
public class PedidosDaoImpl implements PedidosDao {
    
    private final List<Pedido> pedidos;

    public PedidosDaoImpl(PizzasDao pizzasDao, EstadosPedidoDao estadosDao) {
        this.pedidos = new ArrayList<>();
        Calendar ahora = Calendar.getInstance();
        
        // obtenemos el estado del pedido Pendiente de Facturación.
        EstadoPedido pteFacturacion = estadosDao.buscarPorNombre("Pendiente de Facturación");
        
        // obtenemos las pizzas
        Pizza napolitanaNormal = pizzasDao.buscarPorNombre("Napolitana Normal");
        Pizza especialGrande = pizzasDao.buscarPorNombre("Especial Grande");
        Pizza mozzarellaMediana = pizzasDao.buscarPorNombre("Mozzarella Mediana");
        
        // Creamos un pedido que todavía no ha sido facturado.
        Pedido pedido = new Pedido();
        ahora.add(Calendar.MINUTE, -55); 
        pedido.setFechaHoraCreacion(ahora.getTime());
        ahora.add(Calendar.MINUTE, -45);  
        pedido.setFechaHoraEntrega(ahora.getTime());
        pedido.setNombreCliente("María Cortez");
        pedido.setNumero(1);
        pedido.setEstado(pteFacturacion);

        // Creamos los detalles del pedido para luego asignarselos al pedido.
        DetallePedido pDetalle1 = new DetallePedido(3,napolitanaNormal.getPrecio(), napolitanaNormal, pteFacturacion);
        DetallePedido pDetalle2 = new DetallePedido(1,especialGrande.getPrecio(), especialGrande, pteFacturacion);
        DetallePedido pDetalle3 = new DetallePedido(3,mozzarellaMediana.getPrecio(), mozzarellaMediana, pteFacturacion);

        // Creamos una lista y le asignamos los detalles.
        ArrayList<DetallePedido> detallesPedido = new ArrayList<>();
        detallesPedido.add(pDetalle1);
        detallesPedido.add(pDetalle2);
        detallesPedido.add(pDetalle3);

        // Asignamos la lista de detalles al pedido.
        pedido.setDetallesPedido(detallesPedido);

        // Creamos otro pedido que todavía no ha sido facturado.
        Pedido pedido2 = new Pedido();
        pedido2.setFechaHoraCreacion(ahora.getTime());
        ahora.add(Calendar.MINUTE, -55);  
        pedido2.setFechaHoraEntrega(ahora.getTime());
        pedido2.setNombreCliente("Carmen López");
        pedido2.setNumero(2);
        pedido2.setEstado(pteFacturacion);

        // Creamos los detalles del pedido para luego asignarselos al pedido.
        DetallePedido p2Detalle1 = new DetallePedido(2,napolitanaNormal.getPrecio(), napolitanaNormal,pteFacturacion);
        DetallePedido p2Detalle2 = new DetallePedido(3,especialGrande.getPrecio(), especialGrande,pteFacturacion);
        DetallePedido p2Detalle3 = new DetallePedido(1,mozzarellaMediana.getPrecio(), mozzarellaMediana,pteFacturacion);       

        // Creamos una lista y le asignamos los detalles.
        ArrayList<DetallePedido> detallesPedido2 = new ArrayList<>();
        detallesPedido2.add(p2Detalle1);
        detallesPedido2.add(p2Detalle2);
        detallesPedido2.add(p2Detalle3);

        // Asignamos la lista de detalles al pedido.
        pedido2.setDetallesPedido(detallesPedido2);

        // Creamos otro pedido que todavía no ha sido facturado.
        Pedido pedido3= new Pedido();
        pedido3.setFechaHoraCreacion(ahora.getTime());
        ahora.add(Calendar.MINUTE, -55);  
        pedido3.setFechaHoraEntrega(ahora.getTime());
        pedido3.setNombreCliente("Juan Ferreyra");
        pedido3.setNumero(3);
        pedido3.setEstado(pteFacturacion);

        // Creamos los detalles del pedido para luego asignarselos al pedido.
        DetallePedido p3Detalle1 = new DetallePedido(1,napolitanaNormal.getPrecio(), napolitanaNormal,pteFacturacion);
        DetallePedido p3Detalle2 = new DetallePedido(1,especialGrande.getPrecio(), especialGrande,pteFacturacion);     

        // Creamos una lista y le asignamos los detalles.
        ArrayList<DetallePedido> detallesPedido3 = new ArrayList<>();
        detallesPedido3.add(p3Detalle1);
        detallesPedido3.add(p3Detalle2);

        // Asignamos la lista de detalles al pedido.
        pedido3.setDetallesPedido(detallesPedido3);

        // Armamos una lista con todos los pedidos.
        pedidos.add(pedido);
        pedidos.add(pedido2);
        pedidos.add(pedido3);
    }

    @Override
    public List<Pedido> buscarPendientesDeFacturacion() {
        List<Pedido> retorno = new ArrayList<>();
        
        Iterator<Pedido> iter = pedidos.iterator();
        while (iter.hasNext()) {
            Pedido actual = iter.next();
            
            if (actual.esPteFacturacion()) {
                retorno.add(actual);
            }
        }
        
        return retorno;
    }
    
}
