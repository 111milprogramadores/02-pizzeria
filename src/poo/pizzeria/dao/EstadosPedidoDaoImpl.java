/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import poo.pizzeria.EstadoPedido;

/**
 *
 * @author joaquinleonelrobles
 */
public class EstadosPedidoDaoImpl implements EstadosPedidoDao {
    
    private final List<EstadoPedido> estados;

    public EstadosPedidoDaoImpl() {
        this.estados = new ArrayList<>();
        
        // agregamos los estados iniciales
        this.estados.add(new EstadoPedido("Pendiente de Facturación", "El Pedido se encuentra listo sin Factura generada"));
        this.estados.add(new EstadoPedido("Facturado", "El Pedido se encuentra Facturado"));
    }

    @Override
    public EstadoPedido buscarPorNombre(String nombre) {
        EstadoPedido retorno = null;
        
        Iterator<EstadoPedido> iter = estados.iterator();
        while (iter.hasNext()) {
            EstadoPedido actual = iter.next();
            
            if (actual.getNombre().equals(nombre)) {
                retorno = actual;
                break;
            }
        }
        
        return retorno;
    }
    
}
