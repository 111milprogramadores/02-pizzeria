/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.pizzeria.dao;

import poo.pizzeria.EstadoPedido;

/**
 *
 * @author joaquinleonelrobles
 */
public interface EstadosPedidoDao {
    
    public EstadoPedido buscarPorNombre (String nombre);
    
}
